package com.dh.demo.service;

import com.dh.demo.domain.Producto;
import com.dh.demo.domain.ProductoDto;

import java.util.List;

public interface ProductoService {

    List<Producto> listar();
    Producto obtener(Long id);
    void guardar(ProductoDto producto);
    void eliminar(Long id);
}
