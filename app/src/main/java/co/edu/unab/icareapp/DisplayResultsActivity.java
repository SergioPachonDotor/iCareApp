package co.edu.unab.icareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class DisplayResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String resImc = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String resMbs = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView resultado_imc_tv = findViewById(R.id.resultado_imc);
        TextView resultado_mbs_tv = findViewById(R.id.resultado_metabolismobasal);

        resultado_imc_tv.setText(resImc);
        resultado_mbs_tv.setText(resMbs);
    }
}