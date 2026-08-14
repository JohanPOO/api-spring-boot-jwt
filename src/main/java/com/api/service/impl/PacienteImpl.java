package com.api.service.impl;

import com.api.dto.paciente.PacienteRequestDto;
import com.api.dto.paciente.PacienteResponseDto;
import com.api.entity.Paciente;
import com.api.entity.Persona;
import com.api.mapper.PacienteMapper;
import com.api.repository.PacienteRepository;
import com.api.repository.PersonaRepository;
import com.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteImpl implements PacienteService {

    @Autowired
    private PacienteRepository repository;
    @Autowired
    private PersonaRepository repository_persona;
    @Autowired
    private PacienteMapper mapper;

    @Override
    public List<PacienteResponseDto> findAll() {

        List<Paciente> listaPacientes = repository.findByEstadoTrue();

        List<PacienteResponseDto> listaPacientesDto = new ArrayList<>();

        //Pasar la lista de pacientes a DTO
        for(Paciente paciente : listaPacientes){
            listaPacientesDto.add(mapper.toDto(paciente));
        }

        //Devolver la lista de paciente DTO al controller
        return listaPacientesDto;
    }

    @Override
    public PacienteResponseDto findById(Long id) {

        //Encontrar si el paciente existe por id
        Paciente paciente = repository.findById(id).orElseThrow(()-> new RuntimeException("Paciente no existe"));

        //Pasar al paciente a DTO y mandar al controlador
        return mapper.toDto(paciente);
    }

    @Override
    public PacienteResponseDto save(PacienteRequestDto pacienteRequestDto) {

        //Buscar el id de la persona si existe
        Long id = pacienteRequestDto.getId_persona();
        Persona persona = repository_persona.findById(id).orElseThrow(()-> new RuntimeException("Persona no existe"));

        //Mapear los datos a un Entity
        Paciente paciente = mapper.toEntity(pacienteRequestDto, persona);

        //Guardar a la db y devolver en dto al controller
        return mapper.toDto(repository.save(paciente));
    }

    @Override
    public PacienteResponseDto update(PacienteRequestDto pacienteRequestDto, Long id) {

        Long id_persona = pacienteRequestDto.getId_persona();

        //Buscar por id si la persona nueva existe
        Persona persona = repository_persona.findById(id_persona).orElseThrow(()-> new RuntimeException("Persona no existe"));

        //Buscar por id al paciente si existe
        Paciente paciente = repository.findById(id).orElseThrow(()-> new RuntimeException("Paciente no existe"));

        //Mapear//
        paciente.setPersona(persona);
        paciente.setRol(pacienteRequestDto.getRol());

        return mapper.toDto(repository.save(paciente));
    }

    @Override
    public void delete(Long id) {

        Paciente paciente = repository.findById(id).orElseThrow(()-> new RuntimeException("Paciente no existe"));
        Persona persona = paciente.getPersona();

        if(persona.getPaciente() != null) persona.setPaciente(null);

        paciente.setPersona(null);

        repository.delete(paciente);
    }
}
