package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Proveedor;

import java.util.List;

public interface IProveedorService {

    public List<Proveedor> listarProveedores();

    public Proveedor obtenerProveedorPorId(Integer id);

    public Proveedor guardarProveedor(Proveedor proveedor);

    void eliminarProveedor(Integer id);
}
