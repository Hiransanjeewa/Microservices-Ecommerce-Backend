package com.example.LoginService.client;


import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


@HttpExchange
public interface TestingClient{

    @GetExchange("/ecommerce/test")
    public String test() ;

}