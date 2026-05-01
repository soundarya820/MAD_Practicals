package com.example.menuapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    // Create Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle Menu Click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_pizza) {
            imageView.setImageResource(R.drawable.pizza);
            Toast.makeText(this, "You selected Pizza", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_burger) {
            imageView.setImageResource(R.drawable.burger);
            Toast.makeText(this, "You selected Burger", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_sandwich) {
            imageView.setImageResource(R.drawable.sandwich);
            Toast.makeText(this, "You selected Sandwich", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}