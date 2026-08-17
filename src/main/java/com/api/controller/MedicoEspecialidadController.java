package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.medicoespecialidad.MedicoEspecialidadRequestDto;
import com.api.dto.medicoespecialidad.MedicoEspecialidadResponseDto;
import com.api.service.MedicoEspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicoespecialidades")
public class MedicoEspecialidadController {

    @Autowired
    private MedicoEspecialidadService service;

    @GetMapping()
    public ResponseEntity<?> findAll(Pageable pageable){

        ResponseDto<List<MedicoEspecialidadResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(service.findAll(pageable));

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/find/empleado/{id_empleado}/especialidad/{id_especialidad}")
    public ResponseEntity<?> findById_EmpleadoAndId_Especialidad
            (@PathVariable Long id_empleado, @PathVariable Long id_especialidad){

        MedicoEspecialidadResponseDto medicoEspecialidadResponseDto = service.findById(id_empleado, id_especialidad);

        ResponseDto<MedicoEspecialidadResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(medicoEspecialidadResponseDto);

        return ResponseEntity.ok(responseDto);

    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody MedicoEspecialidadRequestDto request){

        MedicoEspecialidadResponseDto medicoEspecialidadResponseDto = service.save(request);

        ResponseDto<MedicoEspecialidadResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(medicoEspecialidadResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update/empleado/{id_empleado}/especialidad/{id_especialidad}")
    public ResponseEntity<?> update
            (@Valid  @RequestBody MedicoEspecialidadRequestDto request, @PathVariable Long id_empleado, @PathVariable Long id_especialidad){

        MedicoEspecialidadResponseDto medicoEspecialidadResponseDto = service.update(request, id_empleado, id_especialidad);

        ResponseDto<MedicoEspecialidadResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(medicoEspecialidadResponseDto);

        return ResponseEntity.ok(responseDto);

    }

    @DeleteMapping("/delete/empleado/{id_empleado}/especialidad/{id_especialidad}")
    public ResponseEntity<?> delete(@PathVariable Long id_empleado, @PathVariable Long id_especialidad){

        service.delete(id_empleado, id_especialidad);

        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData("Medico Especialidad Eliminado");

        return ResponseEntity.ok(responseDto);

    }
}
