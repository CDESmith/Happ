package com.happ.happ;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.happ.happ.ui.home.HomeFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PERMISSION = 1;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    private AppBarConfiguration mAppBarConfiguration;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_test, R.id.nav_lights, R.id.nav_heat,
                R.id.nav_water, R.id.nav_settings, R.id.nav_mylocation, R.id.nav_statistics)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);;

        if(Build.VERSION.SDK_INT>= 23){
            if(checkSelfPermission(mPermission) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{mPermission, }, REQUEST_CODE_PERMISSION);
                return;
            }

        }
        else{

        }


    }

    public void setLightSelected(NavigationView navigationView){
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_lights);

    }

    public void setHeatSelected(NavigationView navigationView){
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_heat);

    }

    public void setWaterSelected(NavigationView navigationView){
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_water);

    }

    public void setSettingsSelected(NavigationView navigationView){
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_settings);

    }

    public void setLocationSelected(NavigationView navigationView){
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_mylocation);

    }

    public void setStatisticsSelected(NavigationView navigationView){
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_statistics);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}