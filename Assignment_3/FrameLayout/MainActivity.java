package com.example.framelayoutapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    View loadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingLayout = findViewById(R.id.loadingLayout);

        // Show loading for 3 seconds
        new Handler().postDelayed(() -> {
            loadingLayout.setVisibility(View.GONE);
        }, 3000);
    }
}