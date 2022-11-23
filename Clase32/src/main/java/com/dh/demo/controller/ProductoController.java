package com.dh.demo.controller;

import com.dh.demo.domain.Producto;
import com.dh.demo.domain.ProductoDto;
import com.dh.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //Ejercicio 1
    @PostMapping
    public ResponseEntity<HttpStatus> guardar(@RequestBody ProductoDto producto) {
        productoService.guardar(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Ejercicio 2
    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping(path = "{id}")
    public Producto obtenerPorId(@PathVariable("id") Long id) {
        return productoService.obtener(id);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> elminarPorId(@PathVariable("id") Long id) {
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ProductoDto Test() {
       ProductoDto productoDto = new ProductoDto("n",2,"f");
       productoDto.setFechaCreacion(LocalDate.now());
       return productoDto;
    }

}
