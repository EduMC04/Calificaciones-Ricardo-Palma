package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Estadistica;

public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {
    
}
