package com.test.technical_polizas.riesgo.controllers;

import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRpseDto;
import com.test.technical_polizas.riesgo.service.RiesgoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/riesgos")
@Tag(name = "Controlador Riesgo", description = "CRUD de los requerimientos de riesgos")
public class RiesgoController {

    @Autowired
    private RiesgoService riesgoService;

    @Operation(
            summary = "Cancelacion de riesgo",
            description = "Cancela riego por id."
    )
    @PostMapping("/{id}/cancelar")
    public ResponseEntity<CreateRiskRpseDto> cancelarRisk(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(riesgoService.cancelRisk(id));
    }
}
