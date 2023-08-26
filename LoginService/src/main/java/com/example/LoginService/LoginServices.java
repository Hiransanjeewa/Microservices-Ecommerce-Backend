package com.example.LoginService;

import java.io.UnsupportedEncodingException;

public interface LoginServices {
    String createSessionId(int userid);

    int validateCredentials(String email, String password) throws UnsupportedEncodingException;
}
