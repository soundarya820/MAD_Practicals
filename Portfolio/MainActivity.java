package com.example.portfolioapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvAbout, tvCollege, tvBranch, tvPercentage, tvContact, tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvAbout = findViewById(R.id.tvAbout);
        tvCollege = findViewById(R.id.tvCollege);
        tvBranch = findViewById(R.id.tvBranch);
        tvPercentage = findViewById(R.id.tvPercentage);
        tvContact = findViewById(R.id.tvContact);
        tvAddress = findViewById(R.id.tvAddress);

        tvName.setText("Soundarya Rukade");

        tvAbout.setText("I am a passionate Computer Science student aspiring to become a Software Developer. I enjoy learning new technologies, solving problems, and building real-world applications that create impact.");

        tvCollege.setText("D. Y. Patil College of Engineering and Technology, Kolhapur");
        tvBranch.setText("Computer Science and Engineering");
        tvPercentage.setText("80%");
        tvContact.setText("6439826518");
        tvAddress.setText("Miraj, Sangali");
    }
}