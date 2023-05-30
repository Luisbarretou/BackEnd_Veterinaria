package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Servicio;

import java.util.List;

public interface IServicioService {

    public List<Servicio> listarServicios();

    public List<Servicio> listarServiciosHabilitados();

    public Servicio obtenerServicioPorId(Integer id);

    public Servicio guardarServicio(Servicio servicio);

    void eliminarServicio(Integer id);
}
