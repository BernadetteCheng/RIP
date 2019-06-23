package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class History extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(History.this, MainActivity.class);
                    startActivity(intent);
                    mTextMessage.setText(R.string.title_transactions);
                    break;
                case R.id.navigation_dashboard:
                    Intent intent2 = new Intent(History.this, Stats.class);
                    startActivity(intent2);
                    mTextMessage.setText(R.string.title_stats);
                    break;
                case R.id.navigation_notification:
                    mTextMessage.setText(R.string.title_history);
                    break;
            }
            return false;
        }
    };
}
