package com.dh.demo.services;

import com.dh.demo.model.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteService() {
        Paciente paciente = new Paciente();
        paciente.setApellido("Rodriguez");
        paciente.setNombre("Mariano");
        paciente.setDni("43434334");
        paciente.setEmail("asd");
        paciente.setFechaIngreso(LocalDate.of(2022,8,20));
        paciente.getDomicilio().setCalle("mi calle");
        paciente.getDomicilio().setNumero(21212);
        paciente.getDomicilio().setLocalidad("mi localidad");
        pacientes.add(paciente);
    }

    public List<Paciente> getAll(){
        return pacientes;
    }

    public Paciente getPacienteByEmail(String email){
        for (int i = 0; i < pacientes.size() ; i++) {
            if(pacientes.get(i).getEmail().equalsIgnoreCase(email)){
                return pacientes.get(i);
            }
        }
        return null;
    }

}
