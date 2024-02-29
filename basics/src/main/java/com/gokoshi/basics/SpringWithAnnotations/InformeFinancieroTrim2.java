package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim2 implements ICreacionInformeFinanciero {
    @Override
    public String getInformeFinanciero() {
        return "Presentacion de informe catastrofico del trimestre 2";
    }
}
