package br.com.ufpb.pmi.learningtruetable.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable (tableName = "Exercicio")
public class Exercicio implements Serializable {

    private final String TAG = "Exercício";

    @DatabaseField
    private boolean terminate;
    @DatabaseField(generatedId = true)
    private long _id;
    @DatabaseField
    private String tipoConteudo;
    @DatabaseField
    private String formula;
    @DatabaseField
    private int idDrawable;
    @DatabaseField
    private String dica;

    public Exercicio(boolean terminate, String tipoConteudo, String formula, int idDrawable) {
        this.terminate = terminate;
        this.tipoConteudo = tipoConteudo;
        this.formula = formula;
        this.idDrawable = idDrawable;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public Exercicio() {
        this.terminate = false;
    }

    public Exercicio(long _id) {
        this._id = _id;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public String getTag() {
        return TAG + " " + _id;
    }

    public long getId() {
        return _id;
    }
}
