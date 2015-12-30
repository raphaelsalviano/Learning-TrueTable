package br.com.ufpb.pmi.learningtruetable.custom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import br.com.ufpb.pmi.learningtruetable.R;
import br.com.ufpb.pmi.learningtruetable.model.Exercicio;

public class ListaExercicioAdapter extends RecyclerView.Adapter<ListaExercicioAdapter.ListaExercicioViewHolder> {

    private final List<Exercicio> exercicios;
    private final Context context;
    private final ListaExercicioOnClickListener onClickListener;

    public ListaExercicioAdapter(List<Exercicio> exercicios, Context context, ListaExercicioOnClickListener onClickListener) {
        this.exercicios = exercicios;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public interface ListaExercicioOnClickListener {
        public void onClickLista(View view, int idx);
    }

    @Override
    public ListaExercicioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list_exercicio, parent, false);
        return new ListaExercicioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListaExercicioViewHolder holder, final int position) {

        final Exercicio exercicio = exercicios.get(position);

        if (exercicio.isTerminate()) {
            holder.mCheckBox.setVisibility(View.VISIBLE);
            holder.mCheckBox.setChecked(true);
        } else {
            holder.mCheckBox.setChecked(false);
            holder.mCheckBox.setVisibility(View.GONE);
        }

        holder.mText.setText(exercicio.getTag());

        if(onClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickLista(holder.itemView, position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return this.exercicios != null ? this.exercicios.size() : 0;
    }

    public class ListaExercicioViewHolder extends RecyclerView.ViewHolder {

        private TextView mText;
        private CheckBox mCheckBox;

        public ListaExercicioViewHolder(View itemView) {
            super(itemView);

            mText = (TextView) itemView.findViewById(R.id.textNameExercicio);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }

    }
}
