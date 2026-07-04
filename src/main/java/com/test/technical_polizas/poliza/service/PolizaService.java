package com.test.technical_polizas.poliza.service;

import com.test.technical_polizas.poliza.dto.requests.CreateRequestDto;
import com.test.technical_polizas.poliza.dto.responses.ListPolizasDto;
import com.test.technical_polizas.poliza.entity.Poliza;
import com.test.technical_polizas.poliza.enums.EstadoPoliza;
import com.test.technical_polizas.poliza.enums.TipoPoliza;
import com.test.technical_polizas.poliza.mappers.PolizaMappers;
import com.test.technical_polizas.poliza.repository.PolizaRepository;
import com.test.technical_polizas.poliza.dto.responses.CreateResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolizaService {

    private final PolizaRepository polizaRepository;

    public PolizaService(PolizaRepository polizaRepository) {
        this.polizaRepository = polizaRepository;
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
}
