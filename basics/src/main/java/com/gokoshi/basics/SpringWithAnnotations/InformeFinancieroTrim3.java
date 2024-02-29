package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim3 implements ICreacionInformeFinanciero {
    @Override
    public String getInformeFinanciero() {
        return "Presentacion de informe favorable del trimestre 3";
    }
}
