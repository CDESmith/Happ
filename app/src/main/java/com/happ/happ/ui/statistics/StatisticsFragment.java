package com.happ.happ.ui.statistics;

import androidx.lifecycle.ViewModelProviders;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.happ.happ.R;

public class StatisticsFragment extends Fragment {

    private StatisticsViewModel mViewModel;
    Button playButton;
    MediaPlayer mediaPlayer;

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.statistics_fragment, container, false);


        playButton = root.findViewById(R.id.playButton);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.energy_audio);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Button pressed", Toast.LENGTH_LONG).show();
                mediaPlayer.start();
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StatisticsViewModel.class);
        // TODO: Use the ViewModel
    }

}