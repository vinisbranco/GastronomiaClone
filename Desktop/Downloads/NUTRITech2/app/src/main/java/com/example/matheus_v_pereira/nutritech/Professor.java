package com.example.matheus_v_pereira.nutritech;

import java.util.ArrayList;

/**
 * Created by acer pc on 29/09/2017.
 */

public class Professor {

    private String nome;
    private int id;
    private ArrayList<String> aulas;

    public Professor(String nome, int id){
        this.nome=nome;
        this.id=id;
    }

    public String toString(){
        return nome;
    }
}
