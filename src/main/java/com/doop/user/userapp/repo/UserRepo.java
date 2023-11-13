package com.doop.user.userapp.repo;

import com.doop.user.userapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User,Integer> {

    List<User> findByEmail(String email);
}
