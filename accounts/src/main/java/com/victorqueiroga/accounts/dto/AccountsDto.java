package com.victorqueiroga.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    @Pattern(regexp = "^$|[0-9]{10}$")
    @NotEmpty
    private Long accountNumber;

    @NotEmpty
    private String accountType;

    @NotEmpty
    private String branchAddress;

}
