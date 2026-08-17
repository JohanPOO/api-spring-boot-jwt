package com.api.service;

import com.api.dto.empleado.EmpleadoRequestDto;
import com.api.dto.empleado.EmpleadoResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoResponseDto> findAll(Boolean estado, Pageable pageable);

    EmpleadoResponseDto findById(Long id);

    EmpleadoResponseDto save(EmpleadoRequestDto empleadoRequestDto);

    EmpleadoResponseDto update(EmpleadoRequestDto empleadoRequestDto, Long id);

    void delete(Long id);

}
