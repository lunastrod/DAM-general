package com.astrod.adivinanumero;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int intentos=5;
    private boolean adivinado=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout mainLayout=findViewById(R.id.mainLayout);
        Button btnComparacion=findViewById(R.id.btnComparacion);
        TextView txtIntentos=findViewById(R.id.txtIntentos);
        TextView txtPista=findViewById(R.id.txtPista);
        EditText editNumero=findViewById(R.id.editNumero);


        Random rd=new Random();
        int randomNumber=rd.nextInt(100)+1;
        txtIntentos.setText("Intentos restantes: "+intentos);

        btnComparacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intentos>0){
                    int intento=Integer.parseInt(editNumero.getText().toString());
                    if(intento<randomNumber){
                        txtPista.setText("El numero es mayor");
                        intentos--;
                        txtIntentos.setText("Intentos restantes: "+intentos);
                    } else if (intento==randomNumber) {
                        txtPista.setText("Lo has adivinado!");
                        adivinado=true;
                        btnComparacion.setEnabled(false);
                        mainLayout.setBackgroundColor(Color.parseColor("#55FF55"));

                    } else{
                        txtPista.setText("El numero es menor");
                        intentos--;
                        txtIntentos.setText("Intentos restantes: "+intentos);
                    }
                }else{
                    btnComparacion.setText("Se acabó el juego");
                    btnComparacion.setEnabled(false);
                    mainLayout.setBackgroundColor(Color.parseColor("#FF5555"));
                }


            }
        });
    }

    protected void fallo(){

    }

    protected void acierto(){

    }
}