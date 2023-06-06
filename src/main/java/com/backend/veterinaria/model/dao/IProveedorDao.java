package com.backend.veterinaria.model.dao;

import com.backend.veterinaria.model.entity.Proveedor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> {

    @Query("SELECT p FROM Proveedor p WHERE p.proveedorEstado = 'Habilitado'")
    public List<Proveedor> obtenerProveedoresHabilitados();
}
