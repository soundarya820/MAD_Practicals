package com.example.fileapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etBranch, etRoll;
    Button btnLoad, btnShow;
    TextView tvData;

    String FILE_NAME = "users.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔹 Connect XML IDs
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etBranch = findViewById(R.id.etBranch);
        etRoll = findViewById(R.id.etRoll);

        btnLoad = findViewById(R.id.btnLoad);
        btnShow = findViewById(R.id.btnShow);
        tvData = findViewById(R.id.tvData);

        // 🔹 Save Button (LOAD)
        btnLoad.setOnClickListener(v -> saveData());

        // 🔹 Show Button
        btnShow.setOnClickListener(v -> showData());
    }

    // ✅ SAVE DATA TO FILE
    private void saveData() {

        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String branch = etBranch.getText().toString().trim();
        String roll = etRoll.getText().toString().trim();

        // 🔥 Validation
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()
                || branch.isEmpty() || roll.isEmpty()) {

            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // 🔹 Format data
        String data = "Name: " + name +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nBranch: " + branch +
                "\nRoll No: " + roll +
                "\n----------------------\n";

        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(data.getBytes());
            fos.close();

            Toast.makeText(this, "Data Saved Successfully!", Toast.LENGTH_SHORT).show();

            clearFields(); // optional clean UX

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();
        }
    }

    // ✅ READ DATA FROM FILE
    private void showData() {

        StringBuilder builder = new StringBuilder();

        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            reader.close();

            tvData.setText(builder.toString());

        } catch (Exception e) {
            tvData.setText("No data found");
        }
    }

    // ✅ CLEAR INPUT FIELDS
    private void clearFields() {
        etName.setText("");
        etEmail.setText("");
        etPhone.setText("");
        etBranch.setText("");
        etRoll.setText("");
    }
}