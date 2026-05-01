package com.example.explicitexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    SharedPreferences sharedPreferences;

    String validUsername = "admin";
    String validPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("LoginPref", MODE_PRIVATE);

        // 🔥 Auto-login if already logged in
        if(sharedPreferences.getBoolean("isLoggedIn", false)){
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
        }

        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> loginUser());
    }

    private void loginUser() {

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // ✅ Validation
        if(TextUtils.isEmpty(username)){
            etUsername.setError("Enter Username");
            return;
        }

        if(TextUtils.isEmpty(password)){
            etPassword.setError("Enter Password");
            return;
        }

        // ✅ Check credentials
        if(username.equals(validUsername) && password.equals(validPassword)){

            // Save session
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", true);
            editor.putString("username", username);
            editor.apply();

            // Move to next page
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}