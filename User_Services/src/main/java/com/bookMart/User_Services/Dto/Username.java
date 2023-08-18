package com.ecommercesystem.registeruser.dto;

public class Username {
    private String firstname;
    private String secondname;

    public Username(String firstname, String secondname) {
        this.firstname = firstname;
        this.secondname = secondname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public Username() {
    }
}
