package com.example.matheus_v_pereira.nutritech;

/**
 * Created by acer pc on 16/10/2017.
 */

public class CadastraAtributo {
    private ListAtributos atributos;

    public CadastraAtributo(){
        //cria lista array
        atributos = new ListAtributos();
    }

    public void cadastrarAtributos(){

        //cria atributos
        Atributo prot = new Atributo("proteina",4);
        Atributo carb = new Atributo("carboidrato",4);
        Atributo gord = new Atributo("gordura",4);

        //adiciona atributos
        atributos.add(carb);
        atributos.add(gord);
        atributos.add(prot);
    }

    public ListAtributos getAtributos(){
        return atributos;
    }
}
