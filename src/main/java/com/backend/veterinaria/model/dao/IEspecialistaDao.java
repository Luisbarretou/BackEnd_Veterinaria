package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Especialista;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEspecialistaDao extends CrudRepository<Especialista, Integer> {

    @Query("SELECT e FROM Especialista e WHERE e.especialistaEstado = 'Habilitado'")
    public List<Especialista> obtenerEspecialistaSHabilitados();
}
