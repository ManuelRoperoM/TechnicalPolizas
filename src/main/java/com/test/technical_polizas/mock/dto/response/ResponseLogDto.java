package com.test.technical_polizas.mock.dto.response;

public class ResponseLogDto {
    private long polizaId;
    private String evento;
    public void setPolizaId(Long id) {
        this.polizaId = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Long getPolizaId() {
        return polizaId;
    }
}
