package com.example.laboratorio7.repository;

import com.example.laboratorio7.entity.Acciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionesRepository extends JpaRepository<Acciones, Integer> {
}