package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Evaluacion;
import com.example.demo.repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public void guardarEvaluacion(Evaluacion evaluacion) {
        evaluacionRepository.save(evaluacion);
    }

    public Evaluacion obtenerEvaluacionPorId(Long id) {
        return evaluacionRepository.findById(id).orElse(null);
    }

    public void eliminarEvaluacion(Long id) {
        evaluacionRepository.deleteById(id);
    }

    public List<Evaluacion> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll();
    }
}
