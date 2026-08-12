package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.paciente.PacienteRequestDto;
import com.api.dto.paciente.PacienteResponseDto;
import com.api.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllTrue(){
        List<PacienteResponseDto> listaPacienteResponseDto = service.findAll();

        ResponseDto<List<PacienteResponseDto>> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(listaPacienteResponseDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        PacienteResponseDto pacienteResponseDto = service.findById(id);

        ResponseDto<PacienteResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(pacienteResponseDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody PacienteRequestDto request){

        PacienteResponseDto pacienteResponseDto = service.save(request);

        ResponseDto<PacienteResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(pacienteResponseDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PacienteRequestDto request, @PathVariable  Long id){

        PacienteResponseDto pacienteResponseDto = service.update(request, id);

        ResponseDto<PacienteResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(pacienteResponseDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData("Paciente Eliminado");

        return ResponseEntity.ok(response);

    }
}
