/*Crea un paquete dam.ej2.pojo y dentro crea una clase
Encuesta con las siguientes características:
 Que permita almacenar el valor de cuatro respuestas a las siguientes
preguntas:
Edad
¿Ha pasado usted el COVID-19? La respuesta será SI o NO
¿Qué síntomas padeció? (indicar los síntomas, separados por comas)
Síntomas respiratorios
Diarrea
Cansancio o Malestar
Perdida del olfato
Perdida del gusto
Fiebre
Sin síntomas
La respuesta será algo así: Síntomas respiratorios, Cansancio, Fiebre (por
ejemplo)
Nivel de gravedad: La respuesta será un valor del 1 al 5 representando el 1:
Ninguna, el 2: Leve, el 3: Media, el 4: Alta y el 5: Hospitalización.
Ejemplo de valores: SI / Síntomas respiratorios, Cansancio, Fiebre / 3
 Que tenga un constructor que inicialice los cuatro atributos.
 Que tenga un método que permita mostrar los datos de una encuesta por
consola.
Ejemplo de lo que se debe mostrar por consola:
Edad: 55 años
¿Ha pasado usted el COVID-19? SI
¿Qué síntomas padeció? Síntomas respiratorios, Cansancio, Fiebre
Nivel de gravedad: Media
 Que tenga un método que calcule cuántos síntomas padeció en el caso de que
si haya pasado la enfermedad.
Ejemplo: para Síntomas respiratorios, Cansancio, Fiebre debería devolver un 3
 Crea las constantes que consideres. */

package com.dam.nov18;

public class Encuesta {
    static final String[] NIVELES_GRAVEDAD={"ERROR","Ninguna","Leve","Media","Alta","Hospitalización"};
    static final String[] POSIBLES_SINTOMAS={"Sin síntomas","Síntomas respiratorios","Diarrea","Cansancio o Malestar","Perdida del olfato","Perdida del gusto","Fiebre"};

    private int edad;
    private boolean covid;
    private String sintomas;
    private int gravedad;

    public Encuesta(int edad, boolean covid, String sintomas, int gravedad) {
        this.edad = edad;
        this.covid = covid;
        this.sintomas = sintomas;
        this.gravedad = gravedad;
    }
    public boolean isCovid() {
        return covid;
    }

    public int getEdad() {
        return edad;
    }

    public int getGravedad() {
        return gravedad;
    }

    public int numSintomas(){
        int num=0;
        if(sintomas.length()>0){
            num++;
            int index=0;
            while(index>=0){
                index=sintomas.indexOf(sintomas, index);
                num++;
            }
        }
        return num;
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        result.append(String.format("Edad: %d años", edad));
        result.append("\n¿Ha pasado usted el COVID-19? ");
        if(covid){
            result.append("SI");
        }
        else{
            result.append("NO");
        }
        result.append("\n¿Qué síntomas padeció? ");
        result.append(sintomas);
        result.append("\nNivel de gravedad: ");
        result.append(NIVELES_GRAVEDAD[gravedad]);
        return result.toString();
    }
}
