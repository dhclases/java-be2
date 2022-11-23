package com.dh.profesor.runner;

import com.dh.profesor.model.Alumno;
import com.dh.profesor.model.Profesor;
import com.dh.profesor.service.ProfesorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Component
public class
CommandLineRunnerImpl implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(CommandLineRunnerImpl.class);

    private final ProfesorService profesorService;

    @Autowired
    public CommandLineRunnerImpl(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("*** Iniciando el proceso **** ");

        logger.info("*** Registrando  el alumno **** ");


        Alumno alumnoSuperman = Alumno.builder()
                .nombre("Superman")
                .edad(120)
                .build();

        Alumno alumnoBatman = Alumno.builder()
                .nombre("Batman")
                .edad(45)
                .build();

        logger.info("*** Definiendo los alumnos  **** ");
        Set<Alumno> conjuntoAlumnos = new HashSet<>();

        conjuntoAlumnos.add(alumnoSuperman);
        conjuntoAlumnos.add(alumnoBatman);

        logger.info("*** Registrando el Profesor  **** ");
        Profesor profesor = Profesor.builder()
                .nombre("Master Heroes")
                .titulo("Master of the master")
                .alumnos(conjuntoAlumnos).build();

        Optional<Profesor> optProfesor = profesorService.guardar(profesor);

        optProfesor.ifPresent(profe -> logger.info("El nuevo registro: {}", optProfesor.get()));

        logger.info("*** Fin del proceso **** ");
    }
}
