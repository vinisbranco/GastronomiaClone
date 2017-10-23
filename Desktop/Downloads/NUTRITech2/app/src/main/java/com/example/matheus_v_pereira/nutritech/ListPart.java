package com.example.matheus_v_pereira.nutritech;
import java.util.ArrayList;

/**
 * Created by acer pc on 29/09/2017.
 */

public class ListPart{
    private ArrayList<Participante> participantes;

    public ListPart() {
        participantes = new ArrayList<>();
    }

    public void addParticipante(Participante part) {
        participantes.add(part);
    }


    public ArrayList<Participante> todosParticipantes() {
        return participantes;
    }

}
