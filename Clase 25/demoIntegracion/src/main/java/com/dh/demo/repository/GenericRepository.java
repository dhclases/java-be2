package com.dh.demo.repository;

import java.util.List;

public interface GenericRepository<T> {
    T guardar( T t);

    T buscar (Integer id);

    void eliminar(Integer id);

    List<T> buscarTodos();

    T actualizar( T t);

}
