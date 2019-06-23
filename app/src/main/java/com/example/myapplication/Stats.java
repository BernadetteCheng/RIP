package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statspage);
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
    }

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(Stats.this, MainActivity.class);
                    startActivity(intent);
                    mTextMessage.setText(R.string.title_transactions);
                    break;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_stats);
                    break;
                case R.id.navigation_notification:
                    Intent intent3 = new Intent(Stats.this, History.class);
                    startActivity(intent3);
                    mTextMessage.setText(R.string.title_history);
                    break;
            }
            return false;
        }
    };
}
