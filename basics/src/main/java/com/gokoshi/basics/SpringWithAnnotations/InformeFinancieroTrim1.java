package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim1 implements ICreacionInformeFinanciero {
    @Override
    public String getInformeFinanciero() {
        return "Presentacion de informe financiero del trimestre 1";
    }
}
