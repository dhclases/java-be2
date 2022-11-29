package com.dh.clinica.demo.service.impl;

import com.dh.clinica.demo.model.DomicilioDto;
import com.dh.clinica.demo.model.PacienteDto;
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
public class PacienteServiceTests {

    @Autowired
    private PacienteService pacienteService;
    private PacienteDto paciente;

    @BeforeEach
    public void setUp() {
        DomicilioDto domicilio = new DomicilioDto("Siempreviva", 742, "Springfield", "Springfield");
        paciente = new PacienteDto("Homero", "Simpson", 123456789, domicilio);
    }

    @Test
    public void test01AgregarPaciente() throws Exception {
        PacienteDto p = pacienteService.crear(paciente);
        assertNotNull(pacienteService.buscarPorId(p.getId()));
    }

    @Test
    public void test02ActualizarPaciente() throws Exception {
        PacienteDto p = pacienteService.crear(paciente);
        PacienteDto original = pacienteService.buscarPorId(p.getId());
        p.setNombre("Pepito");
        PacienteDto actualizado = pacienteService.actualizar(p);
        assertNotEquals(actualizado, original);
    }

    @Test
    public void test03EliminarPaciente() throws Exception {
        PacienteDto p = pacienteService.crear(paciente);
        assertNotNull(pacienteService.buscarPorId(p.getId()));
        pacienteService.eliminar(p.getId());
        assertThrows(EntityNotFoundException.class, () -> pacienteService.buscarPorId(p.getId()));
    }

    @Test
    public void test04ObtenerTodosLosPacientes() throws Exception {
        pacienteService.crear(paciente);
        assertNotEquals(0, pacienteService.consultarTodos().size());
    }
}
