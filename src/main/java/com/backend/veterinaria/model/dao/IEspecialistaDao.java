package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Especialista;
import org.springframework.data.repository.CrudRepository;

public interface IEspecialistaDao extends CrudRepository<Especialista, Integer> {
}
