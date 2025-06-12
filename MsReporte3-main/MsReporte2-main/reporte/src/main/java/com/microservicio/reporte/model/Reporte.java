package com.microservicio.reporte.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte {
    private int idReporte;
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
