package com.dh.demo;

import com.dh.demo.model.Paciente;
import com.dh.demo.repository.impl.PacienteRepositoryH2;
import com.dh.demo.service.PacienteService;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteRepositoryH2());

    @Test
    public void guardarMedicamentoTest() {
        Paciente paciente = new Paciente("Alfredo", "lab123", 1000, 200.0);


    }

    @Test
    public void buscarPorIdTest() {
        Paciente paciente = pacienteService.buscar(1);

    }
}
