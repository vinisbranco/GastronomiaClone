package com.example.matheus_v_pereira.nutritech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class IngredienteListAdapter extends ArrayAdapter<Ingrediente> {
    private Context context;
    private List<Ingrediente> ingredientes;

    public IngredienteListAdapter(Context context, List<Ingrediente> ingredientes) {
        super(context, 0, ingredientes);
        this.ingredientes = ingredientes;
        this.context = context;
    }

    public List<Ingrediente> getArray() {
        return ingredientes;
    }


    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        final Ingrediente ingrediente = ingredientes.get(position);

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.ingrediente_lista_ingredientes, null);

        TextView textViewNome = (TextView) view.findViewById(R.id.text_view_nome_ingrediente);
        String textoNome = String.valueOf(ingrediente.getNome());
        textViewNome.setText(textoNome);

        View buttonViewEdit = view.findViewById(R.id.editButton);
        View buttonRemove =  view.findViewById(R.id.removeButton);

       final IngredienteListAdapter batata = this;

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientes.remove(position);
                batata.notifyDataSetChanged();
            }
        });


        return view;
    }
}