package com.gokoshi.basics.SpringWithAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/* import org.springframework.context.support.ClassPathXmlApplicationContext; */

public class UsoAnnotations {

    public static void main(String[] args) {
        // leer el archivo xml de configuracion
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        // leer el class de configuracion
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // pedir un bean al contenedor
        // IEmpleados Ale = context.getBean("empleados", IEmpleados.class);
        // usar el bean
        // System.out.println(Ale.getInformes());

        DirectorFinanciero Ale = context.getBean("empleados", DirectorFinanciero.class);
        System.out.println(Ale.getEmail());
        System.out.println(Ale.getNombreEmpresa());
        
        // cerrar el contexto
        context.close();
    }
}
