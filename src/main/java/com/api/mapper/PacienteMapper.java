package com.api.mapper;

import com.api.dto.paciente.PacienteRequestDto;
import com.api.dto.paciente.PacienteResponseDto;
import com.api.entity.Paciente;
import com.api.entity.Persona;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteResponseDto toDto(Paciente paciente) {

        PacienteResponseDto pacienteResponseDto = new PacienteResponseDto();

        pacienteResponseDto.setPersona_nombre(paciente.getPersona().getNombre());
        pacienteResponseDto.setRol(paciente.getRol());
        pacienteResponseDto.setEstado(paciente.getEstado());

        return pacienteResponseDto;
    }

    public Paciente toEntity(PacienteRequestDto pacienteRequestDto, Persona persona){

        Paciente paciente = new Paciente();

        paciente.setPersona(persona);
        paciente.setRol(pacienteRequestDto.getRol());
        paciente.setEstado(true);

        return paciente;
    }

}
