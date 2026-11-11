package ej2oct13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//$jdk='C:\Program Files\Java\jdk-21\bin'; & "$jdk\javac.exe" -encoding UTF-8 -d out-hijo ej2oct13/Hijo2.java; & "$jdk\jar.exe" cfe ej2oct13/hijo2.jar ej2oct13.Hijo2 -C out-hijo .

public class Hijo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String linea;

        while ((linea = in.readLine()) != null) {
            if (esPalindromo(linea)) {
                System.out.println("\"" + linea + "\" es palindromo");
            } else {
                System.out.println("\"" + linea + "\" no es palindromo");
            }
            System.out.flush();
        }
    }

    private static boolean esPalindromo(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}