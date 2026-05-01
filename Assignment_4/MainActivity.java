package com.example.newsapp;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button btnNews1, btnNews2, btnNews3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNews1 = findViewById(R.id.btnNews1);
        btnNews2 = findViewById(R.id.btnNews2);
        btnNews3 = findViewById(R.id.btnNews3);

        btnNews1.setOnClickListener(v ->
                loadFragment("AI is growing fast",
                        "Artificial Intelligence is expanding rapidly across industries.")
        );

        btnNews2.setOnClickListener(v ->
                loadFragment("Technology Trends 2025",
                        "New technologies like AI, IoT, and Blockchain are trending.")
        );

        btnNews3.setOnClickListener(v ->
                loadFragment("Space Research Updates",
                        "Scientists are making new discoveries in space exploration.")
        );
    }

    // Method to load fragment
    private void loadFragment(String title, String description) {

        Fragment fragment = new NewsDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("desc", description);

        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}