package com.test.technical_polizas.poliza.dto.requests;

import com.test.technical_polizas.poliza.enums.TipoPoliza;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateRequestDto {

    @NotNull(message = "El tipo de poliza es obligatorio")
    private TipoPoliza tipo;

    @NotNull(message = "El canon es obligatorio.")
    @DecimalMin(value = "0.0", inclusive = false, message = "El canon debe ser mayor a cero.")
    private BigDecimal canon;

    @NotNull(message = "La prima es obligatoria.")
    @DecimalMin(value = "0.0", inclusive = false, message = "La prima debe ser mayor a cero.")
    private BigDecimal prima;

    public TipoPoliza getTipo() {
        return tipo;
    }

    public void setTipo(TipoPoliza tipo) {
        this.tipo = tipo;
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
}
