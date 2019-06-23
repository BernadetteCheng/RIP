package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.IPieInfo;
import com.razerdp.widget.animatedpieview.data.PieOption;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class Budgeting extends AppCompatActivity{
    private Button backBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgeting);
        AnimatedPieView aniPie = findViewById(R.id.pieView);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.addData(new SimplePieInfo(2500, Color.parseColor("#7fb663"), "Food"));
        config.addData(new SimplePieInfo(3250, Color.parseColor("#03bfc1"), "Electronics"));
        config.addData(new SimplePieInfo(4500, Color.parseColor("#a8e5b9"), "Stationary"));
        config.addData(new SimplePieInfo(5250, Color.parseColor("#e3f467"), "Cleaning"));
        config.strokeMode(false);
        config.drawText(true);
        config.guideLineWidth(8);
        config.textSize(18);


        aniPie.applyConfig(config);
        aniPie.start();
        backBut = (Button) findViewById(R.id.button2);
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }
    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
