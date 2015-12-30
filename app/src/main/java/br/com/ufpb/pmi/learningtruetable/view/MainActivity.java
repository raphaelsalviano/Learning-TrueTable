package br.com.ufpb.pmi.learningtruetable.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import br.com.ufpb.pmi.learningtruetable.R;

public class MainActivity extends AppCompatActivity {

    private ImageView mConquistas;
    private ImageView mSobre;
    private ImageView mConfiguracoes;

    private View mBunttonAprender;
    private View mButtonPraticar;
    private View mButtonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConquistas = (ImageView) findViewById(R.id.btn_pontuacao);
        mConquistas.setOnClickListener(new ClickListener(ConquistasActivity.class));

        mSobre = (ImageView) findViewById(R.id.btn_about);
        mSobre.setOnClickListener(new ClickListener(SobreActivity.class));

        mConfiguracoes = (ImageView) findViewById(R.id.btn_settings);
        mConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Em breve...", Snackbar.LENGTH_SHORT).show();
            }
        });

        mBunttonAprender = findViewById(R.id.btn_aprender);
       mBunttonAprender.setOnClickListener(new ClickListener(AprenderActivity.class));

        mButtonPraticar = findViewById(R.id.btn_exercicio);
        mButtonPraticar.setOnClickListener(new ClickListener(ListaExercicioActivity.class));

        mButtonSair = findViewById(R.id.btn_sair);
        mButtonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private class ClickListener implements View.OnClickListener{

        private final Class aClass;

        private ClickListener(Class aClass) {
            this.aClass = aClass;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, aClass);
            startActivity(intent);
        }
    }

}
