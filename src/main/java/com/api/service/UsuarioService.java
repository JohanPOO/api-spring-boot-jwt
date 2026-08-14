package com.api.service;

import com.api.dto.usuario.UsuarioRequestDto;
import com.api.dto.usuario.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponseDto> findAll();

    UsuarioResponseDto findById(Long id);

    UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto update(UsuarioRequestDto usuarioRequestDto, Long id);

    void delete(Long id);
}
