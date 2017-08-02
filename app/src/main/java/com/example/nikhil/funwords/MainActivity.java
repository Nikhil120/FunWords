package com.example.nikhil.funwords;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumble(View view){
        Intent intent = new Intent(this, JumbleWords.class);
        startActivity(intent);
    }

    public void incomplete(View view){
        Intent intent = new Intent(this, IncompleteWords.class);
        startActivity(intent);
    }
}
