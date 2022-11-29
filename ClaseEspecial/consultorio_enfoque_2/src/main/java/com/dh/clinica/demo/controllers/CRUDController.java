package com.dh.clinica.demo.controllers;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CRUDController<T> {
    ResponseEntity<?> registrar(@RequestBody T t) throws IntegrityDataException, EntityNotFoundException;

    ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws IntegrityDataException, EntityNotFoundException;

    ResponseEntity<?> actualizar(@RequestBody T t) throws IntegrityDataException, EntityNotFoundException;

    ResponseEntity<String> eliminar(@PathVariable String id) throws IntegrityDataException, EntityNotFoundException;

    ResponseEntity<?> buscarTodos();
}
