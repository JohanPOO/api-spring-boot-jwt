package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.especialidad.EspecialidadRequestDto;
import com.api.dto.especialidad.EspecialidadResponseDto;
import com.api.service.EspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
        ResponseDto<List<EspecialidadResponseDto>> response = new ResponseDto<>();

        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(service.findAll());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        EspecialidadResponseDto especialidadResponseDto = service.findById(id);

        ResponseDto<EspecialidadResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(especialidadResponseDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody EspecialidadRequestDto request){

        EspecialidadResponseDto especialidadResponseDto = service.save(request);

        ResponseDto<EspecialidadResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(especialidadResponseDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EspecialidadRequestDto request, @PathVariable Long id){

        EspecialidadResponseDto especialidadResponseDto = service.update(request, id);

        ResponseDto<EspecialidadResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(especialidadResponseDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData("Especialidad Eliminada");

        return ResponseEntity.ok(responseDto);

    }

}
