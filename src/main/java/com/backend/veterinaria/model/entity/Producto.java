package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
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

    @Column(name = "producto_precio", columnDefinition = "decimal(8,2)")
    private Float productoPrecio;

    @Column(name = "producto_fchacreacion", length = 50)
    private String productoFchaCreacion = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @Column(name = "producto_estado", length = 50)
    private String productoEstado = "Habilitado";

    @ManyToMany
    @JoinTable(name = "detalle_prod_provee", joinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "producto_id"), inverseJoinColumns = @JoinColumn(name = "proveedor_id", referencedColumnName = "proveedor_id"))
    private List<Proveedor> proveedores = new ArrayList<>();

}
