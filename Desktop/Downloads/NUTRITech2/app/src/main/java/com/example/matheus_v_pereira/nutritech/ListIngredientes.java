package com.example.matheus_v_pereira.nutritech;

import java.util.ArrayList;

/**
 * Created by acer pc on 29/09/2017.
 */

public class ListIngredientes {
    private ArrayList<Ingrediente> ingredientes;

    public ListIngredientes(){
        ingredientes = new ArrayList<>();
    }

    public void addIngrediente(Ingrediente ingrediente){
        ingredientes.add(ingrediente);
    }

    public ArrayList<Ingrediente> todosIngredientes(){
        return ingredientes;
    }

}
