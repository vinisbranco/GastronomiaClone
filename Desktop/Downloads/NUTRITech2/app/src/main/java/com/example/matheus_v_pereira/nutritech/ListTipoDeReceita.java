package com.example.matheus_v_pereira.nutritech;

import java.util.ArrayList;

/**
 * Created by acer pc on 29/09/2017.
 */

public class ListTipoDeReceita{
    private ArrayList<TipoDeReceita> tipos;

    public ListTipoDeReceita(){
        tipos = new ArrayList<>();
    }

    public ArrayList<TipoDeReceita> todosTipos(){
        return tipos;
    }
    public void addTipo(TipoDeReceita tipo){
        tipos.add(tipo);
    }
}
