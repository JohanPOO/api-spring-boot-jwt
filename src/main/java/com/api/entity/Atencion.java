package com.api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "atencion")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "motivo")
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    @Column(name = "estado")
    private Boolean estado;

    public Atencion() {
    }

    public Atencion(Long id, LocalDate fecha, String motivo, Paciente paciente, Empleado empleado, Boolean estado) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.paciente = paciente;
        this.empleado = empleado;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Atencion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", motivo='" + motivo + '\'' +
                ", paciente=" + paciente +
                ", empleado=" + empleado +
                ", estado=" + estado +
                '}';
    }
}
