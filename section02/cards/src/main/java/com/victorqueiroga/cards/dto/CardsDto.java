package com.victorqueiroga.cards.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Schema(name = "Cards",
        description = "Schema to hold Card information"
)
@Data
public class CardsDto {

    @NotEmpty(message = "{cards.mobileNumber.notEmpty}")
    @Pattern(regexp="(^$|[0-9]{10})",message = "{cards.mobileNumber.pattern}")
    @Schema(
            description = "Mobile Number of Customer", example = "4354437687"
    )
    private String mobileNumber;

    @NotEmpty(message = "{cards.cardNumber.notEmpty}")
    @Pattern(regexp="(^$|[0-9]{12})",message = "{cards.cardNumber.pattern}")
    @Schema(
            description = "Card Number of the customer", example = "100646930341"
    )
    private String cardNumber;

    @NotEmpty(message = "{cards.cardType.notEmpty}")
    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "{cards.totalLimit.positive}")
    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "{cards.amountUsed.positive}")
    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "{cards.availableAmount.positive}")
    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    private int availableAmount;

}