package com.example.al342839.quizzme;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaby on 13/11/2016.
 */

public class CategoriaAdapter extends BaseAdapter {
    private Context context;
    private List<Categoria> ITEMS;
    MiBaseDeDatos MDB;

    public CategoriaAdapter(Context context) {
        this.context = context;
        MDB = new MiBaseDeDatos(context);
        ITEMS = new ArrayList<Categoria>();
        ITEMS= MDB.recuperarCATEGORIAS();
    }

    @Override
    public int getCount() {
        return ITEMS.size();
    }

    @Override
    public Categoria getItem(int position) {
        return ITEMS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.categoria_layout, viewGroup, false);
        }

        ImageView imagenCategoria = (ImageView) view.findViewById(R.id.imagen_categoria);
        TextView nombreCategoria = (TextView) view.findViewById(R.id.nombre_categoria);

        final Categoria item = getItem(position);

        imagenCategoria.setImageResource(item.getIdDrawable());
        nombreCategoria.setText(item.getNombre());
        Log.i("IDS", item.getIdDrawable() +"" );

        return view;
    }

}
