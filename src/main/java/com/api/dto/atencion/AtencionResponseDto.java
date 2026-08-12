package com.api.dto.atencion;

import java.time.LocalDate;

public class AtencionResponseDto {

    private LocalDate fecha;
    private String motivo;
    private String paciente_nombre;
    private String empleado_nombre;

    public AtencionResponseDto() {
    }

    public AtencionResponseDto(LocalDate fecha, String motivo, String paciente_nombre, String empleado_nombre) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.paciente_nombre = paciente_nombre;
        this.empleado_nombre = empleado_nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getPaciente_nombre() {
        return paciente_nombre;
    }

    public void setPaciente_nombre(String paciente_nombre) {
        this.paciente_nombre = paciente_nombre;
    }

    public String getEmpleado_nombre() {
        return empleado_nombre;
    }

    public void setEmpleado_nombre(String empleado_nombre) {
        this.empleado_nombre = empleado_nombre;
    }

    @Override
    public String toString() {
        return "AtencionResponseDto{" +
                "fecha=" + fecha +
                ", motivo='" + motivo + '\'' +
                ", paciente_nombre='" + paciente_nombre + '\'' +
                ", empleado_nombre='" + empleado_nombre + '\'' +
                '}';
    }
}
