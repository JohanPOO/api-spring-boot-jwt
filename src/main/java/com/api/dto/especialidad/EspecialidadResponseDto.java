package com.api.dto.especialidad;

public class EspecialidadResponseDto {

    private String nombre;
    private Boolean estado;

    public EspecialidadResponseDto() {
    }

    public EspecialidadResponseDto(String nombre, Boolean estado) {
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
        return "EspecialidadResponseDto{" +
                "nombre='" + nombre + '\'' +
                ", estado=" + estado +
                '}';
    }
}
