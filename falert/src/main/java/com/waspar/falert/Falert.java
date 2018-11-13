package com.waspar.falert;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class Falert extends FrameLayout {


    public Falert(@NonNull Context context) {
        super(context);
        initView();
    }

    public Falert(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context , attrs);
    }

    public Falert(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {
        View view = inflate(getContext(), R.layout.layout_falert, null);
        addView(view);
    }



    private void initView(@NonNull Context context, @Nullable AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.layout_falert, null);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Falert, 0, 0);

        try {


        } finally {
            ta.recycle();
        }
        addView(view);
    }

}
