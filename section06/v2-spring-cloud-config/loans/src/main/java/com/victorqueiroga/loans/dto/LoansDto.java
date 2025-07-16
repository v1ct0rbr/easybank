package com.victorqueiroga.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Schema(name = "Loans",
        description = "Schema to hold Loan information"
)
@Data
public class LoansDto {

    @NotEmpty(message = "{loans.mobileNumber.notEmpty}")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "{loans.mobileNumber.pattern}")
    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "{loans.loanNumber.notEmpty}")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "{loans.loanNumber.pattern}")
    @Schema(
            description = "Loan Number of the customer", example = "548732457654"
    )
    private String loanNumber;

    @NotEmpty(message = "{loans.loanType.notEmpty}")
    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "{loans.totalLoan.positive}")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "{loans.amountPaid.positive_or_zero}")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "{loans.outstandingAmount.positive_or_zero}")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;

}