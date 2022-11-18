package com.dh.clinica.service;


import com.dh.clinica.repository.GenericRepository;
import com.dh.clinica.model.Domicilio;


import java.util.List;

public class DomicilioService {
    private GenericRepository<Domicilio> domicilioDao;

    public DomicilioService(GenericRepository<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio d){
        domicilioDao.guardar(d);
        return d;
    }
    public Domicilio buscar(Integer id){
        return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }
    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

}
