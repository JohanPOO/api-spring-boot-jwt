package com.api.service;

import com.api.dto.empleado.EmpleadoRequestDto;
import com.api.dto.empleado.EmpleadoResponseDto;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoResponseDto> findAll();

    EmpleadoResponseDto findById(Long id);

    EmpleadoResponseDto save(EmpleadoRequestDto empleadoRequestDto);

    EmpleadoResponseDto update(EmpleadoRequestDto empleadoRequestDto, Long id);

    void delete(Long id);

}
