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
    public String ValidateUserByEmail(String email, String password) {
        if (userRepo.ValidateUsersByEmail(email,password)>0){
            return "active user";
        }else {
            return "user not active";
        }

    }

    @Override
    public String ValidateUserByUsername(String username, String password) {
        if (userRepo.ValidateUsersByName(username,password)>0){
            return "active user";
        }else {
            return "user not active";
        }
    }
}
