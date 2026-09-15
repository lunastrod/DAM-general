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
    private static final String [] CIUDADES={"Madrid","Barcelona","Malaga","Valladolid"};
    private static final int MIN_CONTACTOS=0;
    private static final int MAX_CONTACTOS=100000;
    private static final int MAX_CHAR_NOMBRE=45;
    private static final int MAX_CHAR_PUESTO=45;

    public static void main(String[] args) {
        Perfil[] perfiles=new Perfil[N_PERFILES];

        Scanner sc=new Scanner(System.in);
        for(int i=0; i<perfiles.length; i++){
            System.out.println("Datos de perfil "+(i+1));
            perfiles[i]=solicitaPerfil(sc);
            System.out.println("\n"+perfiles[i]+"\n\n");
        }
        
        sc.close();

        
    }

    private static void analizaPerfiles(Perfil[] perfiles){
        Perfil menosContactos=perfiles[0];
        for(int i=0; i<perfiles.length; i++){
            System.out.println(perfiles[i]);
            if(perfiles[i].getNumeroContactos()<menosContactos.getNumeroContactos()){
                menosContactos=perfiles[i];
            }
        }
        System.out.println("El perfil con menos contactos es:\n"+menosContactos);
    }

    private static Perfil solicitaPerfil(Scanner sc){
        String nombre;
        String puestoActual;
        String ciudad;
        int numeroContactos;

        boolean valid;

        do{
            System.out.println("Introduce nombre - max caracteres="+MAX_CHAR_NOMBRE);
            nombre=sc.nextLine();
        }while(nombre.length()>MAX_CHAR_NOMBRE);

        do{
            System.out.println("Introduce puesto actual - max caracteres="+MAX_CHAR_PUESTO);
            puestoActual=sc.nextLine();
        }while(puestoActual.length()>MAX_CHAR_PUESTO);

        valid=false;
        do{
            System.out.println("Introduce ciudad, opciones:");
            System.out.println(String.join(", ",CIUDADES));
            ciudad=sc.nextLine();
            for(int i=0; i<CIUDADES.length; i++){
                if(ciudad.equals(CIUDADES[i])){
                    valid=true;
                }
            }
        }while(!valid);


        valid=false;
        numeroContactos=-1;
        while(!valid){
            try{
                System.out.println("Introduce numero de contactos");
                numeroContactos=Integer.parseInt(sc.nextLine());
                if(numeroContactos>=MIN_CONTACTOS && numeroContactos<=MAX_CONTACTOS){
                    valid=true;
                }
                else{
                    System.out.println("numero de contactos debe ser un numero entero positivo menor que "+MAX_CONTACTOS);
                }
            }
            catch(NumberFormatException e){
                System.out.println("numero de contactos debe ser un numero entero");
            }

        }
        return new Perfil(nombre, puestoActual, ciudad, numeroContactos);
    }
}
