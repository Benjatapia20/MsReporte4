package com.microservicio.reporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.reporte.model.Reporte;
import com.microservicio.reporte.model.dto.ReporteDto;
import com.microservicio.reporte.model.entity.ReporteEntity;
import com.microservicio.reporte.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public String crearReporte(Reporte reporte1){
        try {
            Boolean estado = reporteRepository.existsByDescripcion(reporte1.getDescripcion());
            if(!estado){
                ReporteEntity reporteNuevo = new ReporteEntity();
                reporteNuevo.setIdReporte(reporte1.getIdReporte());
                reporteNuevo.setDescripcion(reporte1.getDescripcion());
                reporteNuevo.setEstado(reporte1.getEstado());
                reporteNuevo.setFechaCreacion(null);
                reporteNuevo.setTipoReporte(reporte1.getTipoReporte());
                reporteNuevo.setCreadoPor(reporte1.getCreadoPor());
                reporteRepository.save(reporteNuevo);
                return "Reporte Creado Correctamente";
            }
            else{
                return "El Reporte Ya Existe";
            }
        } catch (Exception e) {
            return "Error Al Crear Reporte";
        }
    }

    public Reporte obtenerReporte(String descripcion){
        try {
            ReporteEntity reporte = reporteRepository.findByDescripcion(descripcion);
            if(reporte != null){
                Reporte reporte2 = new Reporte(
                    reporte.getIdReporte(),
                    reporte.getDescripcion(),
                    reporte.getEstado(),
                    reporte.getFechaCreacion(),
                    reporte.getTipoReporte(),
                    reporte.getCreadoPor()
                );
                return reporte2;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ReporteDto obtenerReporteDto(int id){
        try {
            ReporteEntity reporte = reporteRepository.findByReporte(id);
            ReporteDto nuevoReporte = new ReporteDto(
                reporte.getIdReporte(),
                reporte.getDescripcion(),
                reporte.getEstado(),
                reporte.getFechaCreacion(),
                reporte.getTipoReporte(),
                reporte.getCreadoPor()
            );
            return nuevoReporte;
    }catch(Exception e){
        return null;
    }
}   
}