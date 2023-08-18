package com.bookMart.User_Services.service.OtpGenerator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpGeneratorCenter implements OtpGeneratorService{


    public Integer generateOtp() {
        Random rd = new Random();
        int rnum = rd.nextInt(10000);
        return rnum;
    }






}

