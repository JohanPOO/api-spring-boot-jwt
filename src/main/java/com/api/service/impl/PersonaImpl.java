package com.api.service.impl;

import com.api.dto.persona.PersonaRequestDto;
import com.api.dto.persona.PersonaResponseDto;
import com.api.entity.Persona;
import com.api.mapper.PersonaMapper;
import com.api.repository.PersonaRepository;
import com.api.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaImpl implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    private PersonaMapper mapper;

    @Override
    public List<PersonaResponseDto> list(Boolean estado, Pageable pageable) {

        Page<Persona> listPersonas = repository.findByEstado(estado, pageable);
        List<PersonaResponseDto> listPersonaDto = new ArrayList<>();

        for ( Persona persona : listPersonas) {
            listPersonaDto.add(mapper.toDto(persona));
        }

        return listPersonaDto;
    }

    @Override
    public PersonaResponseDto findById(Long id) {

        Optional<Persona> personaEncontrada =  repository.findById(id);

        if(personaEncontrada.isEmpty())  return null;

        return mapper.toDto(personaEncontrada.get());
    }

    @Override
    public PersonaResponseDto save(PersonaRequestDto personaRequestDto) {

        Persona persona = mapper.toEntity(personaRequestDto);
        Persona save = repository.save(persona);

        return mapper.toDto(save);
    }

    @Override
    public PersonaResponseDto update(PersonaRequestDto personaRequestDto, Long id) {

        Optional<Persona> personaEncontrada = repository.findById(id);

        if(personaEncontrada.isEmpty()) return null;

        personaEncontrada.get().setNombre(personaRequestDto.getNombre());
        personaEncontrada.get().setEmail(personaRequestDto.getEmail());

        Persona persona = repository.save(personaEncontrada.get());

        return mapper.toDto(persona);
    }

    @Override
    public void delete(Long id) {

        Optional<Persona> personaEncontrada = repository.findById(id);

        if (personaEncontrada.isEmpty()) return;

        personaEncontrada.get().setEstado(false);

        repository.save(personaEncontrada.get());
    }
}
