package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.beans.factory.annotation.Value;

public class DirectorFinanciero implements IEmpleados {

    private ICreacionInformeFinanciero informeFinanciero;
    @Value("${email}")
    private String email;
    @Value("${nombreEmpresa}")
    private String nombreEmpresa;

    public DirectorFinanciero(ICreacionInformeFinanciero informeFinanciero) {
        this.informeFinanciero = informeFinanciero;
    }

    @Override
    public String getTareas() {
        return "Gestion y dirección de las operaciones financieras.";
    }

    @Override
    public String getInformes() {
        return this.informeFinanciero.getInformeFinanciero();
    }

    public String getEmail() {
        return this.email;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
}
