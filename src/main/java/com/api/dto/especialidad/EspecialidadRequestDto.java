package com.api.dto.especialidad;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EspecialidadRequestDto {

    @NotBlank(message = "nombre obligatorio")
    @NotNull(message = "no puede ser nulo")
    @Size(min = 3 ,max = 50)
    private String nombre;

    @NotNull(message = "no puede ser nulo")
    private Boolean estado;

    public EspecialidadRequestDto() {
    }

    public EspecialidadRequestDto(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EspecialidadRequestDto{" +
                "nombre='" + nombre + '\'' +
                ", estado=" + estado +
                '}';
    }
}
