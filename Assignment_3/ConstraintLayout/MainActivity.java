package com.example.musicplayer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    TextView tvStatus;

    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        tvStatus = findViewById(R.id.tvStatus);

        btnPlay.setOnClickListener(v -> {

            if (isPlaying) {
                tvStatus.setText("Paused");
                btnPlay.setText("▶");
            } else {
                tvStatus.setText("Playing");
                btnPlay.setText("⏸");
            }

            isPlaying = !isPlaying;
        });
    }
}