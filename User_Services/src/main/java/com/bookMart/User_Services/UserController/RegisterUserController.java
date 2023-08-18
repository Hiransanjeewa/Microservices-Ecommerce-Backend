package com.bookMart.User_Services.UserController;


import com.ecommercesystem.registeruser.dto.PasswordResetDto;
import com.ecommercesystem.registeruser.dto.Username;
import com.ecommercesystem.registeruser.dto.VerificationDto;
import com.ecommercesystem.registeruser.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.* ;
import java.io.UnsupportedEncodingException;



@RestController
@CrossOrigin()
@RequestMapping("ecommerce")
public class RegisterUserController {
    @Autowired
    private UserService registeruser;
    @Autowired
    private AddressService addressService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OtpGeneratorService otpGeneratorService;
    @Autowired
    private ResetPassword resetPassword;
    @Autowired
    private AccountStatusService accountStatusService;

    @PostMapping(path = "/register")
    public String saveUser(@RequestBody UserDto userDto) throws MessagingException, UnsupportedEncodingException {
        var email=registeruser.addUser(userDto);
        System.out.println(email);
        return email;
    }
    @PostMapping(path = "/login")
    public Integer authenticateUser(@RequestBody LoginUser loginUser)
    {
       Integer result = registeruser.validateUserDetails(loginUser.email,loginUser.password);
        return result;
    }
    @PostMapping(path = "/username")
    public Username GetUserName(@RequestParam Integer userid)
    {
        return registeruser.GetUserName(userid);
    }

    @PostMapping(path = "/validateemail/verify")
    public String validateWithOtp(@RequestBody VerificationDto verificationDto) throws MessagingException {
        return emailService.verifyEmail(verificationDto.email,verificationDto.otp);
    }
    @PostMapping (path = "/resendverificationlink")
    public String validateWithOtp(@RequestParam String email) throws MessagingException, UnsupportedEncodingException {
        return emailService.sendEmailVerification(email);
    }
    @PostMapping(path = "/resetpassword")
    public String resetPassword(@RequestParam String email) throws MessagingException, UnsupportedEncodingException {
        System.out.println(email);
        return emailService.resetPasswordEmail(email);
    }
    @PostMapping(path = "/changepassword")
    public String changepassword(@RequestBody VerificationDto verificationDto) throws MessagingException, UnsupportedEncodingException {

        System.out.println(emailService.ValidateResetLink(verificationDto.email,verificationDto.otp));
        return emailService.ValidateResetLink(verificationDto.email,verificationDto.otp);
    }
    @PostMapping(path = "/addnewpassword")
    public String addNewPassword(@RequestBody PasswordResetDto passwordResetDto){
        return resetPassword.addNewPassword(passwordResetDto);
    }
    @PostMapping(path = "/deactivateAccount")
    public String deactivateAccount(String email) {
        accountStatusService.deactivateAccount(email);
        return "Account is Deactivated ";
    }
    @PostMapping(path = "/getaddress")
    public List<User> getAddress(@RequestParam Integer userid) {
        return addressService.getAddressBYId(userid);
    }
    @GetMapping(path = "/changeaddress")
    public void getAddress(@RequestParam AddressDto addressDto, Integer userid) {
       addressService.changeAddress(addressDto, userid);
    }

}
