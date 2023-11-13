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
}
