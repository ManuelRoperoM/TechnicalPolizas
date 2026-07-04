package com.test.technical_polizas.common.exceptions.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDto {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}
