package com.dh.apuestas.service;

import com.dh.apuestas.model.Partido;
import com.dh.apuestas.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;

    @Autowired
    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido agregar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public List<Partido> listar(){
        return partidoRepository.findAll();
    }
}
