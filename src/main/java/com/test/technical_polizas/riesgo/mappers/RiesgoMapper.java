package com.test.technical_polizas.riesgo.mappers;

import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRpseDto;
import com.test.technical_polizas.riesgo.entity.Riesgo;

public class RiesgoMapper {
    public static CreateRiskRpseDto toResponse(Riesgo riesgo) {

        CreateRiskRpseDto response = new CreateRiskRpseDto();

        response.setTipoRiesgo(riesgo.getTipoRiesgo());
        response.setPolizaId(riesgo.getPoliza().getId());
        response.setEstadoRiesgo(riesgo.getEstado());
        response.setMensaje("Riesgo asociado correctamente");

        return response;
    }
}
