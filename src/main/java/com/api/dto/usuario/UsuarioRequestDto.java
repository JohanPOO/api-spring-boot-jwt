package com.api.dto.usuario;

import com.api.entity.Persona;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDto {

    @NotBlank(message = "nombre de usuario obligatorio")
    @NotNull(message = "no puede ser nulo")
    @Size(min = 3, max = 50)
    private String usuario;

    @NotBlank(message = "contraseña obligatorio")
    @NotNull(message = "no puede ser nulo")
    @Size(min = 3, max = 50)
    private String contraseña;

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser un numero mayor que 0")
    private Long persona_id;

    public UsuarioRequestDto() {
    }

    public UsuarioRequestDto(String usuario, String contraseña, Long persona_id) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.persona_id = persona_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getPersona_Id() {
        return persona_id;
    }

    public void setPersona_Id(Long persona_id) {
        this.persona_id = persona_id;
    }

    @Override
    public String toString() {
        return "UsuarioRequestDto{" +
                "usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", persona_id=" + persona_id +
                '}';
    }
}
