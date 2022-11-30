package com.dh.apuestas.repository;

import com.dh.apuestas.model.Estado;
import com.dh.apuestas.model.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartidoRepository extends MongoRepository<Partido,Integer> {

    List<Partido> findAllByEstado(Estado estado);
}
