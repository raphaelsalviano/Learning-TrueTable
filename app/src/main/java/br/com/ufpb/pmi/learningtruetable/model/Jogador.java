package br.com.ufpb.pmi.learningtruetable.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "Jogador")
public class Jogador implements Serializable {

    @DatabaseField (generatedId = true)
    private long _id;
    @DatabaseField
    private int pontuacao;
    @DatabaseField
    private int quantExerciciosConcluidos;

    public Jogador(int pontuacao, int quantExerciciosConcluidos) {
        this._id = _id;
        this.pontuacao = pontuacao;
        this.quantExerciciosConcluidos = quantExerciciosConcluidos;
    }

    public Jogador() {
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQuantExerciciosConcluidos() {
        return quantExerciciosConcluidos;
    }

    public void setQuantExerciciosConcluidos(int quantExerciciosConcluidos) {
        this.quantExerciciosConcluidos = quantExerciciosConcluidos;
    }
}
