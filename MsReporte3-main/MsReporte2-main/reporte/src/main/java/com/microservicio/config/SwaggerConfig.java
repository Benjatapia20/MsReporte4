package com.microservicio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI(){
    return new openAPI().info(new Info()
      .title(title:"Proyecto De Usuarios")
      .version(version:"1.0")
      .descripcion(description:"Este es el micro servicio de Reportes")
      );
}
}
