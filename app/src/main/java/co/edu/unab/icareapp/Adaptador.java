package co.edu.unab.icareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;


    ArrayList<Registro> registros;

    public Adaptador(Context conexto, ArrayList<Registro> registros)
    {
        this.contexto = conexto;

        this.registros = registros;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);

        TextView nombre_apellido = (TextView) vista.findViewById(R.id.informe_nombre_apellido);
        TextView edad = (TextView) vista.findViewById(R.id.informe_edad);
        TextView peso = (TextView) vista.findViewById(R.id.informe_peso);
        TextView altura = (TextView) vista.findViewById(R.id.informe_altura);
        TextView genero = (TextView) vista.findViewById(R.id.informe_genero);
        TextView imc = (TextView) vista.findViewById(R.id.informe_imc);
        TextView mbasal = (TextView) vista.findViewById(R.id.informe_basal);

        String nombre_apellido_s = registros.get(i).nombre+" "+registros.get(i).apellido;
        String edad_s = registros.get(i).getEdad()+" años";
        String peso_s = registros.get(i).getPeso()+" kg";
        String altura_s = registros.get(i).getAltura()+" m";
        String genero_s = registros.get(i).getGenero();
        String imc_s = registros.get(i).calcularimc();
        String basal_s = registros.get(i).calcularmbasal();

        nombre_apellido.setText(nombre_apellido_s);
        edad.setText(edad_s);
        peso.setText(peso_s);
        altura.setText(altura_s);
        genero.setText(genero_s);
        imc.setText(imc_s);
        mbasal.setText(basal_s);


        return vista;
    }
    @Override
    public int getCount() {
        return registros.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
