package com.test.technical_polizas.riesgo.Dtos.Requests;

import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.enums.TipoRiesgo;
import jakarta.validation.constraints.NotNull;

public class CreateRiskDto {

    @NotNull(message = "Tipo de riesgo no puede ser nulo")
    private TipoRiesgo tipoRiesgo;

    public TipoRiesgo getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(TipoRiesgo tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

}
