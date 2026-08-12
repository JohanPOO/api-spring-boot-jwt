package com.api.mapper;

import com.api.dto.especialidad.EspecialidadRequestDto;
import com.api.dto.especialidad.EspecialidadResponseDto;
import com.api.entity.Especialidad;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadMapper {

    public EspecialidadResponseDto toDto(Especialidad especialidad){
        EspecialidadResponseDto especialidadResponseDto = new EspecialidadResponseDto();

        especialidadResponseDto.setNombre(especialidad.getNombre());
        especialidadResponseDto.setEstado(especialidad.getEstado());

        return especialidadResponseDto;
    }

    public Especialidad toEntity(EspecialidadRequestDto especialidadRequestDto){
        Especialidad especialidad = new Especialidad();

        especialidad.setNombre(especialidadRequestDto.getNombre());
        especialidad.setEstado(especialidadRequestDto.getEstado());

        return especialidad;
    }
}
