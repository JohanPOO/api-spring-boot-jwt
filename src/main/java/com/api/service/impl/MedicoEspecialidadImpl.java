package com.api.service.impl;

import com.api.dto.medicoespecialidad.MedicoEspecialidadRequestDto;
import com.api.dto.medicoespecialidad.MedicoEspecialidadResponseDto;
import com.api.entity.Empleado;
import com.api.entity.Especialidad;
import com.api.entity.MedicoEspecialidad;
import com.api.mapper.MedicoEspecialidadMapper;
import com.api.repository.EmpleadoRepository;
import com.api.repository.EspecialidadRepository;
import com.api.repository.MedicoEspecialidadRepository;
import com.api.service.MedicoEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoEspecialidadImpl implements MedicoEspecialidadService {

    @Autowired
    private MedicoEspecialidadRepository repository;
    @Autowired
    private EmpleadoRepository repository_empleado;
    @Autowired
    private EspecialidadRepository repository_especialidad;
    @Autowired
    private MedicoEspecialidadMapper mapper;

    @Override
    public List<MedicoEspecialidadResponseDto> findAll(Pageable pageable) {

        Page<MedicoEspecialidad> listaMedicoEspecialidad = repository.findAll(pageable);
        List<MedicoEspecialidadResponseDto> responseDtoList = new ArrayList<>();

        for (MedicoEspecialidad medicoEspecialidad : listaMedicoEspecialidad){
            responseDtoList.add(mapper.toDto(medicoEspecialidad));
        }

        return responseDtoList;
    }

    @Override
    public MedicoEspecialidadResponseDto findById(Long id_empleado, Long id_especialidad) {

        MedicoEspecialidad medicoEspecialidad = repository.findByEmpleado_IdAndEspecialidad_Id(id_empleado, id_especialidad);

        if(medicoEspecialidad == null) throw new RuntimeException("MedicoEspecialidad no existe");

        return mapper.toDto(medicoEspecialidad);
    }

    @Override
    public MedicoEspecialidadResponseDto save(MedicoEspecialidadRequestDto request) {

        Long empleado_id = request.getEmpleado_id();
        Long especialidad_id = request.getEspecialidad_id();

        Empleado empleado = repository_empleado.findById(empleado_id).orElseThrow(()-> new RuntimeException("Empleado no existe"));
        Especialidad especialidad = repository_especialidad.findById(especialidad_id).orElseThrow(()-> new RuntimeException("Especialidad no existe"));

        MedicoEspecialidad medicoEspecialidad = mapper.toEntity(empleado,especialidad);

        return mapper.toDto(repository.save(medicoEspecialidad));
    }

    @Override
    public MedicoEspecialidadResponseDto update(MedicoEspecialidadRequestDto request, Long id_empleado, Long id_especialidad) {

        MedicoEspecialidad medicoEspecialidad = repository.findByEmpleado_IdAndEspecialidad_Id(id_empleado, id_especialidad);

        Empleado empleado = repository_empleado.findById(request.getEmpleado_id()).orElseThrow(()-> new RuntimeException("Empleado no existe"));
        Especialidad especialidad = repository_especialidad.findById(request.getEspecialidad_id()).orElseThrow(()-> new RuntimeException("Especialidad no existe"));

        if(medicoEspecialidad == null) throw new RuntimeException("MedicoEspecialidad no existe");

        medicoEspecialidad.setEmpleado(empleado);
        medicoEspecialidad.setEspecialidad(especialidad);

        repository.save(medicoEspecialidad);

        return mapper.toDto(medicoEspecialidad);
    }

    @Override
    public void delete(Long id_empleado, Long id_especialidad) {

        MedicoEspecialidad medicoEspecialidad = repository.findByEmpleado_IdAndEspecialidad_Id(id_empleado, id_especialidad);

        if(medicoEspecialidad == null) throw new RuntimeException("MedicoEspecialidad no existe");

        repository.delete(medicoEspecialidad);
    }
}
