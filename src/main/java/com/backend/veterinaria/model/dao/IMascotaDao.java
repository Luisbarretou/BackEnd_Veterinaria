package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IMascotaDao extends CrudRepository<Mascota, Integer> {
}
