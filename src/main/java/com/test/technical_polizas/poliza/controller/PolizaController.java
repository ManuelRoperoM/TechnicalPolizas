package com.test.technical_polizas.poliza.controller;

import com.test.technical_polizas.poliza.dto.requests.CreateRequestDto;
import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import com.test.technical_polizas.poliza.dto.responses.ListPolizasDto;
import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;
import com.test.technical_polizas.poliza.service.PolizaService;
import com.test.technical_polizas.riesgo.Dtos.Requests.CreateRiskDto;
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRpseDto;
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRspseListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polizas")
@Tag(name = "Controlador Poliza", description = "Controlador con el CRUD de la poliza")
public class PolizaController {

    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService) {
        this.polizaService = polizaService;
    }

    @Operation(
            summary = "Registrar poliza",
            description = "Registra una poliza en la base de datos."
    )
    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@Valid @RequestBody CreateRequestDto body) {
        CreateResponseDto response = polizaService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Consulta polizas",
            description = "Consulta Polizas por tipo y estado."
    )
    @GetMapping
    public ResponseEntity<List<ListPolizasDto>> getPolizas(
            @RequestParam TipoPoliza tipo,
            @RequestParam EstadoPoliza estado) {

        return ResponseEntity.ok(
                polizaService.findByTypeAndStatus(tipo, estado)
        );
    }

    @Operation(
            summary = "Creacion riesgos",
            description = "Crea un riesgo y lo asigna a una poliza."
    )
    @PostMapping("/{id}/riesgos")
    public ResponseEntity<CreateRiskRpseDto> addRisk(
            @PathVariable Long id,
            @Valid @RequestBody CreateRiskDto body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(polizaService.createRisk(id, body));
    }

    @Operation(
            summary = "Consulta de riesgos",
            description = "Consulta todos los riesgos asociados a una poliza."
    )
    @GetMapping("/{id}/riesgos")
    public ResponseEntity<List<CreateRiskRspseListDto>> getRiskByPolza(@PathVariable Long id) {
        return ResponseEntity.ok(polizaService.findRiesgosByPolizaId(id));
    }

    @Operation(
            summary = "Renovacion de poliza",
            description = "Renueva la poliza recalculando el valor del canon y de prima."
    )
    @PostMapping("/{id}/renovar")
    public ResponseEntity<ListPolizasDto> renewPoliza(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(polizaService.renewPoliza(id));
    }

    @Operation(
            summary = "Cancelacion de poliza",
            description = "Cancela una poliza y todos los riesgos asociados."
    )
    @PostMapping("/{id}/cancelar")
    public ResponseEntity<ListPolizasDto> CancelPoliza(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(polizaService.cancelPoliza(id));
    }
}
