package com.dam.dic10.pojos;

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

public class Perfil {
    String nombre;
    String puestoActual;
    String ciudad;
    int numeroContactos;


    public Perfil(String nombre, String puestoActual, String ciudad, int numeroContactos) {
        this.nombre = nombre;
        this.puestoActual = puestoActual;
        this.ciudad = ciudad;
        this.numeroContactos = numeroContactos;
    }

    public int getNumeroContactos() {
        return numeroContactos;
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Nombre: ");
        sb.append(nombre);
        sb.append("\nPuesto actual: ");
        sb.append(puestoActual);
        sb.append("\nCiudad: ");
        sb.append(ciudad);
        sb.append("\n");
        sb.append(numeroContactos);
        sb.append(" Contactos");
        return sb.toString();
    }
}
