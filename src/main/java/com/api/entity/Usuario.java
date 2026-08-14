package com.api.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contraseña")
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Usuario(){

    }

    public Usuario(Long id, String usuario, String contrasena, Persona persona){
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public Persona getPersona_id() {
        return persona;
    }

    public void setPersona_id(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contrasena + '\'' +
                ", persona='" + persona + '\'' +
                '}';
    }
}
