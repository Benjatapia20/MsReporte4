package com.microservicio.reporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import com.microservicio.reporte.model.Reporte;
import com.microservicio.reporte.model.dto.ReporteDto;
import com.microservicio.reporte.service.ReporteService;

@RestController
@RequestMapping ("/api/reportes")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @Operation(summary = "Este endpoint permite obtener reportes")
    @PostMapping("/crearReporte")
    public ResponseEntity<String> obtenerReporte(@RequestBody Reporte reporte){
        return ResponseEntity.ok(reporteService.crearReporte(reporte));
    }

    @GetMapping("/obtenerReporte/descripcion/{descripcion}")
    public ResponseEntity<Reporte> obtenerReporte(@PathVariable String descripcion){
        Reporte reporte = reporteService.obtenerReporte(descripcion);
        if(reporte != null){
            return ResponseEntity.ok(reporte);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/obtenerReporte/id/{id}")
    public ResponseEntity<ReporteDto> obtenerReporteDto(@PathVariable int id){
        if (reporteService.obtenerReporteDto(id)!= null){
            return ResponseEntity.ok(reporteService.obtenerReporteDto(id));
        }
        return ResponseEntity.notFound().build();
    }
}
