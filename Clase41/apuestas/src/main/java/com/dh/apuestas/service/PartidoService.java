package com.dh.apuestas.service;

import com.dh.apuestas.exceptions.InvalidIDException;
import com.dh.apuestas.model.Partido;
import com.dh.apuestas.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;

    @Autowired
    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido agregar(Partido partido) throws InvalidIDException {

        if(Objects.isNull(partido.getId()) || partido.getId()<= 0){
            throw new InvalidIDException("Invalid id");
        }

        return partidoRepository.save(partido);
    }

    public List<Partido> listar(){
        return partidoRepository.findAll();
    }
}
