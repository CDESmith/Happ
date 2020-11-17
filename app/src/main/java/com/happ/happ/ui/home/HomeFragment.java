package com.happ.happ.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;
import com.happ.happ.LightActivity;
import com.happ.happ.MainActivity;
import com.happ.happ.R;
import com.happ.happ.ui.heat.HeatFragment;
import com.happ.happ.ui.light.LightFragment;
import com.happ.happ.ui.mylocation.MyLocationFragment;
import com.happ.happ.ui.settings.SettingsFragment;
import com.happ.happ.ui.statistics.StatisticsFragment;
import com.happ.happ.ui.water.WaterFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    public String userName = "Happ-y User!";
    NavigationView navigationView;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView userWelcomeTV = root.findViewById(R.id.userWelcomeTV);
        Toolbar toolbar = root.findViewById(R.id.toolbar);
        ImageView lightsImageView = root.findViewById(R.id.imageViewLights);
        ImageView heatImageView = root.findViewById(R.id.imageViewHeat);
        ImageView waterImageView = root.findViewById(R.id.imageViewWater);
        ImageView statisticsImageView = root.findViewById(R.id.imageViewStatistics);
        ImageView myLocationImageView = root.findViewById(R.id.imageViewLocation);
        ImageView settingsImageView = root.findViewById(R.id.imageViewSettings);


        lightsImageView.setOnClickListener(this);
        heatImageView.setOnClickListener(this);
        waterImageView.setOnClickListener(this);
        statisticsImageView.setOnClickListener(this);
        myLocationImageView.setOnClickListener(this);
        settingsImageView.setOnClickListener(this);

        //set toolbar text to Home
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");


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


            FragmentTransaction transaction;



        switch (view.getId()) {

            //when light icon is clicked
            case R.id.imageViewLights:
                //display toast for testing purposes
                Toast.makeText(getContext(), "Lights Selected", Toast.LENGTH_LONG).show();

                //starts light fragment behind home fragment
                LightFragment lightFragment = LightFragment.newInstance();

                //change fragment to lights
                 transaction = getFragmentManager().beginTransaction();
                transaction.replace(this.getId(), lightFragment);
                transaction.commit();

                //set light as selected item
                ((MainActivity)getActivity()).setLightSelected(null);



                //set toolbar text
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Lights");
                break;





                //when heat icon is clicked
            case R.id.imageViewHeat:
                //display toast for testing purposes
                Toast.makeText(getContext(), "Heat Selected", Toast.LENGTH_LONG).show();

                //starts fragment behind home fragment
                HeatFragment heatFragment = HeatFragment.newInstance();

                //change fragment
                 transaction = getFragmentManager().beginTransaction();
                transaction.replace(this.getId(), heatFragment);
                transaction.commit();

                //set heat as selected item
                ((MainActivity)getActivity()).setHeatSelected(null);

                //set toolbar text
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Heating");
                 break;

                 //When water icon is clicked
            case R.id.imageViewWater:
                //display toast for testing purposes
                Toast.makeText(getContext(), "Water Selected", Toast.LENGTH_LONG).show();

                //starts fragment behind home fragment
                WaterFragment waterFragment = WaterFragment.newInstance();

                //change fragment
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(this.getId(), waterFragment);
                transaction.commit();

                //set water as selected item
                ((MainActivity)getActivity()).setWaterSelected(null);

                //set toolbar text
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Water");
                break;

                //when settings icon is clicked
            case R.id.imageViewSettings:
                //display toast for testing purposes
                Toast.makeText(getContext(), "Settings Selected", Toast.LENGTH_LONG).show();

                //starts fragment behind home fragment
                SettingsFragment settingsFragment = SettingsFragment.newInstance();

                //change fragment
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(this.getId(), settingsFragment);
                transaction.commit();

                //set settings as selected item
                ((MainActivity)getActivity()).setSettingsSelected(null);

                //set toolbar text
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Settings");
                break;

            //when location icon is clicked
            case R.id.imageViewLocation:
                //display toast for testing purposes
                Toast.makeText(getContext(), "Location Selected", Toast.LENGTH_LONG).show();

                //starts fragment behind home fragment
                MyLocationFragment locationFragment = MyLocationFragment.newInstance();

                //change fragment
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(this.getId(), locationFragment);
                transaction.commit();

                //set location as selected item
                ((MainActivity)getActivity()).setLocationSelected(null);

                //set toolbar text
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Location");
                break;

            //when location icon is clicked
            case R.id.imageViewStatistics:
                //display toast for testing purposes
                Toast.makeText(getContext(), "Statistics Selected", Toast.LENGTH_LONG).show();

                //starts fragment behind home fragment
                StatisticsFragment statisticsFragment = StatisticsFragment.newInstance();

                //change fragment
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(this.getId(), statisticsFragment);
                transaction.commit();

                //set statistics as selected item
                ((MainActivity)getActivity()).setStatisticsSelected(null);

                //set toolbar text
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Statistics");
                break;

            default:
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");
                break;
        }



    }


}