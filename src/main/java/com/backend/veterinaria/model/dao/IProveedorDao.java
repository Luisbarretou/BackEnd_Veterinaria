package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> {
}
