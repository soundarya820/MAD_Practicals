package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;

    String expression = "";   // 🔥 THIS IS THE KEY CHANGE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.tvDisplay);
    }

    public void onClick(View view) {

        Button btn = (Button) view;
        String value = btn.getText().toString();

        switch (value) {

            case "C":
                expression = "";
                display.setText("");
                break;

            case "=":
                try {
                    double result = evaluateExpression(expression);
                    display.setText(String.valueOf(result));
                    expression = String.valueOf(result);
                } catch (Exception e) {
                    display.setText("Error");
                    expression = "";
                }
                break;

            default:
                // 🔥 APPEND EVERYTHING (numbers + operators)
                expression += value;
                display.setText(expression);
        }
    }

    // 🔥 SIMPLE EXPRESSION EVALUATOR
    private double evaluateExpression(String expr) {

        double result = 0;
        char operator = '+';
        double number = 0;

        for (int i = 0; i < expr.length(); i++) {

            char ch = expr.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == expr.length() - 1) {

                switch (operator) {
                    case '+': result += number; break;
                    case '-': result -= number; break;
                    case '*': result *= number; break;
                    case '/': result /= number; break;
                }

                operator = ch;
                number = 0;
            }
        }

        return result;
    }
}