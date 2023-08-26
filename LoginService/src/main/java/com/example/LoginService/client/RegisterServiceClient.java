package com.example.LoginService.client;


import com.example.LoginService.LoginUser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.io.UnsupportedEncodingException;

@HttpExchange   // Declarative client
public interface RegisterServiceClient {

//    @PostExchange("/ecommerce/loginwithusername")
//    public int ValidateUserWithUsername(@RequestBody String username, String password) throws UnsupportedEncodingException;

    @PostExchange("/ecommerce/loginwithemail")
    public int ValidateUserWithEmail(@RequestBody LoginUser loginUser) throws UnsupportedEncodingException ;


    }