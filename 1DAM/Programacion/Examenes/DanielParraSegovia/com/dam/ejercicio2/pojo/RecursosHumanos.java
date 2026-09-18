package com.dam.ejercicio2.pojo;

import java.util.Scanner;

import com.dam.ejercicio2.main.Empleado;

public class RecursosHumanos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero de empleados:");
        int numEmpleados=Integer.parseInt(sc.nextLine());
        Empleado e;

        Empleado empleadoMasAntig=new Empleado("error","error",-1);
        //necesito inicializar empleadoMasAntig para que java me deje usarlo
        //fuera del bucle sin dar errores de may not have been init
        //asi que de paso le doy una antigüedad negativa y asi no necesito
        //asignar e a esta variable en la primera iteracion del bucle.
        int nMas3Anios=0;
        for(int i=0; i<numEmpleados; i++){
            System.out.println("Introduzca datos de empleado "+i);
            e=generaEmpleado(sc);
            if(empleadoMasAntig.getNumAnio()<e.getNumAnio()){
                empleadoMasAntig=e;
            }
            if(e.getNumAnio()>3){
                nMas3Anios++;
            }
            System.out.println(e);
        }
        sc.close();

        System.out.println("El empleado más antigüo es :\n"+empleadoMasAntig);
        System.out.println("Hay "+nMas3Anios+" empleados con más de 3 años de antigüedad");
    }
    
    public static Empleado generaEmpleado(Scanner sc){
        System.out.println("\tnombre");
        String nombre=sc.nextLine();
        System.out.println("\tdni");
        String dni=sc.nextLine();
        System.out.println("\tAntigüedad en años");
        int numAnio=Integer.parseInt(sc.nextLine());
        return new Empleado(nombre, dni, numAnio);
    }
}
