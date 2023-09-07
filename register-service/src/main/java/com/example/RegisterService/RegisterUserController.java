package com.example.RegisterService;


import com.example.LoginService.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;



@RestController
@RequestMapping("/ecommerce")
public class RegisterUserController {



    @Autowired
    private  UserServices userServices;

   // Logger logger = LoggerFactory.getLogger(getClass());



    @PostMapping(path = "/register")
    public  String saveUser(@RequestBody Users users) throws UnsupportedEncodingException {
        System.out.println("Request received");
       // String email=users.getEmail()

   //     logger.info("creating user account: email={}", users.getEmail());

//        Logger.info("creating user account : email={}",users.getEmail());

        var response = userServices.addUser(users);
        return response;
    }

    @PostMapping(path = "/loginwithusername")
    public int ValidateUserWithUsername(@RequestBody String username,String password) throws UnsupportedEncodingException {
//      System.out.println("Request received");

       // logger.info("validated login credentials : username={}",username);

        var response = userServices.ValidateUserByUsername(username, password);
        return response;
    }

    @PostMapping(path = "/loginwithemail")
    public int ValidateUserWithEmail(@RequestBody LoginUser loginUser) throws UnsupportedEncodingException {
//        System.out.println("Request received");
   //     logger.info("validated login credentials : email={}",user.email);

        System.out.println(loginUser.getEmail());

        var response = userServices.ValidateUserByEmail(loginUser.getEmail(),loginUser.getPassword());
        return response;
    }

    @PostMapping("/test")
    public int test(User user1) throws UnsupportedEncodingException {
        System.out.println(user1.email);
        System.out.println("Request received to registers");
        User user = new User();
//        user.email="hiransanjeewa.gmail.com";
//        user.password="hiransanjeewa";
        int response= userServices.ValidateUserByEmail(user1.email,user1.password);
        return response;

    }


}
