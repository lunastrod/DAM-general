package com.dam.nov13;

/*Queremos realizar una encuesta a 10 personas, en esta encuesta
indicaremos el sexo (1=masculino, 2=femenino), si trabaja (1=si trabaja,
2= no trabaja) y su sueldo (si tiene un trabajo, sino será un cero)
estará entre 600 y 2000 (valor entero). Los valores pueden ser
generados aleatoriamente. Calcula y muestra lo siguiente:
• Porcentaje de hombres (tengan o no trabajo).
• Porcentaje de mujeres (tengan o no trabajo).
• Porcentaje de hombres que trabajan.
• Porcentaje de mujeres que trabajan.
• El sueldo promedio de los hombres que trabajan.
• EL sueldo promedio de las mujeres que trabajan.
Usa todos los métodos que veas necesarios, piensa que es aquello que
se repite o que puede ser mejor tenerlo por separado. */
import com.dam.nov13.Persona;

public class Ej9 {
    private static final int N_PERS=1000000;
    public static void main(String[] args) {
        Persona[] pers=new Persona[N_PERS];
        for (int i=0; i<pers.length;i++){
            pers[i]=new Persona();
            pers[i].generaPersonaAleatoria();
        }

        int nHombres=0;
        int nHombresTrabajadores=0;
        long salarioHombresTotal=0;
        int nMujeres=0;
        int nMujeresTrabajadoras=0;
        long salarioMujeresTotal=0;
        for(int i=0; i<pers.length;i++){
            if(pers[i].esHombre()){
                nHombres++;
                if(pers[i].esTrabajador()){
                    nHombresTrabajadores++;
                    salarioHombresTotal+=pers[i].getSueldo();
                }
            }
            if(pers[i].esMujer()){
                nMujeres++;
                if(pers[i].esTrabajador()){
                    nMujeresTrabajadoras++;
                    salarioMujeresTotal+=pers[i].getSueldo();
                }
            }
        }
        System.out.println("Porcentaje de hombres: "+(nHombres*100.0/pers.length)+"%");
        System.out.println("Porcentaje de mujeres: "+(nMujeres*100.0/pers.length)+"%");
        System.out.println("Porcentaje de hombres trabajadores: "+(nHombresTrabajadores*100.0/pers.length)+"%");
        System.out.println("Porcentaje de mujeres trabajadoras: "+(nMujeresTrabajadoras*100.0/pers.length)+"%");
        System.out.println("Sueldo promedio de hombres: "+(salarioHombresTotal/nHombresTrabajadores)+" euros");
        System.out.println("Sueldo promedio de mujeres: "+(salarioMujeresTotal/nMujeresTrabajadoras)+" euros");
    }
}
