package com.example.matheus_v_pereira.nutritech;

import java.util.ArrayList;

/**
 * Created by acer pc on 29/09/2017.
 */

public class Ingrediente {
    private ArrayList<Atributo> atributos;
    private String nome;

    public Ingrediente(ArrayList<Atributo> atributos, String nome ){
        this.atributos=atributos;
        this.nome=nome;
    }

    public String toString(){
        return nome;
    }
    public String getNome(){
        return nome;
    }
}
