package com.ecommercesystem.registeruser.dto;

public class VerificationDto {
    public String email;
    public Integer otp;

    public VerificationDto() {
    }

    public VerificationDto(String email, Integer otp) {
        this.email = email;
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }
}
