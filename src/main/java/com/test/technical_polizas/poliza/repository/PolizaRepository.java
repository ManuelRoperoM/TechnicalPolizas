package com.test.technical_polizas.poliza.repository;

import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolizaRepository extends JpaRepository <Poliza, Long> {
    List<Poliza> findByTipoAndEstado(TipoPoliza tipo, EstadoPoliza estado);
}
