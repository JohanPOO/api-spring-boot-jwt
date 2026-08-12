package com.api.service;

import com.api.dto.medicoespecialidad.MedicoEspecialidadRequestDto;
import com.api.dto.medicoespecialidad.MedicoEspecialidadResponseDto;

import java.util.List;

public interface MedicoEspecialidadService {

    List<MedicoEspecialidadResponseDto> findAll();

    MedicoEspecialidadResponseDto findById(Long id_empleado, Long id_especialidad);

    MedicoEspecialidadResponseDto save(MedicoEspecialidadRequestDto request);

    MedicoEspecialidadResponseDto update(MedicoEspecialidadRequestDto request, Long id_empleado, Long id_especialidad);

    void delete(Long id_empleado, Long id_especialidad);

}
