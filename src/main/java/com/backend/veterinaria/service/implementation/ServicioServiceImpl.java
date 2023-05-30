package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IServicioDao;
import com.backend.veterinaria.model.entity.Servicio;
import com.backend.veterinaria.service.IServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    IServicioDao servicioDao;

    @Transactional(readOnly = true)
    @Override
    public List<Servicio> listarServicios() {
        return (List<Servicio>) servicioDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Servicio> listarServiciosHabilitados(){
        return (List<Servicio>) servicioDao.obtenerServiciosHabilitados();
    }

    @Transactional(readOnly = true)
    @Override
    public Servicio obtenerServicioPorId(Integer id) {
        return servicioDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioDao.save(servicio);
    }

    @Transactional
    @Override
    public void eliminarServicio(Integer id) {
        servicioDao.deleteById(id);
    }
}
