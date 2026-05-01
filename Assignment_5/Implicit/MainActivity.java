package com.example.implicitintentex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBrowser, btnDialer, btnEmail, btnCamera, btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = findViewById(R.id.btnBrowser);
        btnDialer = findViewById(R.id.btnDialer);
        btnEmail = findViewById(R.id.btnEmail);
        btnCamera = findViewById(R.id.btnCamera);
        btnSMS = findViewById(R.id.btnSMS);

        // 🌐 Open Chrome / Browser
        btnBrowser.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // 📞 Open Dialer
        btnDialer.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9876543210"));
            startActivity(intent);
        });

        // 📧 Send Email
        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from my app!");
            startActivity(Intent.createChooser(intent, "Choose Email App"));
        });

        // 📸 Open Camera
        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        // 💬 Send SMS
        btnSMS.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:9876543210"));
            intent.putExtra("sms_body", "Hello from my app!");
            startActivity(intent);
        });
    }
}