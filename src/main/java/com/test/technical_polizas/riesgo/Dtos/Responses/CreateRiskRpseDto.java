package com.test.technical_polizas.riesgo.Dtos.Responses;

import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.enums.TipoRiesgo;

import java.math.BigDecimal;

public class CreateRiskRpseDto extends CreateRiskRspseListDto {

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
