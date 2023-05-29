package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Integer> {
}
