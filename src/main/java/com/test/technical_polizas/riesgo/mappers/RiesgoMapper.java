package com.test.technical_polizas.riesgo.mappers;

import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRpseDto;
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRspseListDto;
import com.test.technical_polizas.riesgo.entity.Riesgo;

public class RiesgoMapper {

    private static void map(Riesgo riesgo, CreateRiskRspseListDto dto) {
        dto.setPolizaId(riesgo.getPoliza().getId());
        dto.setTipoRiesgo(riesgo.getTipoRiesgo());
        dto.setEstadoRiesgo(riesgo.getEstado());
    }

    public static CreateRiskRpseDto toResponse(Riesgo riesgo) {

        CreateRiskRpseDto dto = new CreateRiskRpseDto();
        dto.setMensaje("Riesgo asociado correctamente");
        map(riesgo, dto);

        return dto;
    }

    public static CreateRiskRspseListDto toResponseList(Riesgo riesgo) {
        CreateRiskRspseListDto dto = new CreateRiskRspseListDto();
        map(riesgo, dto);

        return dto;
    }
}
