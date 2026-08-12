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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atencion")
public class AtencionController {

    @Autowired
    private AtencionService service;

    @GetMapping("/fin-all")
    public ResponseEntity<?> findAll(){

        ResponseDto<List<AtencionResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(service.findAll());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id){

        AtencionResponseDto atencionResponseDto = service.findById(id);

        ResponseDto<AtencionResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(atencionResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody AtencionRequestDto request){

        AtencionResponseDto atencionResponseDto = service.save(request);

        ResponseDto<AtencionResponseDto> responseDto = new ResponseDto<>();

        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(atencionResponseDto);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody AtencionRequestDto request, @PathVariable Long id){

        AtencionResponseDto atencionResponseDto = service.update(request, id);

        ResponseDto<AtencionResponseDto> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData(atencionResponseDto);

        return ResponseEntity.ok(atencionResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successful");
        responseDto.setData("Atencion Eliminado");

        return ResponseEntity.ok(responseDto);
    }
}
