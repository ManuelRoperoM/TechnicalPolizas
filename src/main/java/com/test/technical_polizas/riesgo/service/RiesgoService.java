package com.test.technical_polizas.riesgo.service;

import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRpseDto;
import com.test.technical_polizas.riesgo.Dtos.Risk;
import com.test.technical_polizas.riesgo.entity.Riesgo;
import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.mappers.RiesgoMapper;
import com.test.technical_polizas.riesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;

@Service
public class RiesgoService {
    private final RiesgoRepository riesgoRepository;

    public RiesgoService(RiesgoRepository riesgoRepository) {
        this.riesgoRepository = riesgoRepository;
    }

    public CreateRiskRpseDto cancelRisk(Long id) {
        Riesgo risk = riesgoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Póliza no encontrada"));
        risk.setEstado(EstadoRiesgo.INACTIVO);
        Riesgo saved = riesgoRepository.save(risk);
        return RiesgoMapper.toResponse(saved);
    }
}
