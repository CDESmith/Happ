package com.happ.happ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.happ.happ.ui.heat.HeatFragment;

public class HeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heat_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HeatFragment.newInstance())
                    .commitNow();
        }
    }
}