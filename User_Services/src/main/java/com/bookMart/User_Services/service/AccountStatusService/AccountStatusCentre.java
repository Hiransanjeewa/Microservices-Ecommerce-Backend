package com.bookMart.User_Services.service.AccountStatusService;

import com.ecommercesystem.registeruser.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AccountStatusCentre implements AccountStatusService{

    @Autowired
    private UserRepo userRepo;

    public void activateAccount(String email){
        //  userRepo.changeActiveStatus(email);
        // Removed functions when Making verify link add the functions again
    }
    public void deactivateAccount(String email){
        //userRepo.changeActiveStatus(0,email);
        // Removed functions when Making verify link add the functions again
    }
}
