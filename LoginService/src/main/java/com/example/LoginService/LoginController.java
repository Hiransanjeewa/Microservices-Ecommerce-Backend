package com.example.LoginService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")
public class LoginController {

    @Autowired
    LoginServices loginServices;

    @PostMapping("/login")
    public String loginWithCredentials(@RequestBody String email, String password){

        int validatedId = loginServices.validateCredentials(email,password);
        if ( validatedId !=0){
            return loginServices.createSessionId(validatedId);
        }else {
            return "Email or password incorrect";
        }
    }


}
