package com.example.matheus_v_pereira.nutritech;
import java.util.ArrayList;

/**
 * Created by acer pc on 29/09/2017.
 */

public class ListProf{

    private ArrayList<Professor> professores;

    public ListProf(){
        professores = new ArrayList<>();
    }

    public ArrayList<Professor> todosProfessores(){
        return professores;
    }
    public void addProf(Professor prof){
        professores.add(prof);
    }
}
