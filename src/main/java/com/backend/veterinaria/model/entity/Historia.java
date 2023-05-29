package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historia")
public class Historia implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historia_id")
    private Integer historiaId;

    @Column(name = "historia_fechaCrea")
    private String historiaFechaCreacion;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "historia_id")
    private List<DetalleHistoria> detallesHistoria = new ArrayList<>();

    public Historia() {
    }

    public Integer getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(Integer historiaId) {
        this.historiaId = historiaId;
    }

    public String getHistoriaFechaCreacion() {
        return historiaFechaCreacion;
    }

    public void setHistoriaFechaCreacion(String historiaFechaCreacion) {
        this.historiaFechaCreacion = historiaFechaCreacion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<DetalleHistoria> getDetallesHistoria() {
        return detallesHistoria;
    }

    public void setDetallesHistoria(List<DetalleHistoria> detallesHistoria) {
        this.detallesHistoria = detallesHistoria;
    }
}
