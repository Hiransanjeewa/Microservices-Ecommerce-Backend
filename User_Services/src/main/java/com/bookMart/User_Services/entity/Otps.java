package com.bookMart.User_Services.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "otps")
public class Otps {
    @Id
    @Column(name = "email",length = 30)
    private String email;
    @Column(name = "otp",length = 5)
    private int otp;

    public Otps() {
    }

    public Otps(String email, int otp) {
        this.email = email;
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
