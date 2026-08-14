package com.api.mapper;

import com.api.dto.persona.PersonaRequestDto;
import com.api.dto.persona.PersonaResponseDto;
import com.api.entity.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    public Persona toEntity(PersonaRequestDto personaRequestDto) {

        Persona persona = new Persona();
        persona.setNombre(personaRequestDto.getNombre());
        persona.setEmail(personaRequestDto.getEmail());
        persona.setEstado(true);

        return persona;
    }

    public PersonaResponseDto toDto(Persona persona) {

        PersonaResponseDto personaResponseDto = new PersonaResponseDto();
        personaResponseDto.setNombre(persona.getNombre());
        personaResponseDto.setEmail(persona.getEmail());

        return personaResponseDto;
    }

    /*public PersonaDto toFindDto (Persona persona) {

        PersonaDto personaDto = new PersonaDto();
        personaDto.setId(persona.getId());
        personaDto.setNombre(persona.getNombre());
        personaDto.setEmail(persona.getEmail());
        personaDto.setEstado(persona.getEstado());

        return personaDto;
    }*/


}
