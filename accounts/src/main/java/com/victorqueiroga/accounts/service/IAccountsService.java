package com.victorqueiroga.accounts.service;

import com.victorqueiroga.accounts.dto.CustomerDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAccountsService {

    /**
     * Create account
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetch account details
     *
     * @param mobileNumber
     * @return Accounts Details based on mobile number
     */
    CustomerDto fetchAccount(@RequestParam String mobileNumber);
}
