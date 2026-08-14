package com.api.config;

import com.api.security.CustomUserDetailsService;
import com.api.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/**","/usuarios/save")
                        .permitAll()
                        //Atenciones
                        .requestMatchers(HttpMethod.GET, "/atenciones").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/atenciones/mias").hasRole("PACIENTE")
                        .requestMatchers(HttpMethod.POST,"/atenciones").hasAnyRole("ADMIN", "MEDICO")
                        .requestMatchers(HttpMethod.PUT, "/atenciones/**").hasAnyRole("ADMIN", "MEDICO")
                        .requestMatchers(HttpMethod.DELETE, "/atenciones/**").hasRole("ADMIN")
                        //Empleado
                        .requestMatchers("/empleados/**").hasRole("ADMIN")
                        //Especialidades
                        .requestMatchers("/especialidades/**").hasAnyRole("ADMIN", "MEDICO")
                        //MedicoEspecialidades
                        .requestMatchers(HttpMethod.GET, "/medicoespecialidades").hasRole("MEDICO")
                        .requestMatchers("/medicoespecialidades/**").hasRole("ADMIN")
                        //Pacientes
                        .requestMatchers("/pacientes/**").hasAnyRole("ADMIN", "MEDICO")
                        //Personas
                        .requestMatchers("/pacientes/**").hasRole("ADMIN")
                        //Usuario
                        .requestMatchers("/usuarios/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider);

        http.addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }

    @Bean
    AuthenticationProvider authenticationProvider(CustomUserDetailsService detailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(detailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

}
