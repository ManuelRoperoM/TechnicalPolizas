package com.test.technical_polizas.poliza.dto.responses;

import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ListPolizasDto {
    private Long id;
    private TipoPoliza tipo;
    private EstadoPoliza estado;
    private BigDecimal canon;
    private BigDecimal prima;

}
