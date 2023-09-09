package com.example.RegisterService.client;

import com.example.LoginService.LoginUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;


@HttpExchange
public interface LoginServiceClient {

    @PostExchange("/login/test")
    public ResponseEntity<LoginUser> getLoginUserClass();

}
