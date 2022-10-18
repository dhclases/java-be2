package com.dh.liquidacionsueldo.test;


import com.dh.liquidacionsueldo.main.model.Persona;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {
    Persona persona;
    Persona persona1;
    Persona persona2;

    @BeforeEach
    void doBefore() {
        System.out.println("Antes de iniciar la prueba");

        persona = new Persona("Javier", "Test");
        persona.setEdad(LocalDate.of(1980, 4,12));

        persona1 = new Persona("Vale", "Nov");
        persona1.setEdad(LocalDate.of(2003, 9,20));

        persona2 = new Persona("Tito", "Perez");
        persona2.setEdad(LocalDate.of(2019, 12,4));

        // System.out.println("Ante de la prueba");
    }

    @Test
    void DummyCase(){
        System.out.println("DummyCase");
        assertEquals("Javier, Test", persona.calcularNombreCompleto());
        assertEquals("Vale, Nov", persona1.calcularNombreCompleto());
        assertEquals("Tito, Perez", persona2.calcularNombreCompleto());
       // System.out.println(persona.toString());

    }

    @Test
    void DummyCase2(){
        System.out.println("DummyCase 2");
        //assertEquals("Javier, Test", persona.calcularNombreCompleto());
        //assertEquals("Vale, Nov", persona1.calcularNombreCompleto());
        //assertEquals("Tito, Perez", persona2.calcularNombreCompleto());
        System.out.println("End test case 2");

    }

}
