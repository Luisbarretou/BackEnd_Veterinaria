package com.backend.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.veterinaria.model.entity.Proveedor;
import com.backend.veterinaria.service.IProveedorService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/proveedores")
    public List<Proveedor> listaProveedores() {
        return proveedorService.listarProveedores();
    }

    @GetMapping("/proveedores/habilitados")
    public List<Proveedor> listaProveedoresHabilitados() {
        return proveedorService.listarProveedoresHabilitados();
    }

    @GetMapping("/proveedores/{id}")
    public Proveedor detalleProveedor(@PathVariable Integer id) {
        return proveedorService.obtenerProveedorPorId(id);
    }

    @PostMapping("/proveedores")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor registroProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    @PutMapping("/proveedores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor actualizaProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        Proveedor proveedorActual = proveedorService.obtenerProveedorPorId(id);
        proveedorActual.setProveedorRUC(proveedor.getProveedorRUC());
        proveedorActual.setProveedorRazonSocial(proveedor.getProveedorRazonSocial());
        proveedorActual.setProveedorTelefono(proveedor.getProveedorTelefono());
        proveedorActual.setProveedorDireccion(proveedor.getProveedorDireccion());
        proveedorActual.setProveedorCorreo(proveedor.getProveedorCorreo());
        proveedorActual.setProveedorEstado(proveedor.getProveedorEstado());
        return proveedorService.guardarProveedor(proveedorActual);
    }

    @PutMapping("/proveedores/{id}/inhabilitar")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor inhabilitarProveedor(@PathVariable Integer id) {
        Proveedor proveedorActual = proveedorService.obtenerProveedorPorId(id);
        proveedorActual.setProveedorEstado("Inhabilitado");
        return proveedorService.guardarProveedor(proveedorActual);
    }

    @DeleteMapping("/proveedores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaProveedor(@PathVariable Integer id) {
        proveedorService.eliminarProveedor(id);
    }

}
