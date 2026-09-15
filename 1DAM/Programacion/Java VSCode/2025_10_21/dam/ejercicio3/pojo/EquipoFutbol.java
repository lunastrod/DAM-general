package dam.ejercicio3.pojo;
/*
 * 
 * Crear una clase EquipoFutbol con las siguientes características: (2.5 puntos)
- Que permita almacenar el nombre, la ciudad, el número de partidos
ganados, partidos empatados y partidos perdidos. Piensa qué tipo de
dato debe ser cada atributo.
- Que tenga un constructor que inicialice los atributos.
- Que tenga un método calcularPuntos que retorne la cantidad de puntos
que lleva el equipo en función de:
- Los partidos ganados suman 3 puntos
- Los partidos empatados suman 1 punto
- Los partidos perdidos suman 0 puntos
- Que tenga un método que nos permita mostrar mediante un sysout los
datos del equipo de la siguiente manera:
<nombreEquipo> - <ciudad>
Número de partidos ganados: <partidosGanados>
Número de partidos empatados: <partidosEmpatados>
Número de partidos perdidos: <partidosPerdidos>
 */

public class EquipoFutbol {
    String nombre;
    String ciudad;
    int partidosGanados;
    int partidosEmpatados;
    int partidosPerdidos;

    public EquipoFutbol(String n,String c, int g, int x, int p){
        nombre=n;
        ciudad=c;
        partidosGanados=g;
        partidosEmpatados=x;
        partidosPerdidos=p;
    }

    public int calcularPuntos(){
        return partidosGanados*3+partidosEmpatados;
    }

    public String toString() {
        String result="";
        result+=nombre+" - "+ciudad;
        result+="\nNúmero de partidos ganados: "+partidosGanados;
        result+="\nNúmero de partidos empatados: "+partidosEmpatados;
        result+="\nNúmero de partidos perdidos: "+partidosPerdidos;
        return result;
    }
}
