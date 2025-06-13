package com.microservicio.reporte.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "Reporte")
@Data
public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporte;

    @Column(name = "Descripcion:")
    private String descripcion;
    private boolean estado;
    private LocalDate fechaCreacion;
    private String tipoReporte;
    private String creadoPor;

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
