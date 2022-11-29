package com.dh.clinica.demo.service.impl;

import com.dh.clinica.demo.model.OdontologoDto;
import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class OdontologoServiceTests {

    @Autowired
    private OdontologoService odontologoService;
    private OdontologoDto odontologo;

    @BeforeEach
    public void setUp() {
        odontologo = new OdontologoDto();
        odontologo.setNombre("Pepo");
        odontologo.setApellido("Simpson");
        odontologo.setMatricula(123456);
    }

    @Test
    public void test01AgregarOdontologo() throws Exception {
        OdontologoDto o = odontologoService.crear(odontologo);
        assertNotNull(odontologoService.buscarPorId(o.getId()));
    }

    @Test
    public void test02ActualizarOdontologo() throws Exception {
        OdontologoDto o = odontologoService.crear(odontologo);
        OdontologoDto original = odontologoService.buscarPorId(o.getId());
        o.setNombre("Pepote");
        OdontologoDto actualizado = odontologoService.actualizar(o);
        assertNotEquals(actualizado, original);
    }

    @Test
    public void test03EliminarOdontologo() throws Exception {
        OdontologoDto o = odontologoService.crear(odontologo);
        assertNotNull(odontologoService.buscarPorId(o.getId()));
        odontologoService.eliminar(o.getId());
        assertThrows(EntityNotFoundException.class, () -> odontologoService.buscarPorId(o.getId()));
    }

    @Test
    public void test04ObtenerTodosLosOdontologos() throws Exception {
        odontologoService.crear(odontologo);
        assertNotEquals(0, odontologoService.consultarTodos().size());
    }
}
