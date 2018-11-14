package com.shaygan.customalert;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.waspar.falert.Falert;
import com.waspar.falert.FalertButtonType;
import com.waspar.falert.SingleButtonListener;
import com.waspar.falert.TwoButtonListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflaterr.inflate(R.layout.custom_view, null, false);

        Falert falert = new Falert(this)
                .setButtonType(FalertButtonType.ONE_BUTTON)
                .customView(customView)
                .setAutoDismiss(true)
                .setPositiveText("صحیح")
                .setNegativeText("غلط")
                .setAlertRadius(40)
                .setSingleButtonListener(new SingleButtonListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                    }
                });
        falert.show(getSupportFragmentManager() , "");


    }


}
