package com.example.matheus_v_pereira.nutritech;


/**
 * Created by acer pc on 29/09/2017.
 */

public class Atributo {
    private String nome;
    private int quantidade;

    public Atributo(String nome, int quantidade){
        this.nome=nome;
        this.quantidade=quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return nome + " "+ "Quantidade em gramas: " +quantidade;
    }
}
