/*Crea una clase, Ejercicio1, que imprima por consola, usando un bucle, 24
términos de la serie 17 - 24 - 31 – 38 */

public class Ej1 {
    public static final int INIT=17;
    public static final int STEP=7;
    public static final int N_NUMS=24;
    public static void main(String[] args) {
        int num=INIT;
        for (int i=0; i<N_NUMS; i++){
            System.out.println(num);
            num+=STEP;
        }
    }
}
