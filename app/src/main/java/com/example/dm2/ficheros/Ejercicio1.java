package com.example.dm2.ficheros;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejercicio1 extends AppCompatActivity {

    private EditText texto;
    private Button btnañadirint;
    private Button btnañadirext;
    private Button btnleerint;
    private Button btnleerext;
    private Button btnleerec;
    private Button btnborrarint;
    private Button btnborrarext;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        texto = (EditText) findViewById(R.id.texto);
        txt = (TextView) findViewById(R.id.txt);

        btnañadirint = (Button) findViewById(R.id.btnañadirint);
        btnañadirext = (Button) findViewById(R.id.btnañadirext);

        btnleerint = (Button) findViewById(R.id.btnleerint);
        btnleerext = (Button) findViewById(R.id.btnleerext);
        btnleerec = (Button) findViewById(R.id.btnleerec);

        btnborrarint = (Button) findViewById(R.id.btnborrarint);
        btnborrarext = (Button) findViewById(R.id.btnborrarext);
    }

    public void añadirint(View v)
    {
        try
        {
            OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("finterno.txt", Context.MODE_PRIVATE));

            fout.write(texto.getText().toString());
            fout.close();
            texto.setText("");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir en fichero de memoria interna");
        }
    }

    public void leerint(View v)
    {
        try
        {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("finterno.txt")));

            String str = fin.readLine();
            txt.setText(str);

            fin.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
    }

    public void borrarint(View v)
    {
        try
        {
            deleteFile("finterno.txt");
            txt.setText("");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al borrar fichero de memoria interna");
        }
    }

    public void añadirext (View v)
    {
        try
        {
            File ruta_sd = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File f = new File(ruta_sd.getAbsolutePath(),"fexterno.txt");

            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));

            fout.write(texto.getText().toString());
            fout.close();
            texto.setText("");
        }
        catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir en memoria externa");
        }
    }

    public void leerext(View v)
    {
        try
        {
            File ruta_sd = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File f = new File(ruta_sd.getAbsolutePath(), "fexterno.txt");

            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            String str = fin.readLine();
            txt.setText(str);
            fin.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde tarjeta SD");
        }
    }
    public void borrarext(View v)
    {
        File ruta_sd = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(ruta_sd.getAbsolutePath(), "fexterno.txt");

        f.delete();
        txt.setText("");
    }
    public void leerec(View v)
    {
        try
        {
            InputStream fraw = getResources().openRawResource(R.raw.recurso);

            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String str = brin.readLine();

            txt.setText(str);
            fraw.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }
    }
}
