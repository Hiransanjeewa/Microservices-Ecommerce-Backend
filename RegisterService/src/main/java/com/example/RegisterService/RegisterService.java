package com.example.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegisterService implements UserServices{

    @Autowired
    private  UserRepo userRepo;

    @Override
    public String addUser(Users users) {
        if (userRepo.getUsersByEmail(users.getEmail())>0||userRepo.getUsersByName(users.getUsername())>0){
            return "registration unsuccessful";
        }else {
            userRepo.save(users);
            return "User added successfully";
        }

    }

    @Override
    public String getUserByEmail(String email) {
        if (userRepo.getUsersByEmail(email)>0){
            return "active user";
        }else {
            return "user not active";
        }

    }

    @Override
    public String getUserByUsername(String username) {
        if (userRepo.getUsersByName(username)>0){
            return "active user";
        }else {
            return "user not active";
        }
    }
}
