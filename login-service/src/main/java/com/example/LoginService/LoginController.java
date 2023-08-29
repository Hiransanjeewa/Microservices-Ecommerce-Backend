package com.example.LoginService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());


    LoginServices loginServices = new LoginServicesImpl();


    @PostMapping("/")
    public String loginWithCredentials(@RequestBody LoginUser loginuser) throws UnsupportedEncodingException {



        logger.info("login user account: email={}", loginuser.getEmail());

        int validatedId = loginServices.validateCredentials(loginuser);
        if ( validatedId !=0){
            return loginServices.createSessionId(validatedId);
        }else {
            return "Email or password incorrect";
        }


    }
    @GetMapping("/")
    public String loginWithCredentials() throws UnsupportedEncodingException {
    }


}
