package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.entity.Producto;
import com.backend.veterinaria.service.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Override
    public List<Producto> listarProductos() {
        return null;
    }

    @Override
    public Producto obtenerProductoPorId(Integer id) {
        return null;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return null;
    }

    @Override
    public void eliminarProducto(Integer id) {

    }
}
