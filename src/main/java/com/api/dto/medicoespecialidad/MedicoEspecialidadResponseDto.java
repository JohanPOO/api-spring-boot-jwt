package com.api.dto.medicoespecialidad;

public class MedicoEspecialidadResponseDto {

    private String nombre_empleado;
    private String rol_empleado;
    private String nombre_especialidad;

    public MedicoEspecialidadResponseDto() {
    }

    public MedicoEspecialidadResponseDto(String nombre_empleado, String rol_empleado, String nombre_especialidad) {
        this.nombre_empleado = nombre_empleado;
        this.rol_empleado = rol_empleado;
        this.nombre_especialidad = nombre_especialidad;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getRol_empleado() {
        return rol_empleado;
    }

    public void setRol_empleado(String rol_empleado) {
        this.rol_empleado = rol_empleado;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    @Override
    public String toString() {
        return "MedicoEspecialidadResponseDto{" +
                "nombre_empleado='" + nombre_empleado + '\'' +
                ", rol_empleado='" + rol_empleado + '\'' +
                ", nombre_especialidad='" + nombre_especialidad + '\'' +
                '}';
    }
}
