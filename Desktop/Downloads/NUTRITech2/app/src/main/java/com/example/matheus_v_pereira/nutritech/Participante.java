package com.example.matheus_v_pereira.nutritech;

/**
 * Created by acer pc on 29/09/2017.
 */

public class Participante {
    private String nome;
    private int id;
    private int count;

    public Participante(String nome, int id){
        this.nome=nome;
        this.id=id;
        count++;
    }
    public int getCount(){
        return count;
    }
    public String toString(){
        return nome;
    }

}