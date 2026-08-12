package com.api.service.impl;

import com.api.dto.usuario.UsuarioRequestDto;
import com.api.dto.usuario.UsuarioResponseDto;
import com.api.entity.Persona;
import com.api.entity.Usuario;
import com.api.mapper.UsuarioMapper;
import com.api.repository.PersonaRepository;
import com.api.repository.UsuarioRepository;
import com.api.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PersonaRepository repository_persona;

    @Autowired
    private UsuarioMapper mapper;

    @Override
    public List<UsuarioResponseDto> findAll() {

        List<Usuario> listaUsuarios = repository.findAll();
        List<UsuarioResponseDto> listaUsuarioDto = new ArrayList<>();

        for(Usuario usuario : listaUsuarios){
            listaUsuarioDto.add(mapper.toDto(usuario));
        }

        return listaUsuarioDto;
    }

    @Override
    public UsuarioResponseDto findById(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario no existe"));

        return mapper.toDto(usuario);
    }

    @Override
    public UsuarioResponseDto save(UsuarioRequestDto usuarioRequestDto) {

        Long persona_id = usuarioRequestDto.getPersona_Id();
        Persona personaEntity = repository_persona.findById(persona_id).orElseThrow(()-> new RuntimeException("Persona no existe"));

        Usuario usuario = mapper.toEntity(usuarioRequestDto, personaEntity);

        return mapper.toDto(repository.save(usuario));
    }

    @Override
    public UsuarioResponseDto update(UsuarioRequestDto usuarioRequestDto, Long id) {

        Long persona_id = usuarioRequestDto.getPersona_Id();
        Persona personaEntity = repository_persona.findById(persona_id).orElseThrow(()-> new RuntimeException("Persona no existe"));

        Usuario usuario = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario no existe"));

        //USAR EL MAPPER//
        usuario.setUsuario(usuarioRequestDto.getUsuario());
        usuario.setContraseña(usuarioRequestDto.getContraseña());
        usuario.setPersona_id(personaEntity);

        return mapper.toDto(repository.save(usuario));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario no existe"));

        Persona persona = usuario.getPersona_id();

        if(persona != null) persona.setUsuario(null);

        usuario.setPersona_id(null);

        repository.delete(usuario);
    }
}
