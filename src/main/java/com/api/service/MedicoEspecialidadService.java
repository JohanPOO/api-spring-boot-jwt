package com.api.service;

import com.api.dto.medicoespecialidad.MedicoEspecialidadRequestDto;
import com.api.dto.medicoespecialidad.MedicoEspecialidadResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MedicoEspecialidadService {

    List<MedicoEspecialidadResponseDto> findAll(Pageable pageable);

    MedicoEspecialidadResponseDto findById(Long id_empleado, Long id_especialidad);

    MedicoEspecialidadResponseDto save(MedicoEspecialidadRequestDto request);

    MedicoEspecialidadResponseDto update(MedicoEspecialidadRequestDto request, Long id_empleado, Long id_especialidad);

    void delete(Long id_empleado, Long id_especialidad);

}
