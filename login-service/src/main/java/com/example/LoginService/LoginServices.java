package com.example.LoginService;

import java.io.UnsupportedEncodingException;


public interface LoginServices {
    String createSessionId(int userid);

    String validateCredentials(LoginUser loginUser) throws UnsupportedEncodingException;

    String testing(LoginUser loginUser);
}
