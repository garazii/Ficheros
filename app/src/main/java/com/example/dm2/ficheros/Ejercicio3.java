package com.example.dm2.ficheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio3 extends AppCompatActivity {

    private ListView webs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        webs = (ListView) findViewById(R.id.webs);

        ArrayList<MisWebs> lista=new ArrayList<MisWebs>();
        ArrayList<Integer> img=new ArrayList<Integer>();

        try {
            InputStream fraw = getResources().openRawResource(R.raw.webs);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            String str = brin.readLine();

            int cont = 0;
            String imagen1="bing";

            while (str != null) {
                String[] datos=str.split(";");
                lista.add(new MisWebs(datos[0],datos[1],datos[3]));
                if(datos[2].equals(imagen1))
                {
                    img.add(R.drawable.bing);
                }
                else
                {
                    img.add(R.drawable.yahoo);
                }
                str=brin.readLine();
                cont++;
            }

            brin.close();
            fraw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }

        AdaptadorWebs adaptador=new AdaptadorWebs(this,lista,img);

        webs=(ListView)findViewById(R.id.webs);
        webs.setAdapter(adaptador);
    }
}
