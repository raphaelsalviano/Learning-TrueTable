package br.com.ufpb.pmi.learningtruetable.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class RobotoBoldTypeface extends TextView {

    public static final String TAG = "RobotoTextView";

    public RobotoBoldTypeface(Context context) {
        super(context);
        alterarFonte(context);
    }

    public RobotoBoldTypeface(Context context, AttributeSet attrs) {
        super(context, attrs);
        alterarFonte(context);
    }

    public RobotoBoldTypeface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        alterarFonte(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RobotoBoldTypeface(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        alterarFonte(context);
    }

    private void alterarFonte(Context context){
        if(!isInEditMode()){ //Se nao estiver em modo de edicao
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_bold.ttf");
            setTypeface(typeface);
        }
    }
}
