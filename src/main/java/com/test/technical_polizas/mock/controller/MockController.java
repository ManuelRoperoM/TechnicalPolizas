package com.test.technical_polizas.mock.controller;

import com.test.technical_polizas.mock.dto.request.RegisterLogDto;
import com.test.technical_polizas.mock.dto.response.ResponseLogDto;
import com.test.technical_polizas.mock.service.MockService;
import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core-mock")
public class MockController {
    @Autowired
    MockService mockService;

    @PostMapping("/evento")
    public ResponseEntity<ResponseLogDto> resgisterLog(
            @RequestHeader("x-api-key") String apiKey,
            @Valid @RequestBody RegisterLogDto request) {
        if (!"123456".equals(apiKey)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ResponseLogDto response = mockService.registerEventMock(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
