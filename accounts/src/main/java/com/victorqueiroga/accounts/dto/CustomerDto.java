package com.victorqueiroga.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Pattern(regexp = "^$|[0-9]{10}$")
    private String mobileNumber;

    private AccountsDto accountsDto;

}
