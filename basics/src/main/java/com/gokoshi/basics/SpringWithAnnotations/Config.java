package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.gokoshi.basics.SpringWithAnnotations")
@PropertySource("application.properties")
public class Config {
    // definir el bean para InformeFinancieroCompras
    @Bean
    public ICreacionInformeFinanciero informeFinanciero() { // id del bean inyectado
        return new InformeFinancieroCompras();
    } // id del bean inyectado

    // definir el bean para DirectorFinanciero e inyectar dependencias
    @Bean
    public IEmpleados empleados() {
        return new DirectorFinanciero(informeFinanciero());
    }
}
