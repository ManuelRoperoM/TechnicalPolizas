package com.test.technical_polizas.riesgo.Dtos.Responses;

import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.enums.TipoRiesgo;

import java.math.BigDecimal;

public class CreateRiskRpseDto {

    private Long polizaId;
    private String mensaje;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
