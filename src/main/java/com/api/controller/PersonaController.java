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
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll() {

        ResponseDto<List<PersonaResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData(service.list());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        PersonaResponseDto personaResponseDto = service.findById(id);

        ResponseDto<PersonaResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success Persona");
        responseDto.setData(personaResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody PersonaRequestDto personaRequestDto){

        PersonaResponseDto personaResponseDto = service.save(personaRequestDto);

        ResponseDto<PersonaResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData(personaResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PersonaRequestDto personaRequestDto, @PathVariable Long id){

        PersonaResponseDto personaResponseDto = service.update(personaRequestDto, id);

        ResponseDto<PersonaResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData(personaResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Success");
        responseDto.setData("Persona Eliminada");

        return ResponseEntity.ok(responseDto);
    }

}
