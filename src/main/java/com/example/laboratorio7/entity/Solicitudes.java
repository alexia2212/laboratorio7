package com.example.laboratorio7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Solicitudes implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "solicitud_producto")
    private String solicitud_producto;
    @Basic
    @Column(name = "solicitud_monto")
    private Double solicitud_monto;
    @Basic
    @Column(name = "solicitud_fecha")
    private Timestamp solicitud_fecha;
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuarios usuarios_id;
    @Basic
    @Column(name = "solicitud_estado")
    private String solicitud_estado;

}
