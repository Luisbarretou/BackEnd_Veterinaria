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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Historia implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historia_id")
    private Integer historiaId;

    @Column(name = "historia_fechacreacion")
    private String historiaFechaCreacion;

    @Column(name = "historia_estado", length = 50)
    private String historiaEstado = "Habilitado";

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    @Audited
    private Mascota mascota;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "historia_id")
    @NotAudited
    private List<DetalleHistoria> detallesHistoria = new ArrayList<>();

}
