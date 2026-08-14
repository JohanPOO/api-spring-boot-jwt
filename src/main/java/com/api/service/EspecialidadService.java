package com.api.service;


import com.api.dto.especialidad.EspecialidadRequestDto;
import com.api.dto.especialidad.EspecialidadResponseDto;

import java.util.List;

public interface EspecialidadService {

    List<EspecialidadResponseDto> findAll();

    EspecialidadResponseDto findById(Long id);

    EspecialidadResponseDto save(EspecialidadRequestDto especialidadRequestDto);

    EspecialidadResponseDto update(EspecialidadRequestDto especialidadRequestDto, Long id);

    void delete(Long id);
}
