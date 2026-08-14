package com.api.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PacienteRequestDto {

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long id_persona;

    @NotBlank(message = "rol obligatorio")
    @NotNull(message = "no puede ser nulo")
    private String rol;

    public PacienteRequestDto() {
    }

    public PacienteRequestDto(Long id_persona, String rol) {
        this.id_persona = id_persona;
        this.rol = rol;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "PacienteRequestDto{" +
                "id_persona=" + id_persona +
                ", rol='" + rol + '\'' +
                '}';
    }
}
