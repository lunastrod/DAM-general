package dam.ejercicio3.main;

import java.util.Scanner;

import dam.ejercicio3.pojo.JugadorTenis;

/*Se soliciten los datos de dos tenistas.
- Y se informe de cuál es el tenista con más puntos. */

public class CompararResultados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JugadorTenis j1=solicitaJugador(sc);
        JugadorTenis j2=solicitaJugador(sc);
        sc.close();

        if(j1.calcularPuntos()>j2.calcularPuntos()){
            System.out.println("Jugador con más puntos: "+ j1);
        }else if(j1.calcularPuntos()==j2.calcularPuntos()){
            System.out.println("Los 2 jugadores están empatados!: "+j1+"\n"+j2);
        }else{
            System.out.println("Jugador con más puntos: "+ j2);
        }
    }
    public static JugadorTenis solicitaJugador(Scanner sc){
        System.out.println("Nombre de jugador");
        String nombre=sc.nextLine();
        System.out.println("nacionalidad");
        String nacionalidad=sc.nextLine();
        System.out.println("Numero de Grand Slam ganados");
        int numGSGanados=Integer.parseInt(sc.nextLine());
        System.out.println("Numero de Master 1000 ganados");
        int numM1000Ganados=Integer.parseInt(sc.nextLine());
        return new JugadorTenis(nombre, nacionalidad, numGSGanados, numM1000Ganados);
    }
}
