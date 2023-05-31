package com.example.laboratorio7.repository;

import com.example.laboratorio7.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
