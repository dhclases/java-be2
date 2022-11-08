package com.dh.demo.repository;

public interface Repository<T>{

    T guardar(T t);
    T buscar(Integer id);
}
