package com.victorqueiroga.accounts.controller;

import com.victorqueiroga.accounts.constants.AccountsConstants;
import com.victorqueiroga.accounts.dto.CustomerDto;
import com.victorqueiroga.accounts.dto.ErrorResponseDto;
import com.victorqueiroga.accounts.dto.ResponseDto;
import com.victorqueiroga.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Crud Rest APIs for Accounts in EasyBank", description = "CRUD Rest APIs for Accounts in EasyBank to create, fetch, update and delete account details")
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private final IAccountsService accountsService;

    @Operation(
            summary = "Create new account",
            description = "Create new account in EasyBank"

    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"

                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ErrorResponseDto.class
                                            )
                                    )
                            }
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201, "Success"));
    }

    @Operation(
            summary = "Fetch account details",
            description = "Fetch account details in EasyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Account not found",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ErrorResponseDto.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ErrorResponseDto.class
                                            )
                                    )
                            }
                    )
            }
    )


    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam @Pattern(regexp = "^$|[0-9]{10}$", message = "{customerDto.mobileNumber.pattern}") String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(
            summary = "Update account details",
            description = "Update account details in EasyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Update failed",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ErrorResponseDto.class
                                            )
                                    )
                            }
                    )
            }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, "Success"));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
    }

    @Operation(
            summary = "Delete account",
            description = "Delete account in EasyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Delete failed",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ErrorResponseDto.class
                                            )
                                    )
                            }
                    )
            }
    )

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam @Pattern(regexp = "^$|[0-9]{10}$", message = "{customerDto.mobileNumber.pattern}") String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, "Success"));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
    }
}