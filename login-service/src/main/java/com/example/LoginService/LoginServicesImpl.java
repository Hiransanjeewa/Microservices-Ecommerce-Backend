package com.example.LoginService;


import com.example.LoginService.client.RegisterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class LoginServicesImpl implements LoginServices{

    @Autowired
    private  LoginRepo loginRepo;


    @Autowired
    private RegisterServiceClient registerServiceWebClient;

    @Override
    public String createSessionId(int userid) {
        int length = 5;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder sessionKey = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sessionKey.append(randomChar);
        }
        logins loginUser= new logins();
        loginUser.setUser_id(userid);
        loginUser.setSession_token(sessionKey.toString());
        loginRepo.save(loginUser);
        return sessionKey.toString();
    }
    @Override
    public int validateCredentials(LoginUser loginUser) throws UnsupportedEncodingException {
        return registerServiceWebClient.ValidateUserWithEmail(loginUser);
    }
}
