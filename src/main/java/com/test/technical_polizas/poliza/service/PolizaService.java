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
import com.test.technical_polizas.riesgo.Dtos.Responses.CreateRiskRspseListDto;
import com.test.technical_polizas.riesgo.entity.Riesgo;
import com.test.technical_polizas.riesgo.enums.EstadoRiesgo;
import com.test.technical_polizas.riesgo.mappers.RiesgoMapper;
import com.test.technical_polizas.riesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PolizaService {

    private final PolizaRepository polizaRepository;
    private final RiesgoRepository riesgoRepository;

    private static final BigDecimal IPC_PORCENTAJE = new BigDecimal("0.0568");

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

        EstadoPoliza estadoPoliza = poliza.getEstado();

        if (estadoPoliza == EstadoPoliza.INACTIVA) {
            throw new RuntimeException(
                    "No se puede agregar un riesgo a una poliza inactiva"
            );
        }

        Riesgo riesgo = new Riesgo();
        riesgo.setEstado(EstadoRiesgo.ACTIVO);
        riesgo.setPoliza(poliza);
        riesgo.setTipoRiesgo(request.getTipoRiesgo());

        Riesgo saved = riesgoRepository.save(riesgo);

        return RiesgoMapper.toResponse(saved);
    }

    public List<CreateRiskRspseListDto> findRiesgosByPolizaId(Long polizaId) {
        List<Riesgo> riesgos =  riesgoRepository.findByPolizaId(polizaId);

        return riesgos.stream().map(RiesgoMapper::toResponseList)
                .toList();
    }

    public  ListPolizasDto renewPoliza(Long polizaId) {

        Poliza poliza = polizaRepository.findById(polizaId)
                .orElseThrow(() -> new RuntimeException("Póliza no encontrada"));
        EstadoPoliza estadoPolizaPoliza = poliza.getEstado();
        if (estadoPolizaPoliza == EstadoPoliza.INACTIVA) {
            throw new RuntimeException(
                    "No se puede renovar una poliza inactiva."
            );
        }

        poliza.setEstado(EstadoPoliza.RENOVADA);
        BigDecimal factor = BigDecimal.ONE.add(IPC_PORCENTAJE);
        poliza.setCanon(poliza.getCanon().multiply(factor));
        poliza.setPrima(poliza.getPrima().multiply(factor));

        Poliza polizaSaved = polizaRepository.save(poliza);

        return  PolizaMappers.toDto(polizaSaved);
    }

    @Transactional
    public ListPolizasDto cancelPoliza(Long polizaId) {
        Poliza poliza = polizaRepository.findById(polizaId)
                .orElseThrow(() -> new RuntimeException("Póliza no encontrada"));

        poliza.setEstado(EstadoPoliza.INACTIVA);

        List<Riesgo> riesgos = riesgoRepository.findByPolizaId(polizaId);

        if (!riesgos.isEmpty()) {
            riesgos.forEach(riesgo -> {
                riesgo.setEstado(EstadoRiesgo.INACTIVO);
            });
            riesgoRepository.saveAll(riesgos);
        }
        Poliza save =  polizaRepository.save(poliza);
        return PolizaMappers.toDto(save);
    }
}
