package br.com.ufpb.pmi.learningtruetable.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import br.com.ufpb.pmi.learningtruetable.LearningTTApplication;
import br.com.ufpb.pmi.learningtruetable.R;
import br.com.ufpb.pmi.learningtruetable.model.Exercicio;

public class PraticasActivity extends AppCompatActivity {

    private LearningTTApplication ttapplication;

    private Exercicio exercicio;
    private Toolbar mToolbar;

    private TextView mTitle;
    private ImageView mImageExercice;
    private TextView mFormula;
    private Button mSubmeter;

    private TextView m3;
    private EditText m3_1;
    private EditText m3_2;
    private EditText m3_3;
    private EditText m3_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticas);

        ttapplication = (LearningTTApplication) getApplicationContext();

        mToolbar = (Toolbar) findViewById(R.id.toolbar_praticas);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int idx = getIntent().getExtras().getInt("idx");
        exercicio = ttapplication.getExercicio().get(idx);

        m3_1 = (EditText) findViewById(R.id.editColun3_1);
        m3_2 = (EditText) findViewById(R.id.editColun3_2);
        m3_3 = (EditText) findViewById(R.id.editColun3_3);
        m3_4 = (EditText) findViewById(R.id.editColun3_4);

        mTitle = (TextView) findViewById(R.id.title_P);
        mTitle.setText(exercicio.getTipoConteudo());

        mImageExercice = (ImageView) findViewById(R.id.image_praticle);
        if(exercicio.getIdDrawable() == 0){
            mImageExercice.setVisibility(View.INVISIBLE);
        }else{
            mImageExercice.setVisibility(View.VISIBLE);
            mImageExercice.setImageDrawable(getResources().getDrawable(exercicio.getIdDrawable()));
        }

        m3 = (TextView) findViewById(R.id.TextColun3);
        m3.setText(exercicio.getFormula());

        mFormula = (TextView)findViewById(R.id.formula);
        mFormula.setText(exercicio.getFormula());

        mSubmeter = (Button) findViewById(R.id.btn_submeter);
        mSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submeter();
            }
        });

    }

    private void submeter() {

        m3_1.setError(null);
        m3_2.setError(null);
        m3_3.setError(null);
        m3_4.setError(null);


        String v3_1 = m3_1.getText().toString();
        String v3_2 = m3_2.getText().toString();
        String v3_3 = m3_3.getText().toString();
        String v3_4 = m3_4.getText().toString();

        View focus = null;
        boolean cancel = false;

        if (TextUtils.isEmpty(v3_1)) {
            m3_1.setError("Campo vazio");
            focus = m3_1;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_2)) {
            m3_2.setError("Campo vazio");
            focus = m3_2;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_3)) {
            m3_3.setError("Campo vaziio");
            focus = m3_3;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_4)) {
            m3_4.setError("Campo vaziio");
            focus = m3_4;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_1)) {
            m3_1.setError("Campo vazio");
            focus = m3_1;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_2)) {
            m3_2.setError("Campo vazio");
            focus = m3_2;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_3)) {
            m3_3.setError("Campo vaziio");
            focus = m3_3;
            cancel = true;

        }

        if (TextUtils.isEmpty(v3_4)) {
            m3_4.setError("Campo vaziio");
            focus = m3_4;
            cancel = true;

        }

        if (!v3_1.equals("0") && !v3_1.equals("1")) {
            m3_1.setError("Informe 0 ou 1");
            focus = m3_1;
            cancel = true;

        }


        if (cancel) {
            focus.requestFocus();
        } else {
            if (mTitle.getText().toString().equalsIgnoreCase("AND")) {
                if (compararAnd()) {
                    Toast.makeText(PraticasActivity.this, "Você acertou!", Toast.LENGTH_SHORT).show();
                    exercicio.setTerminate(true);
                    Intent intent = new Intent(this,ListaExercicioActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(PraticasActivity.this, "Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
            if (mTitle.getText().toString().equalsIgnoreCase("OR")) {
                if (compararOr()) {
                    Toast.makeText(PraticasActivity.this, "Você acertou", Toast.LENGTH_SHORT).show();
                    exercicio.setTerminate(true);
                    Intent intent = new Intent(this, ListaExercicioActivity.class);
                    startActivity(intent);
                }
            }



        }
    }

    private boolean compararAnd() {
        if (m3_1.getText().toString().equalsIgnoreCase("0") &&
        (m3_2.getText().toString().equalsIgnoreCase("0")) &&
                (m3_3.getText().toString().equalsIgnoreCase("0")&&
                        (m3_4.getText().toString().equalsIgnoreCase("1")))){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean compararOr(){
        if (m3_1.getText().toString().equalsIgnoreCase("0") &&
                (m3_2.getText().toString().equalsIgnoreCase("1")) &&
                (m3_3.getText().toString().equalsIgnoreCase("1")&&
                        (m3_4.getText().toString().equalsIgnoreCase("1")))){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pratica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_dicas) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_dialog)
                    .setMessage(exercicio.getDica())
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .create().show();
        }else if(id == android.R.id.home){
            Intent intent = new Intent(PraticasActivity.this, ListaExercicioActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
