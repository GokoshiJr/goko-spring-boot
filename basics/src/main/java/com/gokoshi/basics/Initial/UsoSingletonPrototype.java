package com.gokoshi.basics.Initial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoSingletonPrototype {
    public static void main(String[] args) {

        /* Carga de XML de configuracion */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        /* Peticion de beans al contenedor Spring */

        SecretarioEmpleado Ale = context.getBean("secretarioEmpleado", SecretarioEmpleado.class);
        SecretarioEmpleado Julio = context.getBean("secretarioEmpleado", SecretarioEmpleado.class);

        System.out.println(Julio);
        System.out.println(Ale);

        if (Julio == Ale) System.out.println("Apuntan al mismo objeto");
        else System.out.println("Son objetos distintos");

        context.close();
    }
}
