package com.api.controller;

import com.api.dto.ResponseDto;
import com.api.dto.usuario.UsuarioRequestDto;
import com.api.dto.usuario.UsuarioResponseDto;
import com.api.entity.Persona;
import com.api.entity.Usuario;
import com.api.repository.UsuarioRepository;
import com.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping()
    public ResponseEntity<?> findAll(){

        List<UsuarioResponseDto> listaUsuario = service.findAll();

        ResponseDto<List<UsuarioResponseDto>> response = new ResponseDto<>();

        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(listaUsuario);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        UsuarioResponseDto usuarioResponseDto = service.findById(id);

        ResponseDto<UsuarioResponseDto> response = new ResponseDto<>();

        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(usuarioResponseDto);

        return ResponseEntity.ok(response);

    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody UsuarioRequestDto request){

        UsuarioResponseDto usuarioResponseDto = service.save(request);

        ResponseDto<UsuarioResponseDto> response = new ResponseDto<>();

        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(usuarioResponseDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UsuarioRequestDto request, @PathVariable Long id ){

        UsuarioResponseDto usuarioResponseDto = service.update(request, id);

        ResponseDto<UsuarioResponseDto> response = new ResponseDto<>();

        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData(usuarioResponseDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDto<String> response = new ResponseDto<>();

        response.setStatus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setData("Usuario Eliminado");

        return ResponseEntity.ok(response);
    }

}
