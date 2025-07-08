package com.victorqueiroga.accounts.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;

}
