package com.dam.dic10.main;

import java.util.Scanner;

import com.dam.dic10.pojos.Perfil;

/*2. Crea dos paquetes, dam.a.ej2.pojos y dam.a.ej2.main, para almacenar las clases
necesarias para el siguiente desarrollo:
Se debe crear un programa para registrar 10 perfiles de LinkedIn, de manera que:
- Inicialice el array donde almacenarlos
- Para cada perfil solicite la siguiente información:
o Nombre (por ej: Carlos Ibarra Fernández)
o Puesto actual (por ej: Director Comercial de D&B)
o Ciudad (por ej: Madrid)
o Número de contactos (por ej: 326)
- muestre los perfiles almacenados en el array, mostrando cada dato en una línea.
o Ejemplo:
Nombre: Carlos Ibarra Fernández
Puesto actual: Director Comercial de D&B
Ciudad: Madrid
326 Contactos



- indique cuál es el perfil de Madrid con menos contactos.
Comprobación de datos con excepciones, crear las que se necesiten:
- El nombre y el puesto no deben superar los 45 caracteres.
- La ciudad tiene que ser Madrid, Barcelona, Málaga o Valladolid.
- La cantidad de contactos debe ser un valor entero entre 0 y 100000.*/

public class ComparaPerfiles {
    private static final int N_PERFILES=10;
    public static void main(String[] args) {
        Perfil[] p=new Perfil[N_PERFILES];
    }

    private static Perfil solicitaPerfil(Scanner sc){
        String nombre;
        do{
            System.out.println("Introduce nombre");
            nombre=sc.nextLine();
        }while(nombre.length()>0);

        System.out.println("Introduce puesto actual");
        String puestoActual=sc.nextLine();

        System.out.println("Introduce ciudad");
        String ciudad=sc.nextLine();
        
        boolean done=false;
        int numeroContactos=-1;
        while(!done){
            try{
                System.out.println("Introduce numero de contactos");
                numeroContactos=Integer.parseInt(sc.nextLine());
            }
            catch(Exception e){
                System.out.println("numero de contactos debe ser un numero entero");
            }
            if(numeroContactos>=0){
                done=true;
            }
            else{
                System.out.println("numero de contactos debe ser un numero entero positivo");
            }
        }
        return new Perfil(nombre, puestoActual, ciudad, numeroContactos);
    }
}
