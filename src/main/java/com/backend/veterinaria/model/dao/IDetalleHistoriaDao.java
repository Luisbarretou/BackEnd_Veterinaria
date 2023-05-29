package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.DetalleHistoria;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleHistoriaDao extends CrudRepository<DetalleHistoria, Integer> {
}
