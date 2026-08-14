package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.persona.PersonaRequestDto;
import com.api.dto.persona.PersonaResponseDto;
import com.api.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping()
    public ResponseEntity<?> findAll() {

        ResponseDto<List<PersonaResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData(service.list());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        PersonaResponseDto personaResponseDto = service.findById(id);

        ResponseDto<PersonaResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success Persona");
        responseDto.setData(personaResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody PersonaRequestDto personaRequestDto){

        PersonaResponseDto personaResponseDto = service.save(personaRequestDto);

        ResponseDto<PersonaResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData(personaResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PersonaRequestDto personaRequestDto, @PathVariable Long id){

        PersonaResponseDto personaResponseDto = service.update(personaRequestDto, id);

        ResponseDto<PersonaResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData(personaResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData("Persona Eliminada");

        return ResponseEntity.ok(responseDto);
    }

}
