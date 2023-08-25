package com.example.LoginService;

public interface LoginServices {
    String createSessionId(int userid);

    int validateCredentials(String email, String password);
}
