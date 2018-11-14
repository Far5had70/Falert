package com.waspar.falert;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import static android.support.v4.util.Preconditions.checkNotNull;

@SuppressLint("ValidFragment")
public class Falert extends DialogFragment implements View.OnClickListener {

    private Context context;
    private int buttonType;
    private View roottt , view;
    private TextView positiveSingleButton, negativeButton, positiveButton;
    private FrameLayout frameLayout;

    private GradientDrawable positiveButtonBackground;
    private GradientDrawable negativeButtonBackground;
    private GradientDrawable positiveSingleButtonBackground;
    private SingleButtonListener singleButtonListener;
    private TwoButtonListener twoButtonListener;
    private boolean autoDismiss = true;
    private String positiveText = null;
    private String negativeText = null;
    private FragmentManager fragmentManager;
    private int alertRadius = 40;
    private View customView;

    public Falert(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_falert, container, false);
        show();
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return view;
    }

    public Falert setButtonType(int buttonType) {
        this.buttonType = buttonType;
        return this;
    }

    public Falert setPositiveButtonBackground(GradientDrawable positiveButtonBackground) {
        this.positiveButtonBackground = positiveButtonBackground;
        return this;
    }

    public Falert setNegativeButtonBackground(GradientDrawable negativeButtonBackground) {
        this.negativeButtonBackground = negativeButtonBackground;
        return this;
    }

    public Falert setPositiveSingleButtonBackground(GradientDrawable positiveSingleButtonBackground) {
        this.positiveSingleButtonBackground = positiveSingleButtonBackground;
        return this;
    }

    public Falert setSingleButtonListener(SingleButtonListener singleButtonListener) {
        this.singleButtonListener = singleButtonListener;
        return this;
    }

    public Falert setTwoButtonListener(TwoButtonListener twoButtonListener) {
        this.twoButtonListener = twoButtonListener;
        return this;
    }

    public Falert setAutoDismiss(boolean autoDismiss) {
        this.autoDismiss = autoDismiss;
        return this;
    }

    public Falert setPositiveText(String positiveText) {
        this.positiveText = positiveText;
        return this;
    }

    public Falert setNegativeText(String negativeText) {
        this.negativeText = negativeText;
        return this;
    }

    public Falert setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        return this;
    }

    public Falert setAlertRadius(int alertRadius) {
        this.alertRadius = alertRadius;
        return this;
    }

    public Falert customView(View customView) {
        this.customView = customView;
        return this;
    }


    public Falert show() {

        //View v = View.inflate(this.context, R.layout.layout_falert, (ViewGroup)null);
        init();

        if (customView != null){
            actionSetCustomView();
        }

        if (buttonType == 1){
            actionSingleButtun();
        }else {
            actionTwoButtun();
        }

        return this;
    }

    private void actionSetCustomView() {
        frameLayout.addView(customView);
    }

    private void init() {
        if (view == null){
            view = View.inflate(this.context, R.layout.layout_falert, (ViewGroup)null);
        }
        roottt = view.findViewById(R.id.root);
        positiveSingleButton = view.findViewById(R.id.falert_single_button);
        negativeButton = view.findViewById(R.id.falert_negative_button);
        positiveButton = view.findViewById(R.id.falert_positive_button);
        frameLayout = view.findViewById(R.id.frameLayoutFalert);
    }

    private void actionSingleButtun() {
        negativeButton.setVisibility(View.GONE);
        positiveButton.setVisibility(View.GONE);
        positiveSingleButton.setVisibility(View.VISIBLE);

        positiveSingleButton.setOnClickListener(this);

        if (positiveSingleButtonBackground == null){
            positiveSingleButtonBackground = new GradientDrawable();
            positiveSingleButtonBackground.setShape(GradientDrawable.RECTANGLE);
            positiveSingleButtonBackground.setColor(context.getResources().getColor(R.color.falert_green));
            positiveSingleButtonBackground.setCornerRadius(80);
        }
        positiveSingleButton.setBackground(positiveSingleButtonBackground);
    }

    private void actionTwoButtun() {
        negativeButton.setVisibility(View.VISIBLE);
        positiveButton.setVisibility(View.VISIBLE);
        positiveSingleButton.setVisibility(View.GONE);

        negativeButton.setOnClickListener(this);
        positiveButton.setOnClickListener(this);

        if (positiveText != null){
            positiveButton.setText(positiveText);
        }

        if (negativeText != null){
            negativeButton.setText(negativeText);
        }


        if (negativeButtonBackground == null){
            negativeButtonBackground = new GradientDrawable();
            negativeButtonBackground.setShape(GradientDrawable.RECTANGLE);
            negativeButtonBackground.setColor(context.getResources().getColor(R.color.falert_red));
            negativeButtonBackground.setCornerRadius(80);
        }
        negativeButton.setBackground(negativeButtonBackground);


        if (positiveButtonBackground == null){
            positiveButtonBackground = new GradientDrawable();
            positiveButtonBackground.setShape(GradientDrawable.RECTANGLE);
            positiveButtonBackground.setColor(context.getResources().getColor(R.color.falert_green));
            positiveButtonBackground.setCornerRadius(80);
        }
        positiveButton.setBackground(positiveButtonBackground);
    }

    public void dismissAlert(){
        dismiss();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.falert_negative_button) {
            twoButtonListener.onClickNegative();
            if (autoDismiss){
                dismiss();
            }

        } else if (i == R.id.falert_positive_button) {
            twoButtonListener.onClickPositive();
            if (autoDismiss){
                dismiss();
            }
        } else if (i == R.id.falert_single_button) {
            singleButtonListener.onClick();
            if (autoDismiss){
                dismiss();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT - 1;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        GradientDrawable bgShape = new GradientDrawable();

        bgShape.setCornerRadius(alertRadius);
        bgShape.setColor(getActivity().getResources().getColor(R.color.falert_white));
        roottt.setBackground(bgShape);
    }

    @SuppressLint("RestrictedApi")
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId, boolean replace) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        //transaction.setCustomAnimations( R.anim.enter_from_right, 0, 0, R.anim.exit_to_left);

        if (replace) {
            transaction.replace(frameId, fragment);
        } else {
            transaction.add(frameId, fragment);
        }
        transaction.addToBackStack(fragment.toString());
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

}
