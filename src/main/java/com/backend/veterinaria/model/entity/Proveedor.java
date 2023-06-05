package com.backend.veterinaria.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class Proveedor implements Serializable {

    public static final long serialVersionUID = 7L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Integer proveedorId;

    @Column(name = "proveedor_ruc", length = 11, unique = true)
    private String proveedorRUC;

    @Column(name = "proveedor_razonsocial", length = 50, unique = true)
    private String proveedorRazonSocial;

    @Column(name = "proveedor_telefono", length = 11)
    private String proveedorTelefono;

    @Column(name = "proveedor_direccion", length = 50)
    private String proveedorDireccion;

    @Column(name = "proveedor_correo", length = 50)
    private String proveedorCorreo;

    @Column(name = "proveedor_fchacreacion", length = 50)
    private String proveedorFchaCreacion = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @Column(name = "proveedor_estado", length = 50)
    private String proveedorEstado = "Habilitado";

}
