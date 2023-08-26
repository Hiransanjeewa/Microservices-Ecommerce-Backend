package com.example.RegisterService;

public interface UserServices {
    String addUser(Users users);
    int ValidateUserByEmail (String email, String password);
    int ValidateUserByUsername (String email, String password);
}
