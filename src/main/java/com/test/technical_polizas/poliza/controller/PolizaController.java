package com.test.technical_polizas.poliza.controller;

import com.test.technical_polizas.poliza.dto.requests.CreateRequestDto;
import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import com.test.technical_polizas.poliza.service.PolizaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polizas")
public class PolizaController {

    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService) {
        this.polizaService = polizaService;
    }

    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@Valid @RequestBody CreateRequestDto body) {
        CreateResponseDto response = polizaService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
