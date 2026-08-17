package com.api.service.impl;

import com.api.dto.especialidad.EspecialidadRequestDto;
import com.api.dto.especialidad.EspecialidadResponseDto;
import com.api.dto.persona.PersonaResponseDto;
import com.api.entity.Especialidad;
import com.api.entity.Persona;
import com.api.mapper.EspecialidadMapper;
import com.api.repository.EspecialidadRepository;
import com.api.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository repository;
    @Autowired
    private EspecialidadMapper mapper;

    @Override
    public List<EspecialidadResponseDto> findAll(Boolean estado, Pageable pageable) {
        Page<Especialidad> listaEspecialidad = repository.findByEstado(estado, pageable);
        List<EspecialidadResponseDto> listEspecialidadDto = new ArrayList<>();

        for ( Especialidad especialidad : listaEspecialidad) {
            listEspecialidadDto.add(mapper.toDto(especialidad));
        }

        return listEspecialidadDto;
    }

    @Override
    public EspecialidadResponseDto findById(Long id) {
        Especialidad especialidad =  repository.findById(id).orElseThrow(()-> new RuntimeException("Especialidad no existe"));

        return mapper.toDto(especialidad);
    }

    @Override
    public EspecialidadResponseDto save(EspecialidadRequestDto especialidadRequestDto) {
        Especialidad especialidad = mapper.toEntity(especialidadRequestDto);

        return mapper.toDto(repository.save(especialidad));
    }

    @Override
    public EspecialidadResponseDto update(EspecialidadRequestDto especialidadRequestDto, Long id) {
        Especialidad especialidad =  repository.findById(id).orElseThrow(()-> new RuntimeException("Especialidad no existe"));

        especialidad.setNombre(especialidadRequestDto.getNombre());
        especialidad.setEstado(true);

        return mapper.toDto(repository.save(especialidad));
    }

    @Override
    public void delete(Long id) {
        Especialidad especialidad =  repository.findById(id).orElseThrow(()-> new RuntimeException("Especialidad no existe"));

        especialidad.setEstado(false);

        repository.save(especialidad);
    }
}
