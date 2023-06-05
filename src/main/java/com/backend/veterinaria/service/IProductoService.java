package com.backend.veterinaria.service;

import com.backend.veterinaria.model.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> listarProductos();

    public List<Producto> listarProductosHabilitados();

    public Producto obtenerProductoPorId(Integer id);

    public Producto guardarProducto(Producto producto);

    void eliminarProducto(Integer id);
}
