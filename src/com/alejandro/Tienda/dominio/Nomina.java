package com.alejandro.Tienda.dominio;

import java.util.ArrayList;
import java.util.List;

public class Nomina {
    private List<Empleado> empleados;

    public Nomina(){
        empleados = new ArrayList<>();
    }

    public List<String> calcularNomina(){
        List<String> nominas = new ArrayList<>();
        for (Empleado emple: empleados) {
           nominas.add(emple.toString());
        }
        return nominas;
    }
    public void añadirEmpleado(Empleado empleadoAgregado){
        empleados.add(empleadoAgregado);
    }

    public List<Directo> listarDirectos(){
        List<Directo> directos = new ArrayList<>();
        for (Empleado tipoEmpleados: empleados) {
            if(tipoEmpleados instanceof Directo){
                directos.add((Directo) tipoEmpleados);
            }
        }
        return directos;
    }
    public List<Freelance> listarFreelancers(){
        List<Freelance> freelances = new ArrayList<>();
        for (Empleado tipoEmpleados: empleados) {
            if(tipoEmpleados instanceof Freelance){
                freelances.add((Freelance) tipoEmpleados);
            }
        }
        return freelances;
    }
    public List<Promotor> listarPromotores(){
        List<Promotor> promotores = new ArrayList<>();
        for (Empleado tipo: empleados) {
            if(tipo instanceof Promotor){
                promotores.add((Promotor) tipo);
            }
        }
        return promotores;
    }

}
