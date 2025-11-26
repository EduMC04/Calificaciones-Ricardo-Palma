package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estadistica;
import com.example.demo.repository.EstadisticaRepository;

@Service
public class EstadisticaService {
    
    @Autowired
    private EstadisticaRepository estadisticaRepository;

    public void guardarEstadistica(Estadistica estadistica) {
        estadisticaRepository.save(estadistica);
    }

    public Estadistica obtenerEstadisticaPorId(Long id) {
        return estadisticaRepository.findById(id).orElse(null);
    }

    public void eliminarEstadistica(Long id) {
        estadisticaRepository.deleteById(id);
    }

}
