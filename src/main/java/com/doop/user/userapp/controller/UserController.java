package com.doop.user.userapp.controller;

import com.doop.user.userapp.entity.User;
import com.doop.user.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userapp")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public int findOrCreateUser(@RequestBody User user){
        return service.findOrCreateUser(user);
    }

    @PostMapping("/auth")
    public User authenticate(@RequestBody String token)
    {
        return service.authAndGetUser(token);
    }
}
