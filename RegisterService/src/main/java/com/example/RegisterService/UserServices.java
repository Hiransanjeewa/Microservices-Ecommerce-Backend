package com.example.RegisterService;

public interface UserServices {
    String addUser(Users users);
    String ValidateUserByEmail (String email, String password);
    String ValidateUserByUsername (String email, String password);
}
