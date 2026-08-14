package com.api.service;

import com.api.dto.atencion.AtencionRequestDto;
import com.api.dto.atencion.AtencionResponseDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AtencionService {

    List<AtencionResponseDto> findAll();

    List<AtencionResponseDto> findByMias(Authentication authentication);

    AtencionResponseDto findById(Long id);

    AtencionResponseDto save(AtencionRequestDto request);

    AtencionResponseDto update(AtencionRequestDto request, Long id);

    void delete(Long id);

}
