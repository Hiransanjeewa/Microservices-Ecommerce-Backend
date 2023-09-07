package com.example.LoginService;




import com.example.LoginService.client.RegisterServiceClient;
import com.example.LoginService.client.TestingClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginServices loginServices ;//= new LoginServicesImpl();

    @Autowired
    private RegisterServiceClient registerServiceWebClient;

    @Autowired
    private TestingClient testingClient;








    @PostMapping("/login")
    public String loginWithCredentials(@RequestBody LoginUser loginUser) throws UnsupportedEncodingException {



        return loginServices.testing(loginUser);


//        LoginUser loginUser =new LoginUser("hiransanjeewaa@gmail.com","hiran12345");
//     int a=    registerServiceWebClient.ValidateUserWithEmail(loginUser);
//        System.out.println(a);

       // logger.info("login user account: email={}", loginuser.getEmail());

        //int validatedId = loginServices.validateCredentials(loginuser);
//        if ( validatedId !=0){
//            return loginServices.createSessionId(validatedId);
//        }else {
//            return "Email or password incorrect";
//        }
       // return "Controller runs successfully";

    }
    @GetMapping("/test")
    public String loginWithCredentials() throws UnsupportedEncodingException {


   // return loginServices.testing(loginUser);
        return "test";
    }


}
