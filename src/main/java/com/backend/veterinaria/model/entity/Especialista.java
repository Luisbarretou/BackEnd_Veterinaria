package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "especialista")
public class Especialista implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="especialista_id")
    private Integer especialistaId;

    @Column(name ="especialista_dni", unique = true, length = 8)
    private String especialistaDNI;

    @Column(name ="especialista_nombres", length = 50)
    private String especialistaNombres;

    @Column(name ="especialista_telefono", length = 11)
    private String especialistaTelefono;

    @Column(name ="especialista_area", length = 50)
    private String especialistaArea;

    @OneToMany
    @JoinColumn(name = "especialista_id")
    private List<DetalleHistoria> detallesHistoria = new ArrayList<>();

    public Especialista() {
    }

    public Integer getEspecialistaId() {
        return especialistaId;
    }

    public void setEspecialistaId(Integer especialistaId) {
        this.especialistaId = especialistaId;
    }

    public String getEspecialistaDNI() {
        return especialistaDNI;
    }

    public void setEspecialistaDNI(String especialistaDNI) {
        this.especialistaDNI = especialistaDNI;
    }

    public String getEspecialistaNombres() {
        return especialistaNombres;
    }

    public void setEspecialistaNombres(String especialistaNombres) {
        this.especialistaNombres = especialistaNombres;
    }

    public String getEspecialistaTelefono() {
        return especialistaTelefono;
    }

    public void setEspecialistaTelefono(String especialistaTelefono) {
        this.especialistaTelefono = especialistaTelefono;
    }

    public String getEspecialistaArea() {
        return especialistaArea;
    }

    public void setEspecialistaArea(String especialistaArea) {
        this.especialistaArea = especialistaArea;
    }

    public List<DetalleHistoria> getDetallesHistoria() {
        return detallesHistoria;
    }

    public void setDetallesHistoria(List<DetalleHistoria> detallesHistoria) {
        this.detallesHistoria = detallesHistoria;
    }
}
