package com.victorqueiroga.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Error Response",
        description = "Error Response"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(name = "api path", description = "API path invoked by client", example = "uri=/api/create")
    private String apiPath;
    @Schema(name = "status code", description = "Error code representing the error happened", example = "400")
    private HttpStatus errorCode;
    @Schema(name = "error message", description = "Error Message describing the error", example = "Bad Request")
    private String errorMessage;
    @Schema(name = "error time", description = "Error Time when the error happened", example = "2023-01-01T00:00:00")
    private LocalDateTime errorTime;


}
