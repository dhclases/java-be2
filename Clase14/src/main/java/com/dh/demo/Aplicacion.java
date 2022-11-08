package com.dh.demo;


import com.dh.demo.model.Medicamento;
import com.dh.demo.repository.impl.MedicamentoRepositoryH2;
import com.dh.demo.service.MedicamentoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Aplicacion {



    public static void main(String[] args) throws Exception {



        // El cliente usa el a traves del servicio los metodos requeridos
        // Se injecta la implemntacion H2 Deseada
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoRepositoryH2());
        // Se define la entidad
        Medicamento medicamento = new Medicamento("Ibuprofeno", "lab123", 1000, 200.0);
        // Se invoca los servicios. En este caso guardamos el medicamento
        medicamentoService.guardar(medicamento);

        // Buscamos el medicamento recien creado
        Medicamento medicina2 = medicamentoService.buscar(1);
        // Detalle de la entidad medicamento
        System.out.println(medicina2);


/*
        // ********** Uso de Generico  *********************
        // Inicializar la clase como Entero
        GenericsClass<Integer> miNumero = new GenericsClass<>(5);
        System.out.println("Generic Class retorna: " + miNumero.getData());

        // Inicializar la clase como String
        GenericsClass<String> miCadena = new GenericsClass<>("Java Programming");
        System.out.println("Generic Class retorna: " + miCadena.getData());

        // Inicializar la clase como String
        GenericsClass<Medicamento> mimedicamento = new GenericsClass<>(  new Medicamento("Ibuprofeno", "lab123", 1000, 200.0));
        System.out.println("Generic Class retorna: " + mimedicamento.getData().getNombre());
*/
    }





}
