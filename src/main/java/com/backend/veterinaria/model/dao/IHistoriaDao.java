package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Historia;
import org.springframework.data.repository.CrudRepository;

public interface IHistoriaDao extends CrudRepository<Historia, Integer> {
}
