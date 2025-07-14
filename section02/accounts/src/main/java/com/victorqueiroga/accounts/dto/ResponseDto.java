package com.victorqueiroga.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information")
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            name = "status code",
            description = "Status Code", example = "200")
    private String statusCode;
    @Schema(
            name = "status message",
            description = "Status Message", example = "Success")
    private String statusMsg;
}
