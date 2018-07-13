package com.edel.event;

import com.edel.event.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitheshrajan on 4/23/18.
 */
@Component
public class UserDataFeeder implements CommandLineRunner {

    private UserRepo userRepo;

    @Autowired
    public UserDataFeeder(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args){
//        List<User> listOfUsers = new ArrayList<User>();
//
//        listOfUsers.add(User.builder().email("JITHESH.PODUVAL@EDELWEISSFIN.COM")
//                .createdAt(System.currentTimeMillis())
//                .name("JITHESH RAJAN")
//                .severityAccessLevel(0)
//                .build());
//
//        listOfUsers.add(User.builder().email("SYED.HAIDER@EDELWEISSFIN.COM")
//                .createdAt(System.currentTimeMillis())
//                .name("SYED HAIDER")
//                .severityAccessLevel(1)
//                .build());
//
//        listOfUsers.add(User.builder().email("HARSHA.SHEKAR@EDELWEISSFIN.COM")
//                .createdAt(System.currentTimeMillis())
//                .name("HARSHA SHEKAR")
//                .severityAccessLevel(0)
//                .build());
//
//
//        // deleting if these users already exists!
//        userRepo.deleteAll(userRepo.findAll());
//
//
//        userRepo.saveAll(listOfUsers);
    }
}
