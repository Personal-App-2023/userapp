package com.doop.user.userapp.service;

import com.doop.user.userapp.entity.User;
import com.doop.user.userapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    UserSequenceGenerator generator;

    public int findOrCreateUser(User user)
    {
        List<User> users=repo.findByEmail(user.getEmail());

        if(users!=null && users.size()>0)
        {
            user=users.get(0);
        }
        else{
            Integer userId=generator.generateNextUserId();
            user.setUserId(userId);
            user=repo.save(user);
        }
        return user.getUserId();
    }

    public User authAndGetUser(String token)
    {
        AuthUser authUser=fetchUserByToken(token);
        List<User> users=repo.findByEmail(authUser.getEmail());

        User user=null;
        if(users!=null && users.size()>0)
        {
            user=users.get(0);
        }
        else{
            user=new User();
            Integer userId=generator.generateNextUserId();
            user.setUserId(userId);
            user.setName(authUser.getName());
            user.setEmail(authUser.getEmail());
            user=repo.save(user);
        }
        return user;
    }

    private AuthUser fetchUserByToken(String token) {
        String uri="https://www.googleapis.com/oauth2/v3/userinfo?access_token="+token;
        HttpEntity<String> entity = new HttpEntity<>("body", createGAPIHeaders(token));
        ResponseEntity<AuthUser> result= restTemplate.exchange(uri, HttpMethod.GET, entity, AuthUser.class);
        return result.getBody();
        /*return restTemplate.exchange
                (uri, HttpMethod.GET, new HttpEntity<T>(createGAPIHeaders(token)), AuthUser.class);
                */
    }
}
