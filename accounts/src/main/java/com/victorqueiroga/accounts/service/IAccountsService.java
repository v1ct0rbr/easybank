package com.victorqueiroga.accounts.service;

import com.victorqueiroga.accounts.dto.CustomerDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAccountsService {

    /**
     * Create account
     *
     * @param customerDto - customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetch account details
     *
     * @param mobileNumber - mobile number
     * @return Accounts Details based on mobile number
     */
    CustomerDto fetchAccount(@RequestParam String mobileNumber);

    /**
     * Update account details
     *
     * @param customerDto - customer details
     * @return true if account details are updated
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * Delete account details
     *
     * @param mobileNumber - mobile number
     * @return true if account details are deleted
     */
    boolean deleteAccount(@RequestParam String mobileNumber);

}
