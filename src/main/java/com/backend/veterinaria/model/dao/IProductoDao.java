package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.productoEstado = 'Habilitado'")
    public List<Producto> obtenerProductosHabilitados();
}
