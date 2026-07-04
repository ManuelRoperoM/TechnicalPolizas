package com.test.technical_polizas.poliza.mappers;

import com.test.technical_polizas.poliza.dto.requests.CreateRequestDto;
import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import com.test.technical_polizas.poliza.entity.Poliza;

public class PolizaMappers {

    public static Poliza toEntity(CreateRequestDto request) {

        Poliza poliza = new Poliza();

        poliza.setTipo(request.getTipo());
        poliza.setCanon(request.getCanon());
        poliza.setPrima(request.getPrima());

        return poliza;
    }

    public static CreateResponseDto toResponse(Poliza poliza) {

        CreateResponseDto response = new CreateResponseDto();

        response.setTipo(poliza.getTipo());
        response.setEstado(poliza.getEstado());
        response.setCanon(poliza.getCanon());
        response.setPrima(poliza.getPrima());
        response.setMessage("Prima creada correctamente");

        return response;
    }
}
