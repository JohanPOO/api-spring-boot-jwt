package com.api.service.impl;

import com.api.dto.empleado.EmpleadoRequestDto;
import com.api.dto.empleado.EmpleadoResponseDto;
import com.api.entity.Empleado;
import com.api.entity.Paciente;
import com.api.entity.Persona;
import com.api.mapper.EmpleadoMapper;
import com.api.repository.EmpleadoRepository;
import com.api.repository.PersonaRepository;
import com.api.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;
    @Autowired
    private PersonaRepository repository_persona;
    @Autowired
    private EmpleadoMapper mapper;

    @Override
    public List<EmpleadoResponseDto> findAll(Boolean estado, Pageable pageable) {
        Page<Empleado> listaPacientes = repository.findByEstadoTrue(estado, pageable);

        List<EmpleadoResponseDto> listaPacientesDto = new ArrayList<>();

        //Pasar la lista de pacientes a DTO
        for(Empleado paciente : listaPacientes){
            listaPacientesDto.add(mapper.toDto(paciente));
        }

        //Devolver la lista de paciente DTO al controller
        return listaPacientesDto;
    }

    @Override
    public EmpleadoResponseDto findById(Long id) {
        //Encontrar si el paciente existe por id
        Empleado empleado = repository.findById(id).orElseThrow(()-> new RuntimeException("Empleado no existe"));

        //Pasar al paciente a DTO y mandar al controlador
        return mapper.toDto(empleado);
    }

    @Override
    public EmpleadoResponseDto save(EmpleadoRequestDto empleadoRequestDto) {
        //Buscar el id de la persona si existe
        Long id = empleadoRequestDto.getPersona_id();
        Persona persona = repository_persona.findById(id).orElseThrow(()-> new RuntimeException("Persona no existe"));

        //Mapear los datos a un Entity
        Empleado empleado = mapper.toEntity(empleadoRequestDto, persona);

        //Guardar a la db y devolver en dto al controller
        return mapper.toDto(repository.save(empleado));
    }

    @Override
    public EmpleadoResponseDto update(EmpleadoRequestDto empleadoRequestDto, Long id) {

        Long id_persona = empleadoRequestDto.getPersona_id();

        //Buscar por id si la persona nueva existe
        Persona persona = repository_persona.findById(id_persona).orElseThrow(()-> new RuntimeException("Persona no existe"));

        //Buscar por id al paciente si existe
        Empleado empleado = repository.findById(id).orElseThrow(()-> new RuntimeException("Empleado no existe"));

        //Mapear//
        empleado.setPersona(persona);
        empleado.setRol(empleadoRequestDto.getRol());

        return mapper.toDto(repository.save(empleado));
    }

    @Override
    public void delete(Long id) {
        Empleado empleado = repository.findById(id).orElseThrow(()-> new RuntimeException("Empleado no existe"));
        Persona persona = empleado.getPersona();

        if(persona.getEmpleado() != null) persona.setEmpleado(null);

        empleado.setPersona(null);

        repository.delete(empleado);
    }
}
