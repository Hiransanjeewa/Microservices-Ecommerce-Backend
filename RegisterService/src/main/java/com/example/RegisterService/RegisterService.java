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
    public int ValidateUserByEmail(String email, String password) {
        int userid= userRepo.ValidateUsersByEmail(email,password);
        if (userid>0){
            return userid;
        }else {
            return 0;
        }

    }

    @Override
    public int ValidateUserByUsername(String username, String password) {
        int userid = userRepo.ValidateUsersByName(username,password);
        if (userid>0){
            return userid;
        }else {
            return 0;
        }
    }
}
