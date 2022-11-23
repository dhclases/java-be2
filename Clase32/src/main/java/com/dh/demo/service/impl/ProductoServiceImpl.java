package com.dh.demo.service.impl;

import com.dh.demo.repository.ProductoRepository;
import com.dh.demo.service.ProductoService;
import com.dh.demo.domain.ProductoDto;
import com.dh.demo.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

c
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtener(Long id) {
        return productoRepository.getById(id);
    }

    @Override
    public void guardar(ProductoDto producto) {
        Producto newProduct = new Producto();
        newProduct.setCantidad(producto.getCantidad());
        newProduct.setDescripcion(producto.getDescripcion());
        newProduct.setNombre(producto.getNombre());
        newProduct.setFechaCreacion(convertDateToSqlDate(producto.getFechaCreacion()));
        newProduct.setFechaActualizacion(convertDateToSqlDate(producto.getFechaActualizacion()));
        productoRepository.save(newProduct);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public Date convertDateToSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}
