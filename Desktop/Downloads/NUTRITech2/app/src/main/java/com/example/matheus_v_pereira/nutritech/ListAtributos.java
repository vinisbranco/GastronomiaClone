package com.example.matheus_v_pereira.nutritech;

import java.util.ArrayList;

/**
 * Created by acer pc on 16/10/2017.
 */

public class ListAtributos {
    private ArrayList<Atributo> atributos;

    public ListAtributos(){
        atributos = new ArrayList<>();
    }

    public void add(Atributo ingrediente){
        atributos.add(ingrediente);
    }

    public ArrayList<Atributo> todosAtributos(){
        return atributos;
    }

}
