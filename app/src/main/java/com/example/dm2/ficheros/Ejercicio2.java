package com.example.dm2.ficheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio2 extends AppCompatActivity {

    private Spinner provincias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        provincias = (Spinner) findViewById(R.id.provincias);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item);


        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.provincias);

            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String str = brin.readLine();
            int cont=0;
            while(str!=null)
            {
                adapter.insert(str,cont);
                str = brin.readLine();

                cont++;
            }

            brin.close();
            fraw.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincias.setAdapter(adapter);
    }
}
