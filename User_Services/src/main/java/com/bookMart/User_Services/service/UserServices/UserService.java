package com.bookMart.User_Services.service.UserServices;


import com.ecommercesystem.registeruser.dto.UserDto;
import com.ecommercesystem.registeruser.dto.Username;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    String addUser(UserDto userDto) throws MessagingException, UnsupportedEncodingException;
    Integer validateUserDetails(String email,String password);

    Username GetUserName(Integer userid);
}
