package com.example.RegisterService;

import org.springframework.stereotype.Service;


public interface UserServices {
    String addUser(Users users);
    int ValidateUserByEmail (String email, String password);
    int ValidateUserByUsername (String email, String password);
}
