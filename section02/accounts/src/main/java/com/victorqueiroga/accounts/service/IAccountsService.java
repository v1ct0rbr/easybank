package com.victorqueiroga.accounts.service;

import com.victorqueiroga.accounts.dto.AccountsDto;
import com.victorqueiroga.accounts.dto.CustomerDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAccountsService {

    /**
     * Create account
     *
     * @param customerDto the customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetch account details
     *
     * @param mobileNumber the mobile number
     * @return Accounts Details based on mobile number
     */
    CustomerDto fetchAccount(@RequestParam String mobileNumber);

    /**
     * Update account details
     *
     * @param costumerDto the customer details
     * @return boolean indicating if the account details are updated
     */

    boolean updateAccount(CustomerDto costumerDto);

    /**
     * Delete account
     *
     * @param mobileNumber the mobile number
     */
    boolean deleteAccount(@RequestParam String mobileNumber);
}
