package com.api.service.impl;

import com.api.dto.atencion.AtencionRequestDto;
import com.api.dto.atencion.AtencionResponseDto;
import com.api.entity.Atencion;
import com.api.entity.Empleado;
import com.api.entity.Paciente;
import com.api.exceptions.NullPointerExceptionError;
import com.api.mapper.AtencionMapper;
import com.api.repository.AtencionRepository;
import com.api.repository.EmpleadoRepository;
import com.api.repository.PacienteRepository;
import com.api.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtencionImpl implements AtencionService {

    @Autowired
    private AtencionRepository repository;
    @Autowired
    private EmpleadoRepository repository_empleado;
    @Autowired
    private PacienteRepository repository_paciente;
    @Autowired
    private AtencionMapper mapper;

    @Override
    public List<AtencionResponseDto> findAll() {

        List<Atencion> listaAtencion = repository.findAll();
        List<AtencionResponseDto> listAtencionResponseDto = new ArrayList<>();

        for(Atencion atencion : listaAtencion){

            listAtencionResponseDto.add(mapper.toDto(atencion));
        }

        return listAtencionResponseDto;
    }

    @Override
    public List<AtencionResponseDto> findByMias(Authentication authentication) {

        List<AtencionResponseDto> responseAtencionesMias = new ArrayList<>();

        String usuario = authentication.getName();

        List<Atencion> listaMia = repository.findByMias(usuario);

        if(listaMia.isEmpty()) throw new NullPointerExceptionError("List Attention is empty");

        for (Atencion atencion : listaMia){
            responseAtencionesMias.add(mapper.toDto(atencion));
        }

        return responseAtencionesMias;
    }

    @Override
    public AtencionResponseDto findById(Long id) {

        Atencion atencion = repository.findById(id).orElseThrow(()-> new RuntimeException("Atencion no existe"));

        return mapper.toDto(atencion);
    }

    @Override
    public AtencionResponseDto save(AtencionRequestDto request) {
        Long empleado_id = request.getEmpleado_id();
        Long paciente_id = request.getPaciente_id();

        Empleado empleado = repository_empleado.findById(empleado_id).orElseThrow(()-> new RuntimeException("Empleado no existe"));
        Paciente paciente = repository_paciente.findById(paciente_id).orElseThrow(()-> new RuntimeException("Paciente no existe"));

        Atencion atencion = mapper.toEntity(request, empleado, paciente);

        return mapper.toDto(repository.save(atencion));
    }

    @Override
    public AtencionResponseDto update(AtencionRequestDto request, Long id) {

        Long empleado_id = request.getEmpleado_id();
        Long paciente_id = request.getPaciente_id();

        Empleado empleado = repository_empleado.findById(empleado_id).orElseThrow(()-> new RuntimeException("Empleado no existe"));
        Paciente paciente = repository_paciente.findById(paciente_id).orElseThrow(()-> new RuntimeException("Paciente no existe"));

        Atencion atencion = repository.findById(id).orElseThrow(()-> new RuntimeException("Atencion no existe"));

        atencion.setFecha(request.getFecha());
        atencion.setMotivo(request.getMotivo());
        atencion.setEmpleado(empleado);
        atencion.setPaciente(paciente);

        return mapper.toDto(repository.save(atencion));
    }

    @Override
    public void delete(Long id) {

        Atencion atencion = repository.findById(id).orElseThrow(()-> new RuntimeException("Atencion no existe"));

        atencion.setEstado(false);

        repository.save(atencion);
    }
}
