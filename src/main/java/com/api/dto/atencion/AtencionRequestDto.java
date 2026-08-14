package com.api.dto.atencion;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AtencionRequestDto {

    @NotNull(message = "no puede ser nulo")
    @FutureOrPresent(message = "fecha actual o posteriores")
    private LocalDate fecha;

    @NotBlank(message = "motivo obligatorio")
    @NotNull(message = "no puede ser nulo")
    @Size(min = 5, max = 100)
    private String motivo;

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long paciente_id;

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long empleado_id;

    public AtencionRequestDto() {
    }

    public AtencionRequestDto(LocalDate fecha, String motivo, Long paciente_id, Long empleado_id) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.paciente_id = paciente_id;
        this.empleado_id = empleado_id;
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

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public Long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(Long empleado_id) {
        this.empleado_id = empleado_id;
    }

    @Override
    public String toString() {
        return "AtencionRequestDto{" +
                "fecha=" + fecha +
                ", motivo='" + motivo + '\'' +
                ", paciente_id=" + paciente_id +
                ", empleado_id=" + empleado_id +
                '}';
    }
}

