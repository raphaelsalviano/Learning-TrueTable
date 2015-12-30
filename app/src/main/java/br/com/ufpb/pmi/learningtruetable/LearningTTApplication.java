package br.com.ufpb.pmi.learningtruetable;

import android.app.Application;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import br.com.ufpb.pmi.learningtruetable.model.Exercicio;
import br.com.ufpb.pmi.learningtruetable.model.Jogador;
import br.com.ufpb.pmi.learningtruetable.model.NovoExercicio;

public class LearningTTApplication extends Application {

    private List<Exercicio> exercicios;

    private Jogador jogador;

    @Override
    public void onCreate() {
        super.onCreate();
        NovoExercicio novoExercicio = new NovoExercicio();
        exercicios = novoExercicio.getExercicios();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public List<Exercicio> getExercicio(){
        return exercicios;
    }
}
