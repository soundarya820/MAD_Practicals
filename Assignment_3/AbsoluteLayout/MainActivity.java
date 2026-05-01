package com.example.absoluteapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {

            // Show Toast
            Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();

            // Change button text
            btnAdd.setText("ADDED");

            // Disable button
            btnAdd.setEnabled(false);
        });
    }
}