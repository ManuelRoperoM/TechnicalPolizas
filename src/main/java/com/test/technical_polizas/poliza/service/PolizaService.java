package com.test.technical_polizas.poliza.service;

import com.test.technical_polizas.poliza.dto.requests.CreateRequestDto;
import com.test.technical_polizas.poliza.dto.responses.ListPolizasDto;
import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;
import com.test.technical_polizas.poliza.mappers.PolizaMappers;
import com.test.technical_polizas.poliza.repository.PolizaRepository;
import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import com.test.technical_polizas.riesgo.Dtos.Requests.CreateRiskDto;
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRpseDto;
import com.test.technical_polizas.riesgo.entity.Riesgo;
import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.mappers.RiesgoMapper;
import com.test.technical_polizas.riesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolizaService {

    private final PolizaRepository polizaRepository;
    private final RiesgoRepository riesgoRepository;

    public PolizaService(
            PolizaRepository polizaRepository,
            RiesgoRepository riesgoRepository) {
        this.polizaRepository = polizaRepository;
        this.riesgoRepository = riesgoRepository;
    }

    public CreateResponseDto create(CreateRequestDto request) {
        Poliza poliza = PolizaMappers.toEntity(request);
        poliza.setEstado(EstadoPoliza.ACTIVA);
        Poliza savedPoliza = polizaRepository.save(poliza);
        return PolizaMappers.toResponse(savedPoliza);
    }

    public List<ListPolizasDto> findByTypeAndStatus(
            TipoPoliza tipoPoliza,
            EstadoPoliza estadoPoliza) {

        List<Poliza> polizas =  polizaRepository.findByTipoAndEstado(tipoPoliza, estadoPoliza);
        return polizas.stream()
                .map(PolizaMappers::toDto)
                .toList();
    }

    public CreateRiskRpseDto createRisk(Long polizaId, CreateRiskDto request) {
        Poliza poliza = polizaRepository.findById(polizaId)
                .orElseThrow(() -> new RuntimeException("Póliza no encontrada"));

        TipoPoliza tipoPoliza = poliza.getTipo();

        if (tipoPoliza == TipoPoliza.INDIVIDUAL) {
            boolean existeRiesgo = riesgoRepository.findByPolizaId(polizaId).isEmpty();
            if (!existeRiesgo) {
                throw new RuntimeException(
                        "Una póliza individual solo puede tener un riesgo."
                );
            }
        }

        Riesgo riesgo = new Riesgo();
        riesgo.setEstado(EstadoRiesgo.ACTIVO);
        riesgo.setPoliza(poliza);
        riesgo.setTipoRiesgo(request.getTipoRiesgo());

        Riesgo saved = riesgoRepository.save(riesgo);

        return RiesgoMapper.toResponse(saved);


    }
}
