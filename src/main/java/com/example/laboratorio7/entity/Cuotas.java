package com.example.laboratorio7.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Cuotas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "numero_cuota")
    private Integer numeroCuota;
    @Basic
    @Column(name = "monto")
    private Double monto;
    @Basic
    @Column(name = "creditos_id")
    private int creditosId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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
        Cuotas cuotas = (Cuotas) o;
        return id == cuotas.id && creditosId == cuotas.creditosId && Objects.equals(numeroCuota, cuotas.numeroCuota) && Objects.equals(monto, cuotas.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroCuota, monto, creditosId);
    }
}
