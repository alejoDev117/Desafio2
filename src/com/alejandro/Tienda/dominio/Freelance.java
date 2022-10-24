package com.alejandro.Tienda.dominio;

public class Freelance extends Empleado{
    private long valorHora;
    private int horasTrabajadas;

    public Freelance(String nombre, long valorHora, int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }


    @Override
    protected long calcularSalario() {
        return horasTrabajadas * valorHora;
    }

    @Override
    public String toString() {
        return "El empleado freelance " + getNombre() + " gana un salario de " + calcularSalario() +" $";
    }
}
