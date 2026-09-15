import java.util.Random;
import java.util.Scanner;

public class Ejemplos {
    public static void main(String[] args) {
        //VARIABLES Y OPERADORES=======================================================
        int variable; //asi creo una variable
        //int variable //esto da error, no puedo crear la misma variable 2 veces´
        int variable2=2; //asi creo una variable y le doy un valor
        variable2=20; //puedo cambiar el valor de una variable

        String texto;
        double numeroDecimal;
        int numeroEntero;
        boolean condicion;

        condicion=true;
        String operadorTernario=(condicion)?"Texto si condicion es true":"Texto si condicion es false";


        //SCANNER Y RANDOM=======================================================
        Scanner sc = new Scanner();
        String linea=sc.nextLine();//asi pido un texto

        int a=sc.nextInt();
        sc.nextLine();//asi pido un numero entero, que no se te olvide nextLine();!!!

        double d=sc.nextDouble();
        sc.nextLine();//asi pido un numero con decimales

        sc.close();//QUE NO SE TE OLVIDE HACER sc.close();!!!!!!!!!!!!!!!!!!

        Random rd = new Random();
        int b=rd.nextInt(5,20);//asi genero un numero aleatorio entre 5 y 20
        
        //IF=======================================================
        condicion=true;
        if(condicion){
            System.out.println("Soy un if que se ejecuta si condicion es true");
        }

        condicion=false;
        if(condicion){
            System.out.println("Soy un if que no se ejecuta porque condicion es false");
        }else{
            System.out.println("Soy un else que se ejecuta si condicion no es true");
        }

        //SWITCH=======================================================
        int caso=3;
        switch (caso) {
            case 4:
                System.out.println("No me ejecuto");
                break;
            case 1:
                System.out.println("No me ejecuto");
                break;
            case 3:
                System.out.println("Soy un switch que se ejecuta porque caso es 3");
                break;
            case 2:
                System.out.println("No me ejecuto");
                break;
            default:
                break;
        }
        
        //BUCLES FOR=======================================================
        for(int i=0; i<10; i++){
            System.out.println("Soy un bucle que se ejecuta 10 veces");
            System.out.println("Empiezo en 0 y voy de 1 en 1");
        }

        for(int i=5; i<=15; i+=5){
            System.out.println("Soy un bucle que imprime 5,10,15");
            System.out.println("Empiezo en 5 y voy de 5 en 5 hasta 15");
        }

        //WHILE=======================================================
        condicion=true;
        while(condicion){
            System.out.println("Soy un bucle se ejecuta hasta que condicion sea false");
            condicion=false;//No te olvides de actualizarme en el bucle o seré un bucle infinito!!!
        }

        condicion=false;
        do{
            System.out.println("Aunque condicion sea false yo me ejecuto al menos una vez");
        }while(condicion);
    }
}
