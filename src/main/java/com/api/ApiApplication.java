package com.api;

import com.api.dto.persona.PersonaDto;
import com.api.dto.persona.PersonaRequestDto;
import com.api.dto.usuario.UsuarioRequestDto;
import com.api.entity.Empleado;
import com.api.entity.Persona;
import com.api.entity.Usuario;
import com.api.mapper.PersonaMapper;
import com.api.mapper.UsuarioMapper;
import com.api.repository.EmpleadoRepository;
import com.api.repository.PersonaRepository;
import com.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

    @Autowired
    PersonaMapper mapper;

    @Bean
    CommandLineRunner init(PersonaRepository repository, UsuarioRepository urepository, EmpleadoRepository erepository, BCryptPasswordEncoder encoder) {
        return args -> {

            PersonaRequestDto registro1 = new PersonaRequestDto("admin", "admin@correo.com");
            //PersonaRequestDto registro2 = new PersonaRequestDto("example", "example@correo.com");

            if (repository.count() == 0) {
                Persona persona1 = repository.save(mapper.toEntity(registro1));
                //Persona persona2 = repository.save(mapper.toEntity(registro2));
                String passwordHash = encoder.encode("admin");
                urepository.save(new Usuario(null, "admin", passwordHash, persona1));
                //urepository.save(new Usuario(null, "example", "example", persona2));

                erepository.save(new Empleado(null, persona1,"ROL_ADMIN", true));
            }
        };
    }



}
