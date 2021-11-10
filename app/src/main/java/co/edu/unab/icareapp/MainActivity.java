package co.edu.unab.icareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText edad;
    EditText peso;
    EditText altura;
    Spinner genero;
    Button calculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edad = (EditText) findViewById(R.id.edad);
        peso = (EditText) findViewById(R.id.peso);
        altura = (EditText) findViewById(R.id.altura);
        genero = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        calculo = (Button)findViewById(R.id.boton_calculo);

        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double imc_final = calcularimc();
                String mbasal_final = calcularmbasal();
            }
        });

    }


    public double calcularimc(){
        double peso_d = Double.parseDouble(peso.getText().toString());
        double altura_d = Double.parseDouble(altura.getText().toString());
        double imc_d  = peso_d / altura_d * altura_d;
        return imc_d;
    }

    public String calcularmbasal(){
        double peso_d = Double.parseDouble(peso.getText().toString());
        double altura_d = Double.parseDouble(altura.getText().toString());
        double edad_d = Double.parseDouble(edad.getText().toString());

        double mbasal_mujer =( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)-161;
        double mbasal_hombre = ( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)+5;

        String resultado = "El metabolismo basal para una mujer es: "+mbasal_mujer+" y para un hombre es: "+mbasal_hombre;
        return resultado;
    }

}