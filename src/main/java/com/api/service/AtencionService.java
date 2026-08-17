package com.api.service;

import com.api.dto.atencion.AtencionRequestDto;
import com.api.dto.atencion.AtencionResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.time.LocalDate;
import java.util.List;

public interface AtencionService {

    List<AtencionResponseDto> findAll(Boolean estado, Pageable pageable);

    List<AtencionResponseDto> findByMias(Authentication authentication);

    List<AtencionResponseDto> findByFecha(LocalDate fecha);

    List<AtencionResponseDto> findByMedico(String nombre);

    AtencionResponseDto findById(Long id);

    AtencionResponseDto save(AtencionRequestDto request);

    AtencionResponseDto update(AtencionRequestDto request, Long id);

    void delete(Long id);

}
