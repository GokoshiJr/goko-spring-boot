package com.gokoshi.basics.Initial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoCicloVidaBean {

    public static void main(String[] args) {

        /* Carga de XML de configuracion */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        // Obtencion del bean
        IEmpleados Ale = context.getBean("directorEmpleado", IEmpleados.class);

        System.out.println(Ale.getInforme());

        // Cerrar el contexto
        context.close();

    }

}
