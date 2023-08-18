package com.bookMart.User_Services.service.ResetPassword;

import com.ecommercesystem.registeruser.PasswordReset.PasswordReset;
import com.ecommercesystem.registeruser.dto.PasswordResetDto;
import com.ecommercesystem.registeruser.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordCentre implements ResetPassword{
    @Autowired
    private UserRepo userRepo;

    @Override
    public String addNewPassword(PasswordResetDto passwordResetDto) {
        BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder();
        String newpassword=bCrypt.encode(passwordResetDto.password);

        Integer akk= userRepo.changePassword(passwordResetDto.email,newpassword);
        return "Passsword Reset Success";
    }
}
