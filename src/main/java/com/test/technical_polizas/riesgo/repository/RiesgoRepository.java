package com.test.technical_polizas.riesgo.repository;

import com.test.technical_polizas.riesgo.entity.Riesgo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiesgoRepository extends JpaRepository<Riesgo, Long> {
    List<Riesgo> findByPolizaId(Long polizaId);
}
