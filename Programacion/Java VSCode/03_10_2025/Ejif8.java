/*

Escribe un programa que pida una fecha (día, mes y año) y diga si es correcta.
6 oct 1582

*/

import java.util.Scanner;

public class Ejif8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca día");
        int day = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca mes");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca año");
        int year = Integer.parseInt(sc.nextLine());
        sc.close();

        boolean leapYear=false;
        if(year%400==0) {
			leapYear=true;
		}
		else if(year%100==0) {
			leapYear=false;
		}
		else if(year%4==0) {
			leapYear=true;
		}

        int daysPerMonth=0;
        switch (month) {
            case 1,3,5,7,8,10,12:
                daysPerMonth=31;
                break;
            case 4,6,9,11:
                daysPerMonth=30;
                break;
            case 2:
                if (leapYear) {
                    daysPerMonth=29;
                }
                else{
                    daysPerMonth=28;
                }
                break;
        }
        boolean correctDate=true;
        if(day<=0 || day>daysPerMonth){
            correctDate=false;
        }
        if(month<=0 || month>12){
            correctDate=false;
        }
        System.out.print("La fecha "+ day + "/" + month + "/" + year + " ");
        if(correctDate){
            System.out.println("es correcta");
        }
        else{
            System.out.println("es incorrecta");
        }
    }
}
