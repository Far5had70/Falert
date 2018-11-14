package com.shaygan.customalert;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.waspar.falert.Falert;
import com.waspar.falert.FalertButtonType;
import com.waspar.falert.SingleButtonListener;
import com.waspar.falert.DoubleButtonListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
    }

    private void initButton() {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                singleAction();
                break;
            case R.id.button2:
                doubleAction();
                break;
        }
    }

    private void doubleAction() {
        LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflaterr.inflate(R.layout.custom_view, null, false);

        Falert falert = new Falert(this)
                .setButtonType(FalertButtonType.Double_BUTTON)
                .customView(customView)
                .setAutoDismiss(true)
                .setPositiveText("مشاهده")
                .setNegativeText("حذف")
                .setPositiveButtonBackground(getResources().getColor(R.color.falert_green))
                .setNegativeButtonBackground(getResources().getColor(R.color.falert_red))
                .setButtonTextColor(getResources().getColor(R.color.falert_white))
                .setHeaderIcon(getResources().getDrawable(R.drawable.profile))
                .setAlertRadius(40)
                .setButtonRadius(80)
                .setButtonTextSize(13)
                .setHeaderIconEnable(true)
                .setButtonEnable(true)
                .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf"))
                .setDoubleButtonListener(new DoubleButtonListener() {
                    @Override
                    public void onClickPositive() {
                        Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickNegative() {
                        Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                    }
                });
        falert.show(getSupportFragmentManager() , "");
    }

    private void singleAction() {
        LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflaterr.inflate(R.layout.custom_view, null, false);

        Falert falert = new Falert(this)
                .setButtonType(FalertButtonType.ONE_BUTTON)
                .customView(customView)
                .setAutoDismiss(true)
                .setSingleButtonBackground(getResources().getColor(R.color.falert_green))
                .setButtonTextColor(getResources().getColor(R.color.falert_white))
                .setPositiveText("تایید")
                .setHeaderIcon(getResources().getDrawable(R.drawable.profile))
                .setAlertRadius(40)
                .setButtonRadius(80)
                .setButtonTextSize(13)
                .setHeaderIconEnable(true)
                .setButtonEnable(true)
                .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf"))
                .setSingleButtonListener(new SingleButtonListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                    }
                });
        falert.show(getSupportFragmentManager() , "");
    }
}
