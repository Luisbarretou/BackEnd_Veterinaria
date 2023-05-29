package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private Integer servicioId;

    @Column(name = "servicio_categoria", length = 50)
    private String servicioCategoria;

    @Column(name = "servicio_tipo", length = 50)
    private String servicioTipo;

    @OneToMany
    @JoinColumn(name = "servicio_id")
    private List<DetalleHistoria> detallesHistoria = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "detalle_serv_prod",
            joinColumns = @JoinColumn(name = "servicio_id", referencedColumnName = "servicio_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "producto_id"))
    private List<Producto> productos = new ArrayList<>();

    public Servicio() {
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public String getServicioCategoria() {
        return servicioCategoria;
    }

    public void setServicioCategoria(String servicioCategoria) {
        this.servicioCategoria = servicioCategoria;
    }

    public String getServicioTipo() {
        return servicioTipo;
    }

    public void setServicioTipo(String servicioTipo) {
        this.servicioTipo = servicioTipo;
    }

    public List<DetalleHistoria> getDetallesHistoria() {
        return detallesHistoria;
    }

    public void setDetallesHistoria(List<DetalleHistoria> detallesHistoria) {
        this.detallesHistoria = detallesHistoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
