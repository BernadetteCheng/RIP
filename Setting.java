package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {
    private Button backBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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