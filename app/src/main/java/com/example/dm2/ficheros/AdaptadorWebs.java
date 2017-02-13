package com.example.dm2.ficheros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorWebs extends ArrayAdapter<MisWebs>
{
    private ArrayList<MisWebs> list;
    private ArrayList<Integer> imagenes;

    public AdaptadorWebs(Context context, ArrayList<MisWebs> list, ArrayList<Integer> imagenes)
    {
        super(context,R.layout.listitem_webs,list);
        this.list=list;
        this.imagenes=imagenes;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item=inflater.inflate(R.layout.listitem_webs,null);

        TextView lbltext=(TextView)item.findViewById(R.id.nombre);
        lbltext.setText(list.get(position).getNombre());

        TextView lblurl=(TextView)item.findViewById(R.id.url);
        lblurl.setText(list.get(position).getUrl());

        TextView lblid=(TextView)item.findViewById(R.id.identificador);
        lblid.setText(list.get(position).getId());


        ImageView imgImg = (ImageView) item.findViewById(R.id.imagen);
        imgImg.setImageResource(imagenes.get(position).intValue());

        return item;
    }

}
