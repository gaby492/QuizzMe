package com.example.al342839.quizzme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gaby on 19/11/2016.
 */

public class ListaEncuestaCustomAdapter extends ArrayAdapter<Encuesta> {
    public ListaEncuestaCustomAdapter(Context context, int series_layout, List<Encuesta> encuestas){
        super(context, series_layout, encuestas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());

        View customView = myInflater.inflate(R.layout.encuestas, parent, false);

        TextView myTextView= (TextView)customView.findViewById(R.id.textView2);

        Encuesta item= (Encuesta) getItem(position);
        myTextView.setText(item.getEncuesta());
        return customView;
    }


}
