package com.dh.clinica.demo.config;

import com.dh.clinica.demo.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UsuarioService usuarioService;
    private final String USER = "USER";
    private final String ADMIN = "ADMIN";

    @Autowired
    public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UsuarioService usuarioService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.usuarioService = usuarioService;
    }

    public WebSecurityConfig(boolean disableDefaults, BCryptPasswordEncoder bCryptPasswordEncoder, UsuarioService usuarioService) {
        super(disableDefaults);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Map<String, List<String>> rolesToUrls = new HashMap<>();

        rolesToUrls.put(USER,
                Arrays.asList(
                        "/turnos/**",
                        "/index.html",
                        "/registro-turno.html",
                        "/lista-turnos.html"
                ) );

        rolesToUrls.put(ADMIN,
                Arrays.asList(
                        "/odontologos/**",
                        "/pacientes/**",
                        "/registro-odontologo.html",
                        "/registro-paciente.html",
                        "/registro-usuario.html",
                        "/lista-odontologos.html",
                        "/lista-pacientes.html",
                        "/lista-usuarios.html"
                ));

        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(rolesToUrls.get(USER).toArray(new String[0])).hasAuthority(USER)
                    .antMatchers(rolesToUrls.get(ADMIN).toArray(new String[0])).hasAuthority(ADMIN)
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }
}
