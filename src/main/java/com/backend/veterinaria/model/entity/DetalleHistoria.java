package com.backend.veterinaria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "detalle_historia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class DetalleHistoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dethistoria_id")
    private Integer detHistoriaId;

    @Column(name = "dethistoria_fechacreacion", length = 50)
    private String detHistoriaFechaCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @Column(name = "dethistoria_fechaprogramada", length = 50)
    private String detHistoriaFechaProgramada;

    @Column(name = "dethistoria_fechaaplicada", length = 50)
    private String detHistoriaFechaAplicada;

    @Column(name = "dethistoria_farmaco", length = 50)
    private String detHistoriaFarmaco;

    @Column(name = "dethistoria_peso", columnDefinition = "decimal(4,2)")
    private float detHistoriaPeso;

    @Column(name = "dethistoria_observaciones", length = 250)
    private String detHistoriaObservaciones;

    @Column(name = "dethistoria_tratamiento", length = 250)
    private String detHistoriaTratamiento;

    @Column(name = "dethistoria_estado", length = 50)
    private String detHistoriaEstado = "Habilitado";

    @ManyToOne
    @JoinColumn(name = "historia_id")
    @JsonBackReference
    @Audited
    private Historia historia;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    @Audited
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "especialista_id")
    @Audited
    private Especialista especialista;

}
