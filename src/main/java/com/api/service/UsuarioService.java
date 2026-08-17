package com.api.service;

import com.api.dto.usuario.UsuarioRequestDto;
import com.api.dto.usuario.UsuarioResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponseDto> findAll(Pageable pageable);

    UsuarioResponseDto findById(Long id);

    UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto update(UsuarioRequestDto usuarioRequestDto, Long id);

    void delete(Long id);
}
