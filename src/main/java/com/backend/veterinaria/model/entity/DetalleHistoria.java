package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "detalle_historia")
public class DetalleHistoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dethistoria_id")
    private Integer detHistoriaId;

    @Column(name = "dethistoria_fecha")
    private String detHistoriaFecha;

    @Column(name = "dethistoria_fechaprogramada")
    private String detHistoriaFechaProgramada;

    @Column(name = "dethistoria_fechaaplicada")
    private String detHistoriaFechaAplicada;

    @Column(name = "dethistoria_farmaco", length = 50)
    private String detHistoriaFarmaco;

    @Column(name = "dethistoria_peso", columnDefinition = "decimal(4,2)")
    private float detHistoriaPeso;

    @Column(name = "dethistoria_observaciones", length = 250)
    private String detHistoriaObservaciones;

    @Column(name = "dethistoria_tratamiento", length = 250)
    private String detHistoriaTratamiento;

    @ManyToOne
    @JoinColumn(name = "historia_id")
    private Historia historia;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "especialista_id")
    private Especialista especialista;

    public DetalleHistoria() {
    }

    public Integer getDetHistoriaId() {
        return detHistoriaId;
    }

    public void setDetHistoriaId(Integer detHistoriaId) {
        this.detHistoriaId = detHistoriaId;
    }

    public String getDetHistoriaFecha() {
        return detHistoriaFecha;
    }

    public void setDetHistoriaFecha(String detHistoriaFecha) {
        this.detHistoriaFecha = detHistoriaFecha;
    }

    public String getDetHistoriaFechaProgramada() {
        return detHistoriaFechaProgramada;
    }

    public void setDetHistoriaFechaProgramada(String detHistoriaFechaProgramada) {
        this.detHistoriaFechaProgramada = detHistoriaFechaProgramada;
    }

    public String getDetHistoriaFechaAplicada() {
        return detHistoriaFechaAplicada;
    }

    public void setDetHistoriaFechaAplicada(String detHistoriaFechaAplicada) {
        this.detHistoriaFechaAplicada = detHistoriaFechaAplicada;
    }

    public String getDetHistoriaFarmaco() {
        return detHistoriaFarmaco;
    }

    public void setDetHistoriaFarmaco(String detHistoriaFarmaco) {
        this.detHistoriaFarmaco = detHistoriaFarmaco;
    }

    public float getDetHistoriaPeso() {
        return detHistoriaPeso;
    }

    public void setDetHistoriaPeso(float detHistoriaPeso) {
        this.detHistoriaPeso = detHistoriaPeso;
    }

    public String getDetHistoriaObservaciones() {
        return detHistoriaObservaciones;
    }

    public void setDetHistoriaObservaciones(String detHistoriaObservaciones) {
        this.detHistoriaObservaciones = detHistoriaObservaciones;
    }

    public String getDetHistoriaTratamiento() {
        return detHistoriaTratamiento;
    }

    public void setDetHistoriaTratamiento(String detHistoriaTratamiento) {
        this.detHistoriaTratamiento = detHistoriaTratamiento;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }
}
