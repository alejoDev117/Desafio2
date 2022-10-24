package com.alejandro.Tienda.dominio;

public class Vendedor extends Directo{
    private long ventasDelMes;
    private static final float MAS_DEL_MINIMO = 0.035f;
    private static final float MENOS_DEL_MINIMO =0.045f;

    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    @Override
    protected long calcularSalario() {
        return super.calcularSalario() + calcularComision();

    }

    public long calcularComision(){
        if(getSalario() >= 1000000){
            return (long) (ventasDelMes * MAS_DEL_MINIMO);
        } else if (getSalario() < 1000000) {
            return (long) (ventasDelMes * MENOS_DEL_MINIMO);
        }
        return  0;
    }

    @Override
    public String toString() {
        return "El empleado vendedor " + getNombre() + " gana un salario de " + calcularSalario() +" $";
    }
}
