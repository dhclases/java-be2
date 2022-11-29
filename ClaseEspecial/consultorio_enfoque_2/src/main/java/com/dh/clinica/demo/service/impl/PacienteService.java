package com.dh.clinica.demo.service.impl;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.persistence.entities.Domicilio;
import com.dh.clinica.demo.persistence.entities.Paciente;
import com.dh.clinica.demo.persistence.repository.IPacienteRepository;
import com.dh.clinica.demo.config.SpringConfig;
import com.dh.clinica.demo.model.DomicilioDto;
import com.dh.clinica.demo.model.PacienteDto;
import com.dh.clinica.demo.service.CRUDService;
import com.dh.clinica.demo.utils.Mapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements CRUDService<PacienteDto> {

    private final Logger logger = Logger.getLogger(PacienteService.class);
    private final IPacienteRepository pacienteRepository;
    private final DomicilioService domicilioService;
    private final SpringConfig springConfig;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository, DomicilioService domicilioService, SpringConfig springConfig) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioService = domicilioService;
        this.springConfig = springConfig;
    }


    public PacienteDto buscar(Integer dni) throws IntegrityDataException, EntityNotFoundException {
        if (dni == null)
            throw new IntegrityDataException("El DNI del paciente no puede ser null");
        Paciente paciente = pacienteRepository.buscar(dni).orElse(null);
        if (paciente == null)
            throw new EntityNotFoundException("No se encontró el paciente con DNI " + dni);
        return springConfig.getModelMapper().map(paciente, PacienteDto.class);
    }


    public List<PacienteDto> buscar(String nombre) {
        List<Paciente> pacientes = pacienteRepository.buscar(nombre).orElse(new ArrayList<>());
        return Mapper.mapList(springConfig.getModelMapper(), pacientes, PacienteDto.class);
    }

    public List<PacienteDto> buscar(String nombre, String apellido) {
        List<Paciente> pacientes = pacienteRepository.buscar(nombre, apellido).orElse(new ArrayList<>());
        return Mapper.mapList(springConfig.getModelMapper(), pacientes, PacienteDto.class);
    }

    @Override
    public PacienteDto buscarPorId(Integer id) throws IntegrityDataException, EntityNotFoundException {
        if (id == null || id < 1)
            throw new IntegrityDataException("El id del paciente no puede ser null ni negativo");
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente == null)
            throw new EntityNotFoundException("No se encontró el paciente con id " + id);
        return springConfig.getModelMapper().map(paciente, PacienteDto.class);
    }

    @Override
    public PacienteDto crear(PacienteDto pacienteDto) throws IntegrityDataException {
        if (pacienteDto == null)
            throw new IntegrityDataException("No se puede crear un paciente null");
        logger.info("Estableciendo fecha de ingreso a paciente: "+pacienteDto);
        pacienteDto.setFechaIngreso(LocalDate.now());
        Paciente paciente = springConfig.getModelMapper().map(pacienteDto, Paciente.class);
        return springConfig.getModelMapper().map(pacienteRepository.save(paciente), PacienteDto.class);
    }

    @Override
    public PacienteDto actualizar(PacienteDto pacienteDto) throws IntegrityDataException, EntityNotFoundException {
        if (pacienteDto == null)
            throw new IntegrityDataException("No se pudo actualizar el paciente null");
        if (pacienteDto.getId() == null)
            throw new IntegrityDataException("El id del paciente a actualizar no puede ser null");
        Optional<Paciente> pacienteEnBD = pacienteRepository.findById(pacienteDto.getId());
        if (pacienteEnBD.isPresent()) {
            Paciente actualizado = this.actualizar(pacienteEnBD.get(), pacienteDto);
            pacienteDto = springConfig.getModelMapper().map(pacienteRepository.save(actualizado), PacienteDto.class);
        } else {
            throw new EntityNotFoundException("El paciente no existe");
        }
        return pacienteDto;
    }

    @Override
    public void eliminar(Integer id) throws IntegrityDataException, EntityNotFoundException {
        if (id == null || id < 1)
            throw new IntegrityDataException("El id del paciente no puede ser null ni negativo");
        if (!pacienteRepository.existsById(id))
            throw new EntityNotFoundException("No existe ningún paciente con id: " + id);
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteDto> consultarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return Mapper.mapList(springConfig.getModelMapper(), pacientes, PacienteDto.class);
    }

    private Paciente actualizar(Paciente paciente, PacienteDto pacienteDto) throws IntegrityDataException, EntityNotFoundException {
        if (pacienteDto.getNombre() != null) {
            paciente.setNombre(pacienteDto.getNombre());
        }
        if (pacienteDto.getApellido() != null) {
            paciente.setApellido(pacienteDto.getApellido());
        }
        if (pacienteDto.getDni() != null) {
            paciente.setDni(pacienteDto.getDni());
        }
        if (pacienteDto.getDomicilio() != null) {
            DomicilioDto actualizado = domicilioService.actualizar(pacienteDto.getDomicilio());
            paciente.setDomicilio(springConfig.getModelMapper().map(actualizado, Domicilio.class));
        }
        return paciente;
    }
}
