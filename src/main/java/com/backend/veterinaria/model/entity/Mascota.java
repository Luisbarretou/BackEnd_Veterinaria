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
@Table(name = "mascota")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Audited
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mascota_id")
    private Integer mascotaId;

    @Column(name = "mascota_nombre", length = 50, nullable = false)
    private String mascotaNombre;

    @Column(name = "mascota_tipo", length = 50, nullable = false)
    private String mascotaTipo;

    @Column(name = "mascota_raza", length = 50)
    private String mascotaRaza;

    @Column(name = "mascota_fechaNac", length = 50)
    private String mascotaFechaNacimiento = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

    @Column(name = "mascota_color", length = 50)
    private String mascotaColor;

    @Column(name = "mascota_sexo", length = 50, nullable = false)
    private String mascotaSexo;

    @Column(name = "mascota_observaciones", length = 250)
    private String mascotaObservaciones;

    @Column(name = "mascota_estado", length = 50)
    private String mascotaEstado = "Habilitado";

    @Column(name = "mascota_fchacreacion", length = 50)
    private String mascotaFchaCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @Audited
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "mascota_id")
    @JsonBackReference
    @NotAudited
    private List<Historia> historias = new ArrayList<>();

}
