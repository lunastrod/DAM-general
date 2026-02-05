package com.dam.feb5;

import java.util.ArrayList;

public class Empresa {
    String nombre;
    ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void addEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

     public double calcularTotalSalarios() {
        double total = 0;
        for (Empleado empleado : listaEmpleados) {
            total += empleado.getSalario();
            if (empleado instanceof EmpleadoProduccion) {
                EmpleadoProduccion prod = (EmpleadoProduccion) empleado;
                total += prod.getPlusNoct();
            }
        }
        return total;
    }

     @Override
     public String toString() {
         // TODO Auto-generated method stub
         String res="Empresa: "+nombre+" con "+listaEmpleados.size()+" empleados:\n";
        for (Empleado empleado : listaEmpleados) {
            res+=empleado.toString()+"\n";
        }
        return res;
    }
}
