package br.com.ufpb.pmi.learningtruetable.view;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.pmi.learningtruetable.LearningTTApplication;
import br.com.ufpb.pmi.learningtruetable.R;
import br.com.ufpb.pmi.learningtruetable.custom.ListaExercicioAdapter;
import br.com.ufpb.pmi.learningtruetable.model.Exercicio;

public class ListaExercicioActivity extends AppCompatActivity {

    private LearningTTApplication application;

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;

    private ListaExercicioAdapter adapter;

    private Button mButtonAnd;
    private Button mButtonNot;
    private Button mButtonOr;
    private Button mButtonAll;

    private List<Exercicio> exercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_exercicio);

        application = ((LearningTTApplication) getApplicationContext());
        exercicios = application.getExercicio().size() > 0 ? application.getExercicio() : new ArrayList<Exercicio>();

        mButtonAnd = (Button) findViewById(R.id.list_and);
        mButtonAnd.setOnClickListener(new OnClickListener("and"));

        mButtonNot = (Button) findViewById(R.id.list_not);
        mButtonNot.setOnClickListener(new OnClickListener("not"));

        mButtonOr = (Button) findViewById(R.id.list_or);
        mButtonOr.setOnClickListener(new OnClickListener("or"));

        mButtonAll = (Button) findViewById(R.id.list_all);
        mButtonAll.setOnClickListener(new OnClickListener("all"));

        mToolbar = (Toolbar) findViewById(R.id.toolbar_list_exercicios);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);


    }

    public ListaExercicioAdapter.ListaExercicioOnClickListener listOnClickListener() {
        return new ListaExercicioAdapter.ListaExercicioOnClickListener() {
            @Override
            public void onClickLista(View view, int idx) {
                Intent intent = new Intent(ListaExercicioActivity.this, PraticasActivity.class);
                intent.putExtra("idx", idx);
                startActivity(intent);
            }
        };
    }

    private class OnClickListener implements View.OnClickListener {

        private final String button;

        private OnClickListener(String button) {
            this.button = button;
        }

        private List<Exercicio> getExerciciosTipo(String tipo) {
            List<Exercicio> list = new ArrayList<>();
            for (Exercicio e : exercicios) {
                if (e.getTipoConteudo().equalsIgnoreCase(tipo)) {
                    list.add(e);
                }
            }
            return list;
        }

        @Override
        public void onClick(View v) {
            if (button.equalsIgnoreCase("and")) {
                adapter = new ListaExercicioAdapter(getExerciciosTipo(button), getBaseContext(), listOnClickListener());
            } else if (button.equalsIgnoreCase("not")) {
                adapter = new ListaExercicioAdapter(getExerciciosTipo(button), getBaseContext(), listOnClickListener());
            } else if (button.equalsIgnoreCase("or")) {
                adapter = new ListaExercicioAdapter(getExerciciosTipo(button), getBaseContext(), listOnClickListener());
            } else {
                adapter = new ListaExercicioAdapter(getExerciciosTipo(button), getBaseContext(), listOnClickListener());
            }
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_exercicios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(ListaExercicioActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
