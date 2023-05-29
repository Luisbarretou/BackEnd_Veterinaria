package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "producto_nombre", length = 50)
    private String productoNombre;

    @Column(name = "producto_marca", length = 50)
    private String productoMarca;

    @Column(name = "producto_categoria", length = 50)
    private String productoCategoria;

    @Column(name = "producto_descripcion", length = 250)
    private String productoDescripcion;

    @ManyToMany
    @JoinTable(name = "detalle_prod_provee",
            joinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id", referencedColumnName = "proveedor_id"))
    private List<Proveedor> proveedores = new ArrayList<>();

    public Producto() {
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getProductoMarca() {
        return productoMarca;
    }

    public void setProductoMarca(String productoMarca) {
        this.productoMarca = productoMarca;
    }

    public String getProductoCategoria() {
        return productoCategoria;
    }

    public void setProductoCategoria(String productoCategoria) {
        this.productoCategoria = productoCategoria;
    }

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
