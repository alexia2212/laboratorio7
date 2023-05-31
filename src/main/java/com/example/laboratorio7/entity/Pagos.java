package com.example.laboratorio7.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Pagos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "monto")
    private Double monto;
    @Basic
    @Column(name = "usuarios_id")
    private int usuariosId;
    @Basic
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "creditos_id")
    private int creditosId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getCreditosId() {
        return creditosId;
    }

    public void setCreditosId(int creditosId) {
        this.creditosId = creditosId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagos pagos = (Pagos) o;
        return id == pagos.id && usuariosId == pagos.usuariosId && creditosId == pagos.creditosId && Objects.equals(monto, pagos.monto) && Objects.equals(tipoPago, pagos.tipoPago) && Objects.equals(fecha, pagos.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monto, usuariosId, tipoPago, fecha, creditosId);
    }
}
