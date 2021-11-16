package co.edu.unab.icareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE_IMC = "1";
    public static final String EXTRA_MESSAGE_BASAL = "2";

    public static ArrayList<Registro> registros = new ArrayList<>();
    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText peso;
    EditText altura;
    Spinner genero;
    Button calculo;
    Button informe;
    Registro nuevo_registro = new Registro();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        edad = (EditText) findViewById(R.id.edad);
        peso = (EditText) findViewById(R.id.peso);
        altura = (EditText) findViewById(R.id.altura);
        genero = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        calculo = (Button) findViewById(R.id.boton_calculo);
        informe = (Button) findViewById(R.id.boton_informe);


    }

        public void sendResults(View view) {


            String nombre_s = nombre.getText().toString();
            String apellido_s = apellido.getText().toString();
            String edad_s = edad.getText().toString();
            String peso_s = peso.getText().toString();
            String altura_s = altura.getText().toString();
            String genero_s = genero.getSelectedItem().toString();

            nuevo_registro = new Registro(nombre_s,apellido_s,edad_s,altura_s,peso_s,genero_s);

            registros.add(nuevo_registro);


            String imc_final = nuevo_registro.calcularimc();
            String mbasal_final = nuevo_registro.calcularmbasal();
            Intent intent = new Intent(this, DisplayResultsActivity.class);
            // TextView editTextMetBas = (TextView) findViewById(R.id.resultado_metabolismobasal);
            // TextView editTextImc = (TextView) findViewById(R.id.resultado_imc);

            intent.putExtra(EXTRA_MESSAGE_IMC, imc_final);
            intent.putExtra(EXTRA_MESSAGE_BASAL, mbasal_final);
            startActivity(intent);
            }


            public void ver_informe(View view){
                Intent i = new Intent(this, Informe.class);
                startActivity(i);
            }


}