package com.dh.clinica.demo.service;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CRUDService<T> {
    T buscarPorId(Integer id) throws IntegrityDataException, EntityNotFoundException;

    T crear(T t) throws IntegrityDataException, EntityNotFoundException;

    T actualizar(T t) throws IntegrityDataException, EntityNotFoundException;

    void eliminar(Integer id) throws IntegrityDataException, EntityNotFoundException;

    List<T> consultarTodos();
}
