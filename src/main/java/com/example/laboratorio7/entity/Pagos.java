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
public class Pagos implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "monto")
    private Double monto;
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuarios usuarios_id;
    @Basic
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @ManyToOne
    @JoinColumn(name = "creditos_id")
    private Creditos creditos_id;
}