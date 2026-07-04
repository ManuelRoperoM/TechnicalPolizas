package com.test.technical_polizas.poliza.dto.responses;

import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;

import java.math.BigDecimal;

public class CreateResponseDto {
    private TipoPoliza tipo;
    private EstadoPoliza estado;
    private BigDecimal canon;
    private BigDecimal prima;
    private String message;


    public TipoPoliza getTipo() {
        return tipo;
    }

    public void setTipo(TipoPoliza tipo) {
        this.tipo = tipo;
    }

    public EstadoPoliza getEstado() {
        return estado;
    }

    public void setEstado(EstadoPoliza estado) {
        this.estado = estado;
    }

    public BigDecimal getCanon() {
        return canon;
    }

    public void setCanon(BigDecimal canon) {
        this.canon = canon;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
