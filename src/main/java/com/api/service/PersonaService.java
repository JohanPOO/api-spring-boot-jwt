package com.api.service;

import com.api.dto.persona.PersonaRequestDto;
import com.api.dto.persona.PersonaResponseDto;
import com.api.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService {

    List<PersonaResponseDto> list (Boolean estado, Pageable pageable);

    PersonaResponseDto findById (Long id);

    PersonaResponseDto save (PersonaRequestDto personaRequestDto);

    PersonaResponseDto update(PersonaRequestDto personaRequestDto, Long id);

    void delete (Long id);

}
