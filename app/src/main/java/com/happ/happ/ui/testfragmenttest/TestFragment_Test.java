package com.happ.happ.ui.testfragmenttest;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happ.happ.R;

public class TestFragment_Test extends Fragment {

    private TestFragmentTestViewModel mViewModel;

    public static TestFragment_Test newInstance() {
        return new TestFragment_Test();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_fragment__test, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TestFragmentTestViewModel.class);
        // TODO: Use the ViewModel
    }

}