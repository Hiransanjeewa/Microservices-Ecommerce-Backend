package com.example.LoginService.client;


import com.example.LoginService.LoginUser;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;


@HttpExchange
public interface TestingClient{

    @PostExchange("/ecommerce/loginwithemail")
    public String ValidateUserWithEmail(@RequestBody  LoginUser loginUser) ;

}