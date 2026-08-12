package com.api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @Column(name = "rol")
    private String rol;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Atencion> listaAtencion;

    public Paciente() {
    }

    public Paciente(Long id, Persona persona, String rol, Boolean estado) {
        this.id = id;
        this.persona = persona;
        this.rol = rol;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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

    public List<Atencion> getListaAtencion() {
        return listaAtencion;
    }

    public void setListaAtencion(List<Atencion> listaAtencion) {
        this.listaAtencion = listaAtencion;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", persona=" + persona +
                ", rol='" + rol + '\'' +
                ", estado=" + estado +
                '}';
    }
}
