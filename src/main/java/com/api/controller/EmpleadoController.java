package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.empleado.EmpleadoRequestDto;
import com.api.dto.empleado.EmpleadoResponseDto;
import com.api.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllTrue(){
        List<EmpleadoResponseDto> listaEmpleadoResponseDto = service.findAll();

        ResponseDto<List<EmpleadoResponseDto>> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(listaEmpleadoResponseDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        EmpleadoResponseDto empleadoResponseDto = service.findById(id);

        ResponseDto<EmpleadoResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(empleadoResponseDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody EmpleadoRequestDto request){

        EmpleadoResponseDto empleadoResponseDto = service.save(request);

        ResponseDto<EmpleadoResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(empleadoResponseDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid  @RequestBody EmpleadoRequestDto request, @PathVariable  Long id){

        EmpleadoResponseDto empleadoResponseDto = service.update(request, id);

        ResponseDto<EmpleadoResponseDto> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(empleadoResponseDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> response = new ResponseDto<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData("Empleado Eliminado");

        return ResponseEntity.ok(response);

    }

}
