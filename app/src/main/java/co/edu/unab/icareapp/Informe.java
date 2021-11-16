package co.edu.unab.icareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Informe extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);

        ArrayList registros = MainActivity.registros;
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout_informe);
        generarInforme(registros);

    }

    public void generarInforme(ArrayList<Registro> registros){
        for (int i=0;i<registros.size();i++){
            TextView textView = new TextView(this);
            textView.setTextSize(16);

            String nombre_usuario = registros.get(i).getNombre();
            textView.setText(nombre_usuario);

            linearLayout.addView(textView);
        }
    }
}