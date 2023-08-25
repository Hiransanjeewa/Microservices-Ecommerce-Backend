package com.example.LoginService;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")
public class LoginController {

    private static  final logger LOGGER = ILoggerFactory.getLogger(LoginController.class);


    @Autowired
    LoginServices loginServices;



    @PostMapping("/login")
    public String loginWithCredentials(@RequestBody String email, String password){

        Logger.info("validated login credentials : email={}",email);


        int validatedId = loginServices.validateCredentials(email,password);
        if ( validatedId !=0){
            return loginServices.createSessionId(validatedId);
        }else {
            return "Email or password incorrect";
        }
    }


}
