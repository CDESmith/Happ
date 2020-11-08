package com.happ.happ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.happ.happ.ui.testfragmenttest.TestFragment_Test;

public class TestFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_frag);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TestFragment_Test.newInstance())
                    .commitNow();
        }
    }
}