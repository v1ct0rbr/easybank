package com.victorqueiroga.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account details"
)
public class CustomerDto {

    @Schema(description = "Customer Name", example = "John Doe")
    @NotEmpty(message = "{customerDto.name.notEmpty}")
    @Size(min = 2, max = 50, message = "{customerDto.name.size}")
    private String name;

    @Schema(description = "Customer Email", example = "jdoe@ex.com")
    @NotEmpty(message = "{customerDto.email.notEmpty}")
    @Email(message = "{customerDto.email.email}")
    private String email;

    @Schema(description = "Customer Mobile Number", example = "1234567890")
    @Pattern(regexp = "^$|[0-9]{10}$", message = "{customerDto.mobileNumber.pattern}")
    @NotEmpty(message = "{customerDto.mobileNumber.notEmpty}")
    private String mobileNumber;

    @Schema(
            name = "Accounts",
            description = "Customer Account Details")
    private AccountsDto accountsDto;

}
