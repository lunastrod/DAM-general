package dam.ejercicio3.pojo;

/*Crear una clase JugadorTenis con las siguientes características: (2.5 puntos)
- Que permita almacenar el nombre, la nacionalidad, el número de Grand
Slam ganados y el número de Master1000 ganados. Piensa qué tipo de
dato debe ser cada atributo.
- Que tenga un constructor que inicialice los atributos.

- Que tenga un método calcularPuntos que retorne la cantidad de puntos
que lleva el tenista en función de:
- Cada Grand Slam vale 2000 puntos
- Cada Master 1000 vale 1000 puntos

- Que tenga un método que nos permita mostrar mediante un sysout los
datos del tenista de la siguiente manera:
<nombreTenista> - <nacionalidad>
Número de Grand Slam: <numGSGanados>
Número de Master 1000: <numM1000Ganados> */

public class JugadorTenis {
    String nombre;
    String nacionalidad;
    int numGSGanados;
    int numM1000Ganados;

    static final int PUNTOS_GS=2000;
    static final int PUNTOS_M1000=1000;

    public JugadorTenis(String nombre, String nacionalidad, int numGSGanados, int numM1000Ganados) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.numGSGanados = numGSGanados;
        this.numM1000Ganados = numM1000Ganados;
    }

    public int calcularPuntos(){
        return numGSGanados*PUNTOS_GS+numM1000Ganados*PUNTOS_M1000;
    }

    @Override
    public String toString() {
        return nombre+" - "+nacionalidad+"\nNúmero de Grand Slam: "+numGSGanados+"\nNúmero de Master 1000: "+numM1000Ganados;
    }
}
