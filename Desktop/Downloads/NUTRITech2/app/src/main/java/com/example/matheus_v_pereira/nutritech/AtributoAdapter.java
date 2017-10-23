package com.example.matheus_v_pereira.nutritech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by acer pc on 16/10/2017.
 */

public class AtributoAdapter extends ArrayAdapter<Atributo> {
    private Context context;
    private List<Atributo> atributos;

    public AtributoAdapter(Context context, List<Atributo> atributos) {
        super(context, 0, atributos);
        this.atributos = atributos;
        this.context = context;
    }

    public List<Atributo> getArray() {
        return atributos;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        final Atributo atributo = atributos.get(position);

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_atributos, null);

        TextView textViewNome = (TextView) view.findViewById(R.id.text_nome_atributo);
        String textoNome = String.valueOf(atributo.getNome());
        textViewNome.setText(textoNome);

        //ListView atributocad = (ListView) view.findViewById((R.id.list_cadastroIngr));

        return view;
    }
}
