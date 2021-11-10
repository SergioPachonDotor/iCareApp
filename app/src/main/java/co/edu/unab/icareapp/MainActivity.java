package co.edu.unab.icareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "co.edu.unab.icareapp.MESSAGE";
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
        calculo = (Button) findViewById(R.id.boton_calculo);
    }

        public void sendResults(View view) {
            String imc_final = calcularimc();
            String mbasal_final = calcularmbasal();
            Intent intent = new Intent(this, DisplayResultsActivity.class);
            // TextView editTextMetBas = (TextView) findViewById(R.id.resultado_metabolismobasal);
            // TextView editTextImc = (TextView) findViewById(R.id.resultado_imc);

            intent.putExtra(EXTRA_MESSAGE, imc_final);
            intent.putExtra(EXTRA_MESSAGE, mbasal_final);
            startActivity(intent);
            }



    public String calcularimc(){
        try {
            double peso_d = Double.parseDouble(peso.getText().toString());
            double altura_d = Double.parseDouble(altura.getText().toString());
            double imc_d  = peso_d / altura_d * altura_d;
            String resultado = "Su IMC es: "+imc_d;
            return resultado;
            }
        catch (Exception exception){
            String message = "Por favor ingresa los datos";
            return message;
        }

    }

    public String calcularmbasal(){
        String resultado = null;
        try {
            double peso_d = Double.parseDouble(peso.getText().toString());
            double altura_d = Double.parseDouble(altura.getText().toString());
            double edad_d = Double.parseDouble(edad.getText().toString());

            double mbasal_mujer =( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)-161;
            double mbasal_hombre = ( 10*peso_d)+(6.25*altura_d*100)-(5*edad_d)+5;

            if (genero.getSelectedItem().toString() == "Masculino"){
                resultado = "Su metabolismo basal es: "+mbasal_hombre;
            }
            else if(genero.getSelectedItem().toString() == "Femenino"){
                resultado = "Su metabolismo basal es: "+mbasal_mujer;;
        }

        }
        catch (Exception exception){
            String message = "Por favor ingresa los datos";
            return message;
        }
        return resultado;
    }

}