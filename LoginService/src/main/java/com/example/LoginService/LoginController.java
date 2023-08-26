package com.example.LoginService;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/ecommerce")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());



    private  LoginServices loginServices;



    @PostMapping("/login")
    public String loginWithCredentials(@RequestBody String email, String password) throws UnsupportedEncodingException {

        logger.info("login user account: email={}", email);

        int validatedId = loginServices.validateCredentials(email,password);
        if ( validatedId !=0){
            return loginServices.createSessionId(validatedId);
        }else {
            return "Email or password incorrect";
        }



    }


}
