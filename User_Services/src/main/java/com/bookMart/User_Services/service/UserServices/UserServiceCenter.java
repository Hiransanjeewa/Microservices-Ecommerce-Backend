package com.bookMart.User_Services.service.UserServices;


import com.ecommercesystem.registeruser.dto.UserDto;
import com.ecommercesystem.registeruser.dto.Username;
import com.ecommercesystem.registeruser.entity.User;
import com.ecommercesystem.registeruser.repository.UserRepo;
import com.ecommercesystem.registeruser.service.EmailService.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceCenter implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmailService emailService;

    @Override
    public String addUser(UserDto userdto) throws MessagingException, UnsupportedEncodingException {
        BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder();
        String encPassword=bCrypt.encode(UserDto.getPassword());


        User user = new User(

                UserDto.getUserId(),
                UserDto.getFirstname(),
                UserDto.getSecondname(),
                UserDto.getEmail(),
                UserDto.getMobile(),
                UserDto.getAddressline1(),
                UserDto.getAddressline2(),
                UserDto.getDistrict(),
                UserDto.getProvince(),
                UserDto.getPostalcode(),
                UserDto.getPassword(),
                false


                // UserDto.isActiveState()
        );
        user.setPassword(encPassword);

        List<User> Emailtaken = userRepo.findUserByEmail(UserDto.getEmail());
        List<User> Mobiletaken = userRepo.findUserByMobile(UserDto.getMobile());

        if (Emailtaken .size()==0){
            if (Mobiletaken.size()==0){
                userRepo.save(user);
                emailService.sendEmailVerification(user.getEmail());
                return "Registration Successful";
            }else {
                return "Mobile number is already registered";
            }
        }
        else {
            return "email is already registered";
        }
    }
    public Integer validateUserDetails(String email,String password) {
        List<User> IsUserAvailable = userRepo.findUserByEmail(email);
        BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder();
        if (IsUserAvailable.size()!=0 ){
            if (bCrypt.matches(password,userRepo.findUserByLoginCredentials(email))){
                if (IsUserAvailable.get(0).isActiveStatus()){
                    return IsUserAvailable.get(0).getUserId();
                }else {
                    return -2;
                }

            }else {
                return -1;
            }
        }else {
            return -3;
        }
    }

    @Override
    public Username GetUserName(Integer userid) {
        Username username=new Username();
        User user=userRepo.getAddressBYId(userid).get(0);
        username.setFirstname(user.getFirstName());
        username.setSecondname(user.getSecondName());
        return username;

    }
}
