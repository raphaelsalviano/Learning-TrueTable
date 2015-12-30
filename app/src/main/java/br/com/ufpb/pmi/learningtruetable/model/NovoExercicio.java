package br.com.ufpb.pmi.learningtruetable.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.pmi.learningtruetable.R;

public class NovoExercicio {

    List<Exercicio> exercicios = new ArrayList<>();

    /**
    public NovoExercicio() {
    }
*/
    public List<Exercicio> getExercicios(){
        exercicios.add(new Exercicio(false, "AND", "A ^ B", R.drawable.and));
        exercicios.add(new Exercicio(false, "OR", "A v B", R.drawable.or));
        return exercicios;
    }

}
