package com.api.dto.medicoespecialidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MedicoEspecialidadRequestDto {


    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long empleado_id;


    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long especialidad_id;

    public MedicoEspecialidadRequestDto() {
    }

    public MedicoEspecialidadRequestDto(Long empleado_id, Long especialidad_id) {
        this.empleado_id = empleado_id;
        this.especialidad_id = especialidad_id;
    }

    public Long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(Long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public Long getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(Long especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    @Override
    public String toString() {
        return "MedicoEspecialidadRequestDto{" +
                "empleado_id=" + empleado_id +
                ", especialidad_id=" + especialidad_id +
                '}';
    }
}
