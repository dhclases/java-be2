package com.dh.paqueteria.service;

import com.dh.paqueteria.exceptions.BadRequestException;
import com.dh.paqueteria.model.Estado;
import com.dh.paqueteria.model.Paquete;
import com.dh.paqueteria.repository.PaqueteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {

    private PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public Paquete agregar(Paquete paquete) throws BadRequestException{
       if(paqueteRepository.findPaqueteByCodigo(paquete.getCodigo()) != null)
            throw new BadRequestException("Ya existe un paquete con el codigo :"+paquete.getCodigo());
        if(paquete.getDestino() == null)
            throw new BadRequestException("El paquete debe contener un destino");


        return paqueteRepository.save(paquete);

    }

    public List<Paquete> listar(){
        return paqueteRepository.findAll();
    }
    public List<Paquete> paquetesEnCamino(){
        return paqueteRepository.findAllByEstado(Estado.EN_CAMINO);
    }



}
