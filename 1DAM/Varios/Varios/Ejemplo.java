import java.util.Scanner;

public class Ejemplo {
    public static void main(String[] args){
        double n=1765765.7654;
        String nStr=Double.toString(n);
        int indexPunto=nStr.indexOf(".");
        String parteEntera=nStr.substring(0, indexPunto);
        System.out.println();
        System.out.println();
        System.out.println(parteEntera);
        int entero=Integer.parseInt(parteEntera);
        System.out.println(parteEntera);

    }
} 