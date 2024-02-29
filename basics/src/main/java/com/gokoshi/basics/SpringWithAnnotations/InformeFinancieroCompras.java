package com.gokoshi.basics.SpringWithAnnotations;

public class InformeFinancieroCompras implements ICreacionInformeFinanciero{

    @Override
    public String getInformeFinanciero() {
        return "Informe financiero del departamento de compras año 2023.";
    }
}
