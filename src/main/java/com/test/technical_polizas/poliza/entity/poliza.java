package com.test.technical_polizas.poliza.entity;


import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "polizas")
@Getter
@Setter

public class poliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TipoPoliza tipo;

    @Enumerated(EnumType.STRING)
    private EstadoPoliza estado;

    @Column(nullable = false)
    private BigDecimal valor;



}
