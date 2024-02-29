package com.gokoshi.basics.Initial;

public class JefeEmpleado implements  IEmpleados{


    private ICreacionInformes informeNuevo;
    private String email;
    private String nombreEmpresa;


    public JefeEmpleado(ICreacionInformes informeNuevo) {
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
    public String getTareas() {
        return "Gestiona el personal del departamento";
    }
    @Override
    public String getInforme() {
        return "Informe mensual del gerente del departamento: " + this.informeNuevo.getInforme();
    }
}
