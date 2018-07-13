package com.edel.event.controller;

import com.edel.event.UserRepo;
import com.edel.event.dao.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jitheshrajan on 4/23/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users = this.userRepo.findAll();
        return users;
    }

    @PutMapping
    public User insertUser(@RequestBody User user)
    {
        return this.userRepo.insert(user);
    }

}
