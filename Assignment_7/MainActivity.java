package com.example.exp7;

import android.os.Bundle;
import android.os.Handler;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ProgressBar progressBar;
    Button btnSubmit;
    TextView tvResult;

    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        // Rating change event
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Toast.makeText(MainActivity.this,
                    "Selected Rating: " + rating,
                    Toast.LENGTH_SHORT).show();
        });

        // Button click event
        btnSubmit.setOnClickListener(v -> {

            progressStatus = 0;
            progressBar.setProgress(0);

            new Thread(() -> {
                while (progressStatus < 100) {
                    progressStatus += 10;

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(() -> progressBar.setProgress(progressStatus));
                }

                handler.post(() -> {
                    float rating = ratingBar.getRating();
                    String message;

                    if (rating == 5) {
                        message = "Excellent! 😍";
                    } else if (rating >= 3) {
                        message = "Good 🙂";
                    } else {
                        message = "Needs Improvement 😐";
                    }

                    tvResult.setText("Rating: " + rating + "\n" + message);
                });

            }).start();
        });
    }
}