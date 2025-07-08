package com.victorqueiroga.accounts.service;

import com.victorqueiroga.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Create account
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
}
