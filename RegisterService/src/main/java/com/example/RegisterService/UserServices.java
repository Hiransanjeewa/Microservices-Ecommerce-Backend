package com.example.RegisterService;

public interface UserServices {
    String addUser(Users users);
    String getUserByEmail (String email);
    String getUserByUsername (String username);
}
