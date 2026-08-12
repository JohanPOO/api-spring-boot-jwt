package com.api.mapper;

import com.api.dto.atencion.AtencionRequestDto;
import com.api.dto.atencion.AtencionResponseDto;
import com.api.entity.Atencion;
import com.api.entity.Empleado;
import com.api.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class AtencionMapper {

    public AtencionResponseDto toDto(Atencion atencion){

        String nombre_paciente = atencion.getPaciente().getPersona().getNombre();
        String nombre_empleado = atencion.getEmpleado().getPersona().getNombre();

        AtencionResponseDto atencionResponseDto = new AtencionResponseDto();

        atencionResponseDto.setFecha(atencion.getFecha());
        atencionResponseDto.setMotivo(atencion.getMotivo());
        atencionResponseDto.setPaciente_nombre(nombre_paciente);
        atencionResponseDto.setEmpleado_nombre(nombre_empleado);

        return atencionResponseDto;
    }

    public Atencion toEntity(AtencionRequestDto request, Empleado empleado, Paciente paciente){

        Atencion atencion = new Atencion();

        atencion.setFecha(request.getFecha());
        atencion.setMotivo(request.getMotivo());
        atencion.setEmpleado(empleado);
        atencion.setPaciente(paciente);
        atencion.setEstado(true);

        return atencion;
    }

}
