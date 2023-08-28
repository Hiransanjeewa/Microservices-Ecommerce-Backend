package com.example.LoginService;

import java.io.UnsupportedEncodingException;


public interface LoginServices {
    String createSessionId(int userid);

    int validateCredentials(LoginUser loginUser) throws UnsupportedEncodingException;
}
