package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Estadistica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private Double promedioPuntualidad;
    private Double promedioTrato;
    private Double promedioCumplimiento;
    private Double promedioServicio;
    
    private Integer totalEvaluaciones;

    // Getters and Setters  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Double getPromedioPuntualidad() {
        return promedioPuntualidad;
    }

    public void setPromedioPuntualidad(Double promedioPuntualidad) {
        this.promedioPuntualidad = promedioPuntualidad;
    }

    public Double getPromedioTrato() {
        return promedioTrato;
    }

    public void setPromedioTrato(Double promedioTrato) {
        this.promedioTrato = promedioTrato;
    }

    public Double getPromedioCumplimiento() {
        return promedioCumplimiento;
    }

    public void setPromedioCumplimiento(Double promedioCumplimiento) {
        this.promedioCumplimiento = promedioCumplimiento;
    }

    public Double getPromedioServicio() {
        return promedioServicio;
    }

    public void setPromedioServicio(Double promedioServicio) {
        this.promedioServicio = promedioServicio;
    }

    public Integer getTotalEvaluaciones() {
        return totalEvaluaciones;
    }

    public void setTotalEvaluaciones(Integer totalEvaluaciones) {
        this.totalEvaluaciones = totalEvaluaciones;
    }

}
