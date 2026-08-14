package com.api.dto.usuario;

import com.api.entity.Persona;

public class UsuarioResponseDto {

    private String usuario;
    private String persona;

    public UsuarioResponseDto(String usuario, String persona) {
        this.usuario = usuario;
        this.persona = persona;
    }

    public UsuarioResponseDto() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "UsuarioResponseDto{" +
                "usuario='" + usuario + '\'' +
                ", persona=" + persona +
                '}';
    }
}

