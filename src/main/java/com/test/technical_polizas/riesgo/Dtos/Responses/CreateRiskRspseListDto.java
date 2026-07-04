package com.test.technical_polizas.riesgo.Dtos.Responses;

import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.enums.TipoRiesgo;

public class CreateRiskRspseListDto {

    private Long polizaId;
    private TipoRiesgo tipoRiesgo;
    private EstadoRiesgo estadoRiesgo;


    public EstadoRiesgo getEstadoRiesgo() {
        return estadoRiesgo;
    }

    public void setEstadoRiesgo(EstadoRiesgo estadoRiesgo) {
        this.estadoRiesgo = estadoRiesgo;
    }

    public TipoRiesgo getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(TipoRiesgo tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    public Long getPolizaId() {
        return polizaId;
    }

    public void setPolizaId(Long polizaId) {
        this.polizaId = polizaId;
    }
}
