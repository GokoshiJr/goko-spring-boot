package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim4 implements ICreacionInformeFinanciero {
    @Override
    public String getInformeFinanciero() {
        return "Presentacion de informe de cierre de año";
    }
}
