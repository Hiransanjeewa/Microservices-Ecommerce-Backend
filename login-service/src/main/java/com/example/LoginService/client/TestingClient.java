package com.example.LoginService.client;


import com.example.LoginService.LoginUser;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;


@HttpExchange
public interface TestingClient{

    @PostExchange("/ecommerce/test")
    public String test(@RequestBody LoginUser loginUser) ;

}