package com.example.tictactoe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button[] buttons = new Button[9];
    boolean isX = true; // X starts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link buttons
        for (int i = 0; i < 9; i++) {
            String id = "b" + (i + 1);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            buttons[i] = findViewById(resID);

            int finalI = i;
            buttons[i].setOnClickListener(v -> handleClick(finalI));
        }
    }

    private void handleClick(int i) {

        if (!buttons[i].getText().toString().equals("")) return;

        if (isX) {
            buttons[i].setText("X");
        } else {
            buttons[i].setText("O");
        }

        isX = !isX;

        checkWinner();
    }

    private void checkWinner() {

        String[][] board = new String[3][3];

        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText().toString();
        }

        // Check rows, columns, diagonals
        for (int i = 0; i < 3; i++) {

            if (board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2]) &&
                    !board[i][0].equals("")) {
                showWinner(board[i][0]);
                return;
            }

            if (board[0][i].equals(board[1][i]) &&
                    board[1][i].equals(board[2][i]) &&
                    !board[0][i].equals("")) {
                showWinner(board[0][i]);
                return;
            }
        }

        if (board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2]) &&
                !board[0][0].equals("")) {
            showWinner(board[0][0]);
            return;
        }

        if (board[0][2].equals(board[1][1]) &&
                board[1][1].equals(board[2][0]) &&
                !board[0][2].equals("")) {
            showWinner(board[0][2]);
        }
    }

    private void showWinner(String winner) {
        Toast.makeText(this, winner + " Wins!", Toast.LENGTH_LONG).show();
        resetGame();
    }

    private void resetGame() {
        for (Button b : buttons) {
            b.setText("");
        }
        isX = true;
    }
}