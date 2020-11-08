package com.happ.happ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.happ.happ.ui.light.LightFragment;

public class LightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LightFragment.newInstance())
                    .commitNow();
        }
    }
}