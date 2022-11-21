package com.dh.clinica.service;

import com.dh.clinica.repository.GenericRepository;
import com.dh.clinica.model.Odontologo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {

    private GenericRepository<Odontologo> odontologoDao;



    public OdontologoService(GenericRepository<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);

    }

    public void eliminar(Integer id) {
        odontologoDao.eliminar(id);
    }

    public Optional<Odontologo> buscar(Integer id) {
        return odontologoDao.buscar(id);
    }

    public List<Odontologo> buscarTodos() {
        return odontologoDao.buscarTodos();
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoDao.actualizar(odontologo);
    }


}
