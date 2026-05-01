package com.example.exp6;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    RadioGroup radioGroup;
    CheckBox cbReading, cbSports;
    ToggleButton toggleNotify;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        radioGroup = findViewById(R.id.radioGroup);
        cbReading = findViewById(R.id.cbReading);
        cbSports = findViewById(R.id.cbSports);
        toggleNotify = findViewById(R.id.toggleNotify);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Button Click Event
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                // Gender
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(selectedId);
                String gender = selectedGender != null ? selectedGender.getText().toString() : "Not Selected";

                // Hobbies
                String hobbies = "";
                if (cbReading.isChecked()) hobbies += "Reading ";
                if (cbSports.isChecked()) hobbies += "Sports ";

                // Toggle Button
                String notificationStatus = toggleNotify.isChecked() ? "ON" : "OFF";

                // Validation
                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    String result = "Name: " + name +
                            "\nEmail: " + email +
                            "\nGender: " + gender +
                            "\nHobbies: " + hobbies +
                            "\nNotifications: " + notificationStatus;

                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                }
            }
        });

        // Toggle Button Event
        toggleNotify.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String msg = isChecked ? "Notifications Enabled" : "Notifications Disabled";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}