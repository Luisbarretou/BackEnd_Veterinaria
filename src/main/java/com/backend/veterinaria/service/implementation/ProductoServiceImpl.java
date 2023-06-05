package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IProductoDao;
import com.backend.veterinaria.model.entity.Producto;
import com.backend.veterinaria.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> listarProductosHabilitados() {
        return (List<Producto>) productoDao.obtenerProductosHabilitados();
    }

    @Transactional(readOnly = true)
    @Override
    public Producto obtenerProductoPorId(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Producto guardarProducto(Producto producto) {
        return productoDao.save(producto);
    }

    @Transactional
    @Override
    public void eliminarProducto(Integer id) {
        productoDao.deleteById(id);
    }

}
