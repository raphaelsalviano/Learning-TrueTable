package br.com.ufpb.pmi.learningtruetable.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class JamoerRoughTypeface extends TextView {

    public static final String TAG = "JamoerRoughTypeface";

    public JamoerRoughTypeface(Context context) {
        super(context);
        alterarFonte(context);
    }

    public JamoerRoughTypeface(Context context, AttributeSet attrs) {
        super(context, attrs);
        alterarFonte(context);
    }

    public JamoerRoughTypeface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        alterarFonte(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public JamoerRoughTypeface(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        alterarFonte(context);
    }

    private void alterarFonte(Context context){
        if(!isInEditMode()){ //Se nao estiver em modo de edicao
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/jamoer_rough.ttf");
            setTypeface(typeface);
        }
    }
}
