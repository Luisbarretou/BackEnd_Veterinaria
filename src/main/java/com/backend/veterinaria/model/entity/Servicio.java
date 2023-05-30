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
@Table(name = "servicio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
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

    @Column(name = "servicio_precio", columnDefinition = "decimal(8,2)")
    private float servicioPrecio;

    @Column(name = "servicio_fechacreacion", length = 50)
    private String servicioFechaCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @Column(name = "servicio_estado", length = 50)
    private String servicioEstado = "Habilitado";

    @OneToMany
    @JoinColumn(name = "servicio_id")
    @JsonBackReference
    @NotAudited
    private List<DetalleHistoria> detallesHistoria = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "detalle_serv_prod",
            joinColumns = @JoinColumn(name = "servicio_id", referencedColumnName = "servicio_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "producto_id"))
    @NotAudited
    private List<Producto> productos = new ArrayList<>();

}
