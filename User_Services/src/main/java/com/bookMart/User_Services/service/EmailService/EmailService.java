package com.bookMart.User_Services.service.EmailService;

import com.ecommercesystem.registeruser.entity.User;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface EmailService {

    String sendEmailVerification(String email) throws MessagingException, UnsupportedEncodingException;

    String verifyEmail(String email, Integer otp);

    String resetPasswordEmail(String email) throws MessagingException, UnsupportedEncodingException;

    String ValidateResetLink(String email, Integer otp);
}
