package com.dam.feb26;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dam.lib.Graf1;

/*
4. Crea el siguiente programa en JAVA con interfaz gráfica. Realiza un
programa que para un número de tres cifras (se debe validar esto) que se
introduzca por interfaz, nos diga si el número es o no capicúa.
*/

public class E4 extends JFrame{
    JLabel lblMsg;
    JButton btnCapicua;
    JTextField txtEntrada;
    public E4(){
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
        Graf1.newF(this, "E4", 1000, 1000);
    }

    public boolean esCapicua(int n) throws Exception{
        String num=Integer.toString(n);
        StringBuilder numSB= new StringBuilder(num);
        numSB.reverse();
        String numReversed=numSB.toString();
        if(num.length()==3){
            return num.equals(numReversed);
        }
        throw new Exception("Introduce un numero de 3 cifras");
    }

    public void crearComponentes(){
        Graf1.newC(new JLabel(),this,"Introduce un numero de 3 cifras");
        txtEntrada=(JTextField)Graf1.newC(new JTextField(),this,"miau",0,50,200,30);
        btnCapicua=(JButton)Graf1.newC(new JButton(),this,"Comprobar",0,100);
        lblMsg=(JLabel)Graf1.newC(new JLabel(),this,"",0,150,350,30);
        btnCapicua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    int n=Integer.parseInt(txtEntrada.getText());
                    if(esCapicua(n)){
                        lblMsg.setText("Es capicua");
                    }
                    else{
                        lblMsg.setText("No es capicua");
                    }
                }catch(NumberFormatException x){
                    lblMsg.setText("Introduce un numero valido");
                }catch(Exception x){
                    lblMsg.setText(x.getMessage());
                }
            }
        });
    }
    
    public void hacerVisible(){
        Graf1.show(this);
    }
}