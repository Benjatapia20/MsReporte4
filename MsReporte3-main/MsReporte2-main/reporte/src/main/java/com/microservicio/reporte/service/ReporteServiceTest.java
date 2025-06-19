package com.microservicio.reporte.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservicio.reporte.model.Reporte;
import com.microservicio.reporte.model.entity.ReporteEntity;
import com.microservicio.reporte.repository.ReporteRepository;

@SpringBootTest
public class ReporteServiceTest{

  @Mock
  private ReporteRepository reporteRepository;

  @InjectMocks
  private ReporteService reporteService;
  
    @Test
    public void testCrearReporte_Success() {
        Reporte reporte = new Reporte(0, "Reporte1", true, LocalDate.now(), "TipoA", "Usuario1");

        when(reporteRepository.existsByDescripcion("Reporte1")).thenReturn(false);
        when(reporteRepository.save(any(ReporteEntity.class))).thenReturn(new ReporteEntity());

        String resultado = reporteService.crearReporte(reporte);

        assertEquals("Reporte Creado Correctamente", resultado);
        verify(reporteRepository, times(1)).save(any(ReporteEntity.class));
    }


    @Test
    public void testCrearReporte_ReporteExiste(){
        Reporte reporte = new Reporte(0, "Reporte1", true, LocalDate.now(), "TipoA", "Usuario1");

        when(reporteRepository.existsByDescripcion("Reporte1")).thenReturn(true);

        String resultado = reporteService.crearReporte(reporte);

        assertEquals("El Reporte Ya Existe", resultado);
        verify(reporteRepository, never()).save(any(ReporteEntity.class));
    }

}
