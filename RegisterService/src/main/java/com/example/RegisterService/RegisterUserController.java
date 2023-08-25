package com.example.RegisterService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;



@RestController
@RequestMapping("/ecommerce")
public class RegisterUserController {





    @Autowired
    private  UserServices userServices;

    @PostMapping(path = "/register")
    public String saveUser(@RequestBody Users users) throws UnsupportedEncodingException {
        System.out.println("Request received");
        var response = userServices.addUser(users);
        return response;
    }



}
