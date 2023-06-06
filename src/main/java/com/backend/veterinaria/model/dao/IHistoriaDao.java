package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Historia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHistoriaDao extends CrudRepository<Historia, Integer> {

    @Query("SELECT h FROM Historia h WHERE h.historiaEstado='Habilitado'")
    public List<Historia> obtenerHistoriasHabilitadas();
}
