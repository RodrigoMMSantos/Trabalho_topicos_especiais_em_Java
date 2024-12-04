package com.example.trabalhoTADS.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
    public Flyway flyway(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/cursos", "root",null)
                .load();
        flyway.repair();
        return flyway;
    }
}
