package com.api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicoespecialidad")
public class MedicoEspecialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;

    public MedicoEspecialidad() {
    }

    public MedicoEspecialidad(Long id, Empleado empleado, Especialidad especialidad) {
        this.id = id;
        this.empleado = empleado;
        this.especialidad = especialidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MedicoEspecialidad{" +
                "id=" + id +
                ", empleado=" + empleado +
                ", especialidad=" + especialidad +
                '}';
    }
}
