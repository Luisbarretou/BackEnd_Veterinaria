package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Servicio;
import org.springframework.data.repository.CrudRepository;

public interface IServicioDao extends CrudRepository<Servicio, Integer> {
}
