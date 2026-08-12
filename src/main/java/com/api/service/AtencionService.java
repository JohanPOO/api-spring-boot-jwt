package com.api.service;

import com.api.dto.atencion.AtencionRequestDto;
import com.api.dto.atencion.AtencionResponseDto;

import java.util.List;

public interface AtencionService {

    List<AtencionResponseDto> findAll();

    AtencionResponseDto findById(Long id);

    AtencionResponseDto save(AtencionRequestDto request);

    AtencionResponseDto update(AtencionRequestDto request, Long id);

    void delete(Long id);

}
