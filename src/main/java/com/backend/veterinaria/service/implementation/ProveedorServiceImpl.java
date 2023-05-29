package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.entity.Proveedor;
import com.backend.veterinaria.service.IProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {
    @Override
    public List<Proveedor> listarProveedores() {
        return null;
    }

    @Override
    public Proveedor obtenerProveedorPorId(Integer id) {
        return null;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return null;
    }

    @Override
    public void eliminarProveedor(Integer id) {

    }
}
