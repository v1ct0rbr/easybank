package com.victorqueiroga.accounts.controller;

import com.victorqueiroga.accounts.constants.AccountsConstants;
import com.victorqueiroga.accounts.dto.AccountsDto;
import com.victorqueiroga.accounts.dto.CustomerDto;
import com.victorqueiroga.accounts.dto.ResponseDto;
import com.victorqueiroga.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Validated
public class AccountsController {

    private final IAccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201, "Success"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam @Pattern(regexp = "^$|[0-9]{10}$") String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if (!isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, "Success"));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam @Pattern(regexp = "^$|[0-9]{10}$") String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, "Success"));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
    }
}