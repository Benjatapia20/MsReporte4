package com.microservicio.reporte.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDto {
    private int idReporte;
    private String descripcion;
    private boolean estado;
    private LocalDate fechaCreacion;
    private String tipoReporte;
    private String creadoPor;

}
