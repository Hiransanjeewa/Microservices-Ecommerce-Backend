package com.bookMart.User_Services.service.AddressService;

import com.ecommercesystem.checkout.CheckoutDtos.AddressDto;
import com.ecommercesystem.registeruser.entity.User;

import java.util.List;

public interface AddressService {
     List<User> getAddressBYId(Integer userid);

     void changeAddress(AddressDto addressDto,Integer userid);
}
