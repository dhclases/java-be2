
package com.dh.tecnico.runner;

import com.dh.tecnico.model.Jugador;
import com.dh.tecnico.model.Tecnico;
import com.dh.tecnico.repository.TecnicoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(CommandLineRunnerImpl.class);

    private final TecnicoRepository tecnicoRepository;

    public CommandLineRunnerImpl(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Jugador leoJugador;
        logger.info("*** Iniciando el proceso **** ");

        Tecnico tecnicoArg = Tecnico.builder()
                .nombre("Lionel Scaloni")
                .edad(44)
                .build();

        logger.info("*** Registrando  el Técnico **** ");

        leoJugador = Jugador.builder()
                .nombre("Leonel Messi")
                .tecnico(tecnicoArg)
                .build();


        logger.info("*** Registrando el Jugador  **** ");

        Set<Jugador> jugadores = new HashSet<>();
        jugadores.add(leoJugador);

        tecnicoRepository.save(tecnicoArg);

        logger.info("*** Buscando Técnico  **** ");

        Optional<Tecnico> optTecnico = tecnicoRepository.buscarTecnico("Lionel Scaloni",767);

        if(optTecnico.isPresent()) {
            logger.info("Técnico encontrado {}",optTecnico.get().getNombre());
        }else{
            logger.info("No encontrado");
        }


        logger.info("*** Fin del proceso **** ");
    }
}


