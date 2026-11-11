package com.astrod.segundoproyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.astrod.segundoproyecto.pojo.DataManager;
import com.astrod.segundoproyecto.pojo.Lenguaje;

public class MainActivity extends AppCompatActivity {

    private DataManager dm ;

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

        dm=new DataManager();
        TextView txtLenguaje=findViewById(R.id.txtNombreLenguaje);
        Button btnVerDesc=findViewById(R.id.btnDesc);
        Button btnCambio=findViewById(R.id.btnCambio);

        btnVerDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lenguaje l=dm.getLenguaje();
                txtLenguaje.setText(l.getDescripcion());
            }
        });

        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.siguienteLenguaje();
                actualizarVista(txtLenguaje);
            }
        });
    }

    public void actualizarVista(TextView txtLenguaje){
        Lenguaje l=dm.getLenguaje();
        txtLenguaje.setText(l.getNombre());
    }
}