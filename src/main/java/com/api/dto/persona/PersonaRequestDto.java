package com.api.dto.persona;

import jakarta.validation.constraints.*;

public class PersonaRequestDto {

    @NotBlank(message = "nombre obligatorio")
    @NotNull(message = "no puede ser nulo")
    @Size(min = 3, max = 50)
    private String nombre;

    @NotBlank(message = "nombre obligatorio")
    @NotNull(message = "no puede ser nulo")
    @Email(message = "formato invalido del correo")
    private String email;

    public PersonaRequestDto() {
    }

    public PersonaRequestDto(String nombre, String email) {
        this.email = email;
        this.nombre = nombre;
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

}
