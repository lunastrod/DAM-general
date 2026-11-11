package ej1oct13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//'C:\Program Files\Java\jdk-21\bin\jar.exe' cfe hijo.jar oct13.Hijo -C out-hijo .              

public class Hijo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        while (in.readLine() != null) {
            System.out.println(random.nextInt(11));
            System.out.flush();
        }
    }
}