package com.gokoshi.basics.Initial;

public class DirectorEmpleado implements IEmpleados {

    // creacion de campo, tipo ICreacionInforme (interfaz)
    private ICreacionInformes informeNuevo;
    private String email;
    private String nombreEmpresa;

    // metodo init - ejecutar tareas antes de que el bean este disponible
    public void metodoInicial() {
        // indicar tareas
        System.out.println("Dentro del metodo init. Aqui irian las tareas a ejecutar antes de que el bean este listo");
    }

    // metodo destroy - ejecutar tareas despues de que el bean haya sido usado
    public void metodoFinal() {
        // indicar tareas
        System.out.println("Dentro del metodo destroy. Aqui irian las tareas a ejecutar despues de usar el bean");
    }

    // creacion de constructor que inyecta la dependencia
    public DirectorEmpleado(ICreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String getTareas() {
        return "Gestiona las decisiones directivas de la empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Director: " + this.informeNuevo.getInforme();
    }

}
