package com.api.mapper;

import com.api.dto.medicoespecialidad.MedicoEspecialidadResponseDto;
import com.api.entity.Empleado;
import com.api.entity.Especialidad;
import com.api.entity.MedicoEspecialidad;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MedicoEspecialidadMapper {

    public MedicoEspecialidadResponseDto toDto(MedicoEspecialidad medicoEspecialidad){

        String nombre_empleado = medicoEspecialidad.getEmpleado().getPersona().getNombre();
        String rol_empleado = medicoEspecialidad.getEmpleado().getRol();
        String nombre_especialidad = medicoEspecialidad.getEspecialidad().getNombre();

        MedicoEspecialidadResponseDto medicoEspecialidadResponseDto = new MedicoEspecialidadResponseDto();
        medicoEspecialidadResponseDto.setNombre_empleado(nombre_empleado);
        medicoEspecialidadResponseDto.setRol_empleado(rol_empleado);
        medicoEspecialidadResponseDto.setNombre_especialidad(nombre_especialidad);

        return medicoEspecialidadResponseDto;
    }

    public MedicoEspecialidad toEntity(Empleado empleado, Especialidad especialidad){

        MedicoEspecialidad medicoEspecialidad = new MedicoEspecialidad();
        medicoEspecialidad.setEmpleado(empleado);
        medicoEspecialidad.setEspecialidad(especialidad);

        return medicoEspecialidad;
    }

}
