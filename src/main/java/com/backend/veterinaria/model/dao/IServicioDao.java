package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Servicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IServicioDao extends CrudRepository<Servicio, Integer> {

    @Query("SELECT s FROM Servicio s WHERE s.servicioEstado = 'Habilitado'")
    public List<Servicio> obtenerServiciosHabilitados();
}
