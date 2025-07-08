package com.victorqueiroga.accounts.controller;

import com.victorqueiroga.accounts.constants.AccountsConstants;
import com.victorqueiroga.accounts.dto.AccountsDto;
import com.victorqueiroga.accounts.dto.CustomerDto;
import com.victorqueiroga.accounts.dto.ResponseDto;
import com.victorqueiroga.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountsController {

    private final IAccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201, "Success"));
    }

}
