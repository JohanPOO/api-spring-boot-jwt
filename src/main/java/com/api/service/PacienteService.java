package com.api.service;

import com.api.dto.paciente.PacienteRequestDto;
import com.api.dto.paciente.PacienteResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PacienteService {

    List<PacienteResponseDto> findAll(Boolean estado, Pageable pageable);

    PacienteResponseDto findById(Long id);

    PacienteResponseDto save(PacienteRequestDto pacienteRequestDto);

    PacienteResponseDto update(PacienteRequestDto pacienteRequestDto, Long id);

    void delete(Long id);

}
