package com.alejandro.Tienda.dominio;

public class Directo extends Empleado{
    private long salario;
    private static final float APORTE_SALUD =  0.05f;
    private static final float APORTE_PENSION =  0.065f;


    public Directo(String nombre, long salario) {
        super(nombre);
        this.salario = salario;
    }

    @Override
    protected long calcularSalario() {
        return salario - calcularAporte();
    }
    public long calcularSalud(){
        return (long) (salario * APORTE_SALUD);
    }
    public long calcularPension(){
        return (long) (salario * APORTE_PENSION);
    }
    public long calcularAporte(){
        return calcularPension() + calcularSalud();
    }

    public long getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "El empleado directo " + getNombre() + " gana un salario de " + calcularSalario() +" $";
    }
}
