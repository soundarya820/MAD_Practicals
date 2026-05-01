package com.example.movieapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBook = findViewById(R.id.btnBook);

        btnBook.setOnClickListener(v ->
                Toast.makeText(this, "Booking Confirmed!", Toast.LENGTH_SHORT).show()
        );
    }
}