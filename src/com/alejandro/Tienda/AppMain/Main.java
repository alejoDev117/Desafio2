package com.alejandro.Tienda.AppMain;

import com.alejandro.Tienda.dominio.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean seguir = true;
        Nomina sistemaNomina = new Nomina();
        while(seguir){
            int opcion = JOptionPane.showOptionDialog(null,"Que desea hacer","Nomina",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null, new Object[]{"Agregar empleado","Mostrar nomina","Mostrar tablas"},null);
            switch (opcion){
                case 0:{
                    String nombre = JOptionPane.showInputDialog(null,"Ingrese nombre");
                    String tipoEmpleado = (String) JOptionPane.showInputDialog(null,"Que tipo de contrato tiene?","Tipo de Empleado",JOptionPane.INFORMATION_MESSAGE,null,new Object[]{"Directo","Vendedor","Freelancer"},null);
                    switch (tipoEmpleado){
                        case "Directo":{
                            long salarioBase = Long.parseLong(JOptionPane.showInputDialog("Ingrese salario base"));
                            Empleado nuevoAgregar = new Directo(nombre,salarioBase);
                            sistemaNomina.añadirEmpleado(nuevoAgregar);
                            break;
                        }
                        case "Vendedor":{
                            long salarioBase = Long.parseLong(JOptionPane.showInputDialog("Ingrese salario base"));
                            long ventas = Long.parseLong(JOptionPane.showInputDialog("Ingrese ventas del mes"));
                            Empleado nuevoAgregar = new Vendedor(nombre,salarioBase,ventas);
                            sistemaNomina.añadirEmpleado(nuevoAgregar);
                            break;
                        }
                        case "Freelancer":{
                            long valorHora = Long.parseLong(JOptionPane.showInputDialog("Ingrese valor por hora"));
                            int horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese total de horas trabajadas"));
                            Empleado nuevoAgregar = new Freelance(nombre,valorHora,horasTrabajadas);
                            sistemaNomina.añadirEmpleado(nuevoAgregar);
                            break;
                        }
                    }
                    break;
                }
                case 1:{
                    String tablaEnPantalla ="";
                    for (String mostrarEmpleados: sistemaNomina.calcularNomina()) {
                        tablaEnPantalla += mostrarEmpleados +"\n";
                    }
                    JOptionPane.showMessageDialog(null,tablaEnPantalla);
                    break;
                }
                case 2:{
                    int opcionTabla = JOptionPane.showOptionDialog(null,"Que tabla desea ver?","Tablas",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new Object[]{"Tabla Directo","Tabla Freelance"},null);
                    switch (opcionTabla){
                        case 0: {
                            String tablaEnPantalla = "";
                            for (Empleado tabla: sistemaNomina.listarDirectos()) {
                                tablaEnPantalla += tabla.toString()+"\n";
                            }
                            JOptionPane.showMessageDialog(null,tablaEnPantalla,"Tabla Directos",JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        case 1:{
                            String tablaEnPantalla = "";
                            for (Empleado tabla: sistemaNomina.listarFreelancers()) {
                                tablaEnPantalla += tabla.toString()+"\n";
                            }
                            JOptionPane.showMessageDialog(null,tablaEnPantalla,"Tabla Freelancers",JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    break;
                }
                case  -1: {
                    seguir = false;
                    break;
                }
            }

        }
    }
}