package com.api.mapper;

import com.api.dto.empleado.EmpleadoRequestDto;
import com.api.dto.empleado.EmpleadoResponseDto;
import com.api.dto.paciente.PacienteResponseDto;
import com.api.entity.Empleado;
import com.api.entity.Paciente;
import com.api.entity.Persona;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public EmpleadoResponseDto toDto(Empleado empleado){
        EmpleadoResponseDto empleadoResponseDto = new EmpleadoResponseDto();

        empleadoResponseDto.setPersona_nombre(empleado.getPersona().getNombre());
        empleadoResponseDto.setRol(empleado.getRol());
        empleadoResponseDto.setEstado(empleado.getEstado());

        return empleadoResponseDto;
    }

    public Empleado toEntity(EmpleadoRequestDto empleadoRequestDto, Persona persona){
        Empleado empleado = new Empleado();

        empleado.setPersona(persona);
        empleado.setRol(empleadoRequestDto.getRol());
        empleado.setEstado(true);

        return empleado;
    }
}
