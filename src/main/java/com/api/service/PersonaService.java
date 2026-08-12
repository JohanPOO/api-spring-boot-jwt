package com.api.service;

import com.api.dto.persona.PersonaRequestDto;
import com.api.dto.persona.PersonaResponseDto;

import java.util.List;

public interface PersonaService {

    List<PersonaResponseDto> list ();

    PersonaResponseDto findById (Long id);

    PersonaResponseDto save (PersonaRequestDto personaRequestDto);

    PersonaResponseDto update(PersonaRequestDto personaRequestDto, Long id);

    void delete (Long id);

}
