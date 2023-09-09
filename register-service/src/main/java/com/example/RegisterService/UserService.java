package com.example.RegisterService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserService {

    private RestTemplate restTemplate;
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getLoginUserClass(){
        String url = "http://login-service/login/login";
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);
        return responseEntity.getBody();

    }


}
