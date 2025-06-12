package com.microservicio.reporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan (basePackages = "com.microservicio.reporte.model.entity")
public class ReporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReporteApplication.class, args);
	}

}
