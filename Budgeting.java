package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Budgeting extends AppCompatActivity{
    private Button backBut;
    int one,two,three,four,tot;
    double a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgeting);
        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();



        pieData.add(new SliceValue(15, Color.parseColor("#7fb663")).setLabel("Food"));
        pieData.add(new SliceValue(25, Color.parseColor("#03bfc1")).setLabel("Electronics"));
        pieData.add(new SliceValue(10, Color.parseColor("#a8e5b9")).setLabel("Clinical"));
        pieData.add(new SliceValue(60, Color.parseColor("#e3f467")).setLabel("Stationary"));

        PieChartData pieChartData = new PieChartData(pieData);

        pieChartData.setHasLabels(true);
        pieChartData.setHasLabels(true).setValueLabelTextSize(18);
        pieChartView.setPieChartData(pieChartData);
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
