package com.dam.feb3;

import java.util.ArrayList;

public class Casa {
    private ArrayList<Estancia> listaEstancias;
    private String direccion;

    public Casa(String direccion) {
        this.direccion = direccion;
        this.listaEstancias = new ArrayList<>();
    }

    public void addEstancia(Estancia estancia) {
        listaEstancias.add(estancia);
    }

    public ArrayList<Estancia> getListaEstancias() {
        return listaEstancias;
    }

    public double calcularTotalM2(){
        double totalM2 = 0;
        for (Estancia estancia : listaEstancias) {
            totalM2 += estancia.getMetrosCuad();
            if(estancia instanceof Cocina){
                Cocina cocina = (Cocina) estancia;
                if(cocina.isTieneTendedero()){
                    totalM2 += cocina.getM2Tend();
                }
            }else if(estancia instanceof Salon){
                Salon salon = (Salon) estancia;
                if(salon.isTieneTerraza()){
                    totalM2 += salon.getM2Terr();
                }
            }
        }
        return totalM2;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Casa en "+ direccion +" con ").append(listaEstancias.size()).append(" estancias:\n");
        for (Estancia estancia : listaEstancias) {
            sb.append(estancia).append("\n");
        }
        return sb.toString();
    } 

}
