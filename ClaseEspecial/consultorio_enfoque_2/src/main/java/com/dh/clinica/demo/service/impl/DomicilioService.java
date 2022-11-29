package com.dh.clinica.demo.service.impl;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.persistence.entities.Domicilio;
import com.dh.clinica.demo.persistence.repository.IDomicilioRepository;
import com.dh.clinica.demo.config.SpringConfig;
import com.dh.clinica.demo.model.DomicilioDto;
import com.dh.clinica.demo.service.CRUDService;
import com.dh.clinica.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements CRUDService<DomicilioDto> {

    private final IDomicilioRepository domicilioRepository;
    private final SpringConfig springConfig;

    @Autowired
    public DomicilioService(IDomicilioRepository domicilioRepository, SpringConfig springConfig) {
        this.domicilioRepository = domicilioRepository;
        this.springConfig = springConfig;
    }

    public List<DomicilioDto> buscar(String calle) {
        List<Domicilio> domicilios = domicilioRepository.buscar(calle).orElse(new ArrayList<>());
        return Mapper.mapList(springConfig.getModelMapper(), domicilios, DomicilioDto.class);
    }

    public List<DomicilioDto> buscar(String calle, Integer numero) {
        List<Domicilio> domicilios = domicilioRepository.buscar(calle, numero).orElse(new ArrayList<>());
        return Mapper.mapList(springConfig.getModelMapper(), domicilios, DomicilioDto.class);
    }

    public DomicilioDto buscar(String calle, Integer numero, String localidad, String provincia) throws EntityNotFoundException {
        Domicilio domicilio = domicilioRepository.buscar(calle, numero, localidad, provincia).orElse(null);
        if (domicilio == null)
            throw new EntityNotFoundException("No se encontró el domicilio");

        return springConfig.getModelMapper().map(domicilio, DomicilioDto.class);
    }

    @Override
    public DomicilioDto buscarPorId(Integer id) throws EntityNotFoundException, IntegrityDataException {
        if (id == null || id < 1)
            throw new IntegrityDataException("El id del domicilio no puede ser null ni negativo");
        Domicilio domicilio = domicilioRepository.findById(id).orElse(null);
        if (domicilio == null)
            throw new EntityNotFoundException("No se encontró el domicilio con id " + id);

        return springConfig.getModelMapper().map(domicilio, DomicilioDto.class);
    }

    @Override
    public DomicilioDto crear(DomicilioDto domicilioDto) throws IntegrityDataException {
        if (domicilioDto == null)
            throw new IntegrityDataException("El domicilio no puede ser null");

        Domicilio domicilio = springConfig.getModelMapper().map(domicilioDto, Domicilio.class);
        domicilioDto = springConfig.getModelMapper().map(domicilioRepository.save(domicilio), DomicilioDto.class);
        return domicilioDto;
    }

    @Override
    public DomicilioDto actualizar(DomicilioDto domicilioDto) throws IntegrityDataException {
        DomicilioDto domicilioActualizado = null;
        if (domicilioDto == null)
            throw new IntegrityDataException("No se pudo actualizar el domicilio null");
        if (domicilioDto.getId() == null)
            throw new IntegrityDataException("El id del domicilio a actualizar no puede ser null");

        Optional<Domicilio> domicilioEnBD = domicilioRepository.findById(domicilioDto.getId());
        if (domicilioEnBD.isPresent()) {
            Domicilio actualizado = this.actualizar(domicilioEnBD.get(), domicilioDto);
            Domicilio guardado = domicilioRepository.save(actualizado);
            domicilioActualizado = springConfig.getModelMapper().map(guardado, DomicilioDto.class);
        }
        return domicilioActualizado;
    }

    @Override
    public void eliminar(Integer id) throws IntegrityDataException, EntityNotFoundException {
        if (id == null || id < 1)
            throw new IntegrityDataException("El id del domicilio no puede ser null ni negativo");
        if (!domicilioRepository.existsById(id))
            throw new EntityNotFoundException("No existe ningún domicilio con id: " + id);
        domicilioRepository.deleteById(id);
    }

    @Override
    public List<DomicilioDto> consultarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        return Mapper.mapList(springConfig.getModelMapper(), domicilios, DomicilioDto.class);
    }

    private Domicilio actualizar(Domicilio domicilio, DomicilioDto domicilioDto) {
        if (domicilioDto.getCalle() != null) {
            domicilio.setCalle(domicilioDto.getCalle());
        }
        if (domicilioDto.getNumero() != null) {
            domicilio.setNumero(domicilioDto.getNumero());
        }
        if (domicilioDto.getLocalidad() != null) {
            domicilio.setLocalidad(domicilioDto.getLocalidad());
        }
        if (domicilioDto.getProvincia() != null) {
            domicilio.setProvincia(domicilioDto.getProvincia());
        }
        return domicilio;
    }
}
