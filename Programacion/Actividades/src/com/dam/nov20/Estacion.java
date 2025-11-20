/*Crea un paquete com.dam.ej2.pojo y dentro crea una clase
Estacion con las siguientes características:
• Que permita almacenar el nombre, la provincia, el estado
(ABIERTA/CERRADA), el número de remontes, el número de pistas y el
número de km esquiables de una estación de esquí.
Ejemplo: Formigal, Huesca, ABIERTA, 31/37, 73/147, 57/182
• Que tenga un constructor que inicialice los seis atributos.
• Que tenga un método que permita mostrar los datos de una estación por
consola con el siguiente formato:
Ejemplo de lo que se debe mostrar por consola:
Formigal (Huesca)
Estado: ABIERTA
Remontes: 31/37, Pistas: 73/147, Km esquiables: 57/182
Tavascán (Lleida)
Estado: CERRADA
(Si la estación está cerrada no se mostrará más información)
• Que tenga un método que calcule el porcentaje de km esquiables con
respecto al total.
Ejemplo: para 57/182 debería devolver un 31,32
• Que tenga un método que retorne el número de km esquiables abiertos.
Ejemplo: para 57/182 debería devolver un 57*/

package com.dam.nov20;

public class Estacion {
    public static final String[] VALORES_ESTADO={"ABIERTA","CERRADA"};

    private String nombre;
    private String provincia;
    private String estado; // ABIERTA/CERRADA
    private String remontes;
    private String pistas;
    private String kmEsquiables;

    public Estacion(String nombre, String provincia, String estado, String numRemontes, String numPistas, String numKmEsquiables) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.estado = estado;
        this.remontes = numRemontes;
        this.pistas = numPistas;
        this.kmEsquiables = numKmEsquiables;
    }

    public boolean isAbierta(){
        return estado.equals(VALORES_ESTADO[0]);
    }

    public double porcentajeKmEsquiables(){
        //calcula el porcentaje de km esquiables con respecto al total.
        String[] partes=kmEsquiables.split("/");
        double abiertos=Double.parseDouble(partes[0]);
        double total=Double.parseDouble(partes[1]);
        return (abiertos/total)*100;
    }

    public int kmEsquiablesAbiertos(){
        //número de km esquiables abiertos.
        String[] partes=kmEsquiables.split("/");
        return Integer.parseInt(partes[0]);
    }
/*
    Formigal (Huesca)
    Estado: ABIERTA
    Remontes: 31/37, Pistas: 73/147, Km esquiables: 57/182
    Tavascán (Lleida)
    Estado: CERRADA 
*/
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(nombre);
        res.append(" (");
        res.append(provincia);
        res.append(")\nEstado: ");
        res.append(estado);
        if (estado.equals(VALORES_ESTADO[0])){
            res.append("\nRemontes: ");
            res.append(remontes);
            res.append(", Pistas: ");
            res.append(pistas);
            res.append(", Km esquiables: ");
            res.append(kmEsquiables);
        }
        return res.toString();
    }
}
