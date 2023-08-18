package com.ecommercesystem.registeruser.dto;



public class UserDto {

    private static int userId;
    private static String firstname;
    private static String secondname;
    private static String addressline1;
    private static String addressline2;
    private static String email;
    private static String mobile;
    private static String password;
    private String country;
    private static String district;
    private static String province;
    private static String postalcode;

    // private boolean activeState;    to do


    public UserDto() {

    }

    public UserDto(int userId, String firstname, String secondname, String addressline1, String addressline2, String email, String mobile, String password, String country, String district, String province, String postalcode) {
        this.userId = userId;
        this.firstname = firstname;
        this.secondname = secondname;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.country = country;
        this.district = district;
        this.province = province;
        this.postalcode = postalcode;
    }

    public static int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public static String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public static String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public static String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public static String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public static String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", postalcode='" + postalcode + '\'' +
                '}';
    }
}
