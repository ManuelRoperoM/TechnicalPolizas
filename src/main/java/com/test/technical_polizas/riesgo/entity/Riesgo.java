package com.test.technical_polizas.riesgo.entity;

import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.enums.TipoRiesgo;
import com.test.technical_polizas.poliza.entity.Poliza;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "riesgos")
@Getter
@Setter
public class Riesgo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoRiesgo tipoRiesgo;

    @Enumerated(EnumType.STRING)
    private EstadoRiesgo estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poliza_id")
    private Poliza poliza;
}
