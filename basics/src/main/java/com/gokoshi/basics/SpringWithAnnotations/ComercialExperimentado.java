package com.gokoshi.basics.SpringWithAnnotations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component("comercialExperimentado")
@Component
@Scope("singleton") // cambiar el patro de diseño singleton/prototype
public class ComercialExperimentado implements IEmpleados {

    /* Con un campo de clase */
    @Autowired
    @Qualifier("informeFinancieroTrim2") // bean id que debe usar
    private ICreacionInformeFinanciero informeFinanciero;

    /*
    Con un setter/metodo cualquiera

    @Autowired
    public void setInformeFinanciero(ICreacionInformeFinanciero informeFinanciero) {
        this.informeFinanciero = informeFinanciero;
    }
    */

    /*
    Con un constructor

    @Autowired
    public ComercialExperimentado(ICreacionInformeFinanciero informeFinanciero) {
        this.informeFinanciero = informeFinanciero;
    }
    */

    // metodo init - ejecucion de codigo despues de creacion del Bean
    @PostConstruct
    public void init() {
        System.out.println("Ejecutado tras creacion de Bean");
    }

    @PreDestroy
    // metodo destroy - ejecucion de codigo despues de que el contenedor este apagado
    public void destroy() {
        System.out.println("Ejecutado antes de la destruccion");
    }
    @Override
    public String getTareas() {
        return "Vender, vender y vender más.";
    }

    @Override
    public String getInformes() {
        return this.informeFinanciero.getInformeFinanciero();
    }
}
