package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.atencion.AtencionRequestDto;
import com.api.dto.atencion.AtencionResponseDto;
import com.api.repository.AtencionRepository;
import com.api.service.AtencionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService service;

    @GetMapping()
    public ResponseEntity<?> findAll(){

        ResponseDto<List<AtencionResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(service.findAll());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/mias")
    public ResponseEntity<?> findByMias(Authentication authentication) {

        List<AtencionResponseDto> listasMias =  service.findByMias(authentication);

        ResponseDto<List<AtencionResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(listasMias);

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<?> findByFecha(@PathVariable LocalDate fecha) {

        ResponseDto<List<AtencionResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(service.findByFecha(fecha));

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/medico/{medico}")
    public ResponseEntity<?> findByMedico(@PathVariable String medico) {

        ResponseDto<List<AtencionResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(service.findByMedico(medico));

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        AtencionResponseDto atencionResponseDto = service.findById(id);

        ResponseDto<AtencionResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(atencionResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody AtencionRequestDto request){

        AtencionResponseDto atencionResponseDto = service.save(request);

        ResponseDto<AtencionResponseDto> responseDto = new ResponseDto<>();

        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(atencionResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody AtencionRequestDto request, @PathVariable Long id){

        AtencionResponseDto atencionResponseDto = service.update(request, id);

        ResponseDto<AtencionResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(atencionResponseDto);

        return ResponseEntity.ok(atencionResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData("Atencion Eliminado");

        return ResponseEntity.ok(responseDto);
    }
}
