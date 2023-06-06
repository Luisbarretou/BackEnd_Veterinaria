package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Mascota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMascotaDao extends CrudRepository<Mascota, Integer> {

    @Query("SELECT m FROM Mascota m WHERE m.mascotaEstado='Habilitado'")
    public List<Mascota> obtenerMascotasHabilitadas();
}
