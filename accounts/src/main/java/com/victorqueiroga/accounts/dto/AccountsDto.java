package com.victorqueiroga.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Schema(
        name = "Accounts",
        description = "Customer Account Details",
        example = """
                {
                  "accountNumber": 1234567890,
                  "accountType": "Savings",
                  "branchAddress": "123 Main Street, Anytown, USA"
                }""")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    @Schema(description = "Account Number", example = "1234567890")
    @Pattern(regexp = "^$|[0-9]{10}$", message = "{accountDto.accountNumber.pattern.message}")
    @NotEmpty(message = "{accountDto.accountNumber.notEmpty}")
    private Long accountNumber;

    @Schema(description = "Account Type", example = "Savings")
    @NotEmpty(message = "{accountDto.accountType.notEmpty}")
    private String accountType;

    @Schema(description = "Branch Address", example = "123 Main Street, Anytown, USA")
    @NotEmpty(message = "{accountDto.branchAddress.notEmpty}")
    private String branchAddress;

}
