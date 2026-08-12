package com.api.mapper;

import com.api.dto.usuario.UsuarioRequestDto;
import com.api.dto.usuario.UsuarioResponseDto;
import com.api.entity.Persona;
import com.api.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioResponseDto toDto(Usuario usuario) {

        String nombre_persona = usuario.getPersona_id().getNombre();

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setUsuario(usuario.getUsuario());
        usuarioResponseDto.setPersona(nombre_persona);


        return usuarioResponseDto;
    }

    public Usuario toEntity(UsuarioRequestDto usuarioRequestDto, Persona personaEntity){

        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioRequestDto.getUsuario());
        usuario.setContraseña(passwordEncoder.encode(usuarioRequestDto.getContraseña()));

        usuario.setPersona_id(personaEntity);
        //personaEntity.setUsuario(usuario);

        return usuario;
    }

}
