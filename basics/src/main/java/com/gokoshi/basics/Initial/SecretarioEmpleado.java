package com.gokoshi.basics.Initial;

public class SecretarioEmpleado implements IEmpleados {

    private ICreacionInformes informeNuevo;
    private String email;
    private String nombreEmpresa;

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

    public void setInformeNuevo(ICreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }

    @Override
    public String getTareas() {
        return "Gestiono la agenda de los jefes";
    }

    @Override
    public String getInforme() {
        return "Informe generado por el secretario: " + this.informeNuevo.getInforme();
    }
}
