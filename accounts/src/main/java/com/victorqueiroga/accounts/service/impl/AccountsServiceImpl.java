package com.victorqueiroga.accounts.service.impl;

import com.victorqueiroga.accounts.constants.AccountsConstants;
import com.victorqueiroga.accounts.dto.CustomerDto;
import com.victorqueiroga.accounts.entity.Accounts;
import com.victorqueiroga.accounts.entity.Customer;
import com.victorqueiroga.accounts.exception.CustomerAlreadyExistsException;
import com.victorqueiroga.accounts.mapper.CustomerMapper;
import com.victorqueiroga.accounts.repository.AccountsRepository;
import com.victorqueiroga.accounts.repository.CustomerRepository;
import com.victorqueiroga.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> customerByMobileNumber = customerRepository.findByMobileNumber(customerDto.getEmail());
        if(customerByMobileNumber.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with mobile number " + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getId());
        long radomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(radomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
