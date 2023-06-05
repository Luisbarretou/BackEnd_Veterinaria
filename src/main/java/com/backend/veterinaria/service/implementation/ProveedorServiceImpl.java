package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IProveedorDao;
import com.backend.veterinaria.model.entity.Proveedor;
import com.backend.veterinaria.service.IProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDao proveedorDao;

    @Transactional(readOnly = true)
    @Override
    public List<Proveedor> listarProveedores() {
        return (List<Proveedor>) proveedorDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Proveedor> listarProveedoresHabilitados() {
        return (List<Proveedor>) proveedorDao.obtenerProveedoresHabilitados();
    }

    @Transactional(readOnly = true)
    @Override
    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorDao.save(proveedor);
    }

    @Transactional
    @Override
    public void eliminarProveedor(Integer id) {
        proveedorDao.deleteById(id);
    }

}
