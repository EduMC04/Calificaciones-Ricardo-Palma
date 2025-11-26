package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        // 1. Permite el acceso al formulario de evaluación
                        .requestMatchers("/FormularioEvaluacion").permitAll()

                        // 2. ¡CRUCIAL! Permite el acceso a la URL de inicio de sesión
                        .requestMatchers("/login").permitAll()

                        // 3. Cualquier otra solicitud debe estar autenticada
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/PaginaPrincipal")
                        .permitAll() // Esto es solo para la configuración del formLogin, no de la ruta.
                );

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}