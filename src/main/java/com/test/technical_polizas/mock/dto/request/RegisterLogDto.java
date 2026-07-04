package com.test.technical_polizas.mock.dto.request;

import jakarta.validation.constraints.NotNull;

public class RegisterLogDto {
    @NotNull(message = "El evento debe ser obligatorio")
    private String evento;

    @NotNull(message = "El id de la poliza no puede estar vacio")
    private Long polizaId;

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Long getPolizaId() {
        return polizaId;
    }

    public void setPolizaId(Long polizaId) {
        this.polizaId = polizaId;
    }
}
