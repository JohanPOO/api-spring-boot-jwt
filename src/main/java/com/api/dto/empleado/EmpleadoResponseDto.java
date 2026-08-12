package com.api.dto.empleado;

public class EmpleadoResponseDto {

    private String persona_nombre;
    private String rol;
    private Boolean estado;

    public EmpleadoResponseDto() {
    }

    public EmpleadoResponseDto(String persona_nombre, String rol, Boolean estado) {
        this.persona_nombre = persona_nombre;
        this.rol = rol;
        this.estado = estado;
    }

    public String getPersona_nombre() {
        return persona_nombre;
    }

    public void setPersona_nombre(String persona_nombre) {
        this.persona_nombre = persona_nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EmpleadoResponseDto{" +
                "persona_nombre='" + persona_nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", estado=" + estado +
                '}';
    }
}
