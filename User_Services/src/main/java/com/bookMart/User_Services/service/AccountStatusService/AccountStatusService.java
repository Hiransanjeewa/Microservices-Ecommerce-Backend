package com.bookMart.User_Services.service.AccountStatusService;

public interface AccountStatusService {
    void activateAccount(String email);
    void deactivateAccount(String email);
}
