package com.test.technical_polizas.mock.service;

import com.test.technical_polizas.mock.dto.request.RegisterLogDto;
import com.test.technical_polizas.mock.dto.response.ResponseLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MockService {

    public ResponseLogDto registerEventMock(RegisterLogDto request) {
        log.info("CORE MOCK -> Evento: {}, Poliza: {}",
                request.getEvento(),
                request.getPolizaId());

        ResponseLogDto response = new ResponseLogDto();
        response.setEvento(request.getEvento());
        response.setPolizaId(request.getPolizaId());

        return response;
    }
}
