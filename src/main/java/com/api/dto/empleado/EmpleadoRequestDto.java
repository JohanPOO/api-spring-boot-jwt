package com.api.dto.empleado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmpleadoRequestDto {

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long persona_id;

    @NotBlank(message = "rol obligatorio")
    @NotNull(message = "no puede ser nulo")
    private String rol;

    public EmpleadoRequestDto() {
    }

    public EmpleadoRequestDto(Long persona_id, String rol) {
        this.persona_id = persona_id;
        this.rol = rol;
    }

    public Long getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Long persona_id) {
        this.persona_id = persona_id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "EmpleadoRequestDto{" +
                "persona_id=" + persona_id +
                ", rol='" + rol + '\'' +
                '}';
    }
}
