package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openHome();
                    return true;
                case R.id.navigation_dashboard:
                    openBudgeting();
                    return true;
                case R.id.navigation_notifications:
                    openSettings();
                    return true;
            }
            return false;
        }
    };
    public void openBudgeting() {
        Intent intent = new Intent(this, Budgeting.class);
        startActivity(intent);
    }
    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openSettings() {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FloatingActionButton fb = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Pop.class);
                startActivity(i);
            }
        });
    }


}
