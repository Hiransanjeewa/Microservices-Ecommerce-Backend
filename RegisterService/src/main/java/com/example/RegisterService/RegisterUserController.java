package com.example.RegisterService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;



@RestController
@RequestMapping("/ecommerce")
public class RegisterUserController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private  UserServices userServices;



    @PostMapping(path = "/register")
    public String saveUser(@RequestBody Users users) throws UnsupportedEncodingException {
        System.out.println("Request received");
        Logger.info("creating user account : email={}",users.getEmail());

        var response = userServices.addUser(users);
        return response;
    }

    @PostMapping(path = "/loginwithusername")
    public String ValidateUserWithUsername(@RequestBody String username,String password) throws UnsupportedEncodingException {
//        System.out.println("Request received");
        Logger.info("validated login credentials : username={}",username);

        var response = userServices.ValidateUserByUsername(username, password);
        return response;
    }

    @PostMapping(path = "/loginwithemail")
    public String ValidateUserWithEmail(@RequestBody String email,String password) throws UnsupportedEncodingException {
//        System.out.println("Request received");
        Logger.info("validated login credentials : email={}",email);

        var response = userServices.ValidateUserByEmail(email, password);
        return response;
    }


}
