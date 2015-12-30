package br.com.ufpb.pmi.learningtruetable.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.ufpb.pmi.learningtruetable.R;

/**
 * Created by rapha on 17/12/2015.
 */
public class FragmentAnd extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_and,container,false);

        return view;
    }
}
