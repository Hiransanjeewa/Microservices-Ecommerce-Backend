package com.example.LoginService;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginServicesImpl implements LoginServices{

    @Autowired
    LoginRepo loginRepo;


    @Override
    public String createSessionId(int userid) {

        return loginRepo.getSessionToken(userid).toString();

    }

    @Override
    public int validateCredentials(String email, String password) {

        return false;
    }
}
