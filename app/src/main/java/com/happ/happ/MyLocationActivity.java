package com.happ.happ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.happ.happ.ui.mylocation.MyLocationFragment;

public class MyLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_location_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MyLocationFragment.newInstance())
                    .commitNow();
        }
    }
}