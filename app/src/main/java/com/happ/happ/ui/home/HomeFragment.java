package com.happ.happ.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.happ.happ.LightActivity;
import com.happ.happ.MainActivity;
import com.happ.happ.R;
import com.happ.happ.ui.light.LightFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    public String userName = "Happ-y User!";




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView userWelcomeTV = root.findViewById(R.id.userWelcomeTV);
        Toolbar toolbar = root.findViewById(R.id.toolbar);
        ImageView lightsImageView = root.findViewById(R.id.imageViewLights);

        lightsImageView.setOnClickListener(this);
        userWelcomeTV.setText("Welcome, " + userName);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;




    }

    @Override
    public void onClick(View view) {
        //display toast for testing purposes
        Toast.makeText(getContext(), "Lights Selected", Toast.LENGTH_LONG).show();

        //starts light fragment behind home fragment
        LightFragment lightFragment = LightFragment.newInstance();

        //change fragment to lights
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), lightFragment);
        transaction.commit();

        //set toolbar text
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Lights");




    }


}