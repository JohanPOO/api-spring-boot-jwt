package com.api.dto.persona;

public class PersonaDto {

    private Long id;
    private String nombre;
    private String email;
    private Boolean estado;

    public PersonaDto() {
    }

    public PersonaDto(Long id, Boolean estado, String email, String nombre) {
        this.id = id;
        this.estado = estado;
        this.email = email;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", estado=" + estado +
                '}';
    }
}
