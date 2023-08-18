package com.bookMart.User_Services.service.AddressService;

import com.ecommercesystem.checkout.CheckoutDtos.AddressDto;
import com.ecommercesystem.registeruser.entity.User;
import com.ecommercesystem.registeruser.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private UserRepo userRepo;


    @Override
    public List<User> getAddressBYId(Integer userid) {
        return userRepo.getAddressBYId(userid);
    }

    @Override
    public void changeAddress(AddressDto addressDto,Integer userid) {
        System.out.println(addressDto.getDistrict());
        userRepo.changeUserAddress(addressDto.getFirstname(),addressDto.getSecondname(),addressDto.getAddressline1(), addressDto.getAddressline2(),
                addressDto.getDistrict(),addressDto.getPostalcode() , addressDto.getMobile(), addressDto.getProvince(),userid);
    }
}
