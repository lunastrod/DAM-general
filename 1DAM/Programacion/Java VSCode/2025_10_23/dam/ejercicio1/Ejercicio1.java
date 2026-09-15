package dam.ejercicio1;

/*Crea una clase, Ejercicio1, que imprima por consola, usando un bucle, 18
términos de la serie 94 - 88 - 82 – 76 – 70 - .... */

public class Ejercicio1 {
    static final int N_NUMS=18;
    static final int START=94;
    static final int STEP=-6;
    public static void main(String[] args) {
        int n=START;
        for(int i=0; i<N_NUMS; i++){
            System.out.println(n);
            n+=STEP;
        }
    }
}
