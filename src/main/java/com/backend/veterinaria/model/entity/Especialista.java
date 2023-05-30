package com.backend.veterinaria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "especialista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
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

    @Column(name = "especialista_fechacreacion", length = 50)
    private String especialistaFechaCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @Column(name = "especialista_estado", length = 50)
    private String especialistaEstado = "Habilitado";

    @OneToMany
    @JoinColumn(name = "especialista_id")
    @JsonBackReference
    @NotAudited
    private List<DetalleHistoria> detallesHistoria = new ArrayList<>();

}
