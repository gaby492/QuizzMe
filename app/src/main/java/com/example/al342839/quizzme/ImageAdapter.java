package com.example.al342839.quizzme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Anairene on 21/09/2016.
 */
public class ImageAdapter extends ArrayAdapter<String> {
    public ImageAdapter(Context context, int categoria_layout, String[] categorias) {
        super(context, categoria_layout, categorias);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());

        View costumView = myInflater.inflate(R.layout.categoria_layout, parent, false);

        TextView myTextView = (TextView)costumView.findViewById(R.id.categoriaTextView);

        String item = getItem(position).toString();
        myTextView.setText(item);
        return costumView;
    }

}
