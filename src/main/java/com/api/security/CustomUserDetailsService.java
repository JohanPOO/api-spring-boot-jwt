package com.api.security;

import com.api.entity.Empleado;
import com.api.entity.Persona;
import com.api.entity.Usuario;
import com.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if(usuario.getPersona_id().getEmpleado() == null){
            return User.withUsername(usuario.getUsuario()).password(usuario.getContraseña()).roles(usuario.getPersona_id().getPaciente().getRol()).build();

        }

        return User.withUsername(usuario.getUsuario()).password(usuario.getContraseña()).roles(usuario.getPersona_id().getEmpleado().getRol()).build();
    }
}
