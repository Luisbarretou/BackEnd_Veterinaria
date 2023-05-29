package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    public static final long serialVersionUID = 7L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Integer proveedorId;

    @Column(name = "proveedor_ruc", length = 11, unique = true)
    private String proveedorRUC;

    @Column(name = "proveedor_razonsocial", length = 50, unique = true)
    private String proveedorRazonSocial;

    @Column(name = "proveedor_telefono", length = 11)
    private String proveedorTelefono;

    @Column(name = "proveedor_direccion", length = 50)
    private String proveedorDireccion;

    public Proveedor() {
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getProveedorRUC() {
        return proveedorRUC;
    }

    public void setProveedorRUC(String proveedorRUC) {
        this.proveedorRUC = proveedorRUC;
    }

    public String getProveedorRazonSocial() {
        return proveedorRazonSocial;
    }

    public void setProveedorRazonSocial(String proveedorRazonSocial) {
        this.proveedorRazonSocial = proveedorRazonSocial;
    }

    public String getProveedorTelefono() {
        return proveedorTelefono;
    }

    public void setProveedorTelefono(String proveedorTelefono) {
        this.proveedorTelefono = proveedorTelefono;
    }

    public String getProveedorDireccion() {
        return proveedorDireccion;
    }

    public void setProveedorDireccion(String proveedorDireccion) {
        this.proveedorDireccion = proveedorDireccion;
    }
}
