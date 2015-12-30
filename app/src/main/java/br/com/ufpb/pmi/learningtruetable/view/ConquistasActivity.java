package br.com.ufpb.pmi.learningtruetable.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.rahatarmanahmed.cpv.CircularProgressView;

import br.com.ufpb.pmi.learningtruetable.LearningTTApplication;
import br.com.ufpb.pmi.learningtruetable.R;

public class ConquistasActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CircularProgressView progressView;

    private TextView mPontuacaoMax;
    private TextView mExerciciosConcluidos;
    private TextView mPorcentagem;

    private LearningTTApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conquistas);

        //application = ((LearningTTApplication) getApplicationContext());

        mToolbar = (Toolbar) findViewById(R.id.toolbar_conquistas);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressView = (CircularProgressView) findViewById(R.id.progress_view);
        progressView.setIndeterminate(false);
        mPontuacaoMax = (TextView) findViewById(R.id.pontuacao_max);
        mExerciciosConcluidos = (TextView) findViewById(R.id.cont_atividades);
        mPorcentagem = (TextView) findViewById(R.id.porcentagem_jogo);

        progressView.setMaxProgress(30);
        progressView.setColor(getResources().getColor(R.color.md_teal_500_75));
        progressView.setProgress(Float.parseFloat(mExerciciosConcluidos.getText().toString()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_conquistas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent(ConquistasActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
