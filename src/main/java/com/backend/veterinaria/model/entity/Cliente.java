package com.backend.veterinaria.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Cliente implements Serializable {

    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer clienteId;
    
    @Column(length = 20, name = "cliente_nrodocumento", unique = true)
    private String clienteNroDocumento;

    @Column(name = "cliente_nombre", length = 50)
    private String clienteNombre;

    @Column(name = "cliente_direccion", length = 50)
    private String clienteDireccion;

    @Column(name = "cliente_telefono", length = 50)
    private String clienteTelefono;

    @Column(name = "cliente_correo", length = 50)
    private String clienteCorreo;

    @Column(name = "cliente_genero", length = 50)
    private String clienteGenero;

    @Column(name = "cliente_estado", length = 50)
    private String clienteEstado = "Habilitado";

    @Column(length = 50,name = "cliente_fchacreacion")
    private String clienteFchaCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @OneToMany
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    @NotAudited
    private List<Mascota> mascotas = new ArrayList<>();

}
