package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.entity.Servicio;
import com.backend.veterinaria.service.IServicioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService {
    @Override
    public List<Servicio> listarServicios() {
        return null;
    }

    @Override
    public Servicio obtenerServicioPorId(Integer id) {
        return null;
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return null;
    }

    @Override
    public void eliminarServicio(Integer id) {

    }
}
