package com.example.laboratorio7.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Historial {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "creditos_id")
    private int creditosId;
    @Basic
    @Column(name = "usuarios_id")
    private int usuariosId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditosId() {
        return creditosId;
    }

    public void setCreditosId(int creditosId) {
        this.creditosId = creditosId;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Historial historial = (Historial) o;
        return id == historial.id && creditosId == historial.creditosId && usuariosId == historial.usuariosId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creditosId, usuariosId);
    }
}
