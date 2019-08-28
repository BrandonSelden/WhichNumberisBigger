package com.example.whichnumberisbigger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private BiggerNumberGame game;
    private ConstraintLayout background;
    private int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wiredWidgets();
        setListeners();
        //construct game
        game = new BiggerNumberGame(0, 10);
        color = Color.rgb(255, 255, 255);
        background = findViewById(R.id.constraint_layout_main);
        //do any initial setup before the player takes their first turn
        updateGameDisplay();
    }

    private void updateGameDisplay() {
        game.generateRandomNumbers();
        //set the text of each button
        background.setBackgroundColor(color);
        buttonLeft.setText(String.valueOf(game.getNumber1()));
        buttonRight.setText(String.valueOf(game.getNumber2()));
        textViewScore.setText(String.valueOf(game.getScore()));
        //set the text of the score
    }




    private void setListeners() {
        //created an Anon. Inner Class that implements View.OnClickListener
        //overriding the one abstract method onClick(View v)
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = Integer.parseInt(buttonLeft.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, message , Toast.LENGTH_LONG).show();
                if(game.isRight(answer))
                {
                    color = Color.rgb(0, 255, 0);
                }
                else
                {

                    color = Color.rgb(255, 0, 0);
                }
                updateGameDisplay();
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int answer = Integer.parseInt(buttonRight.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, message , Toast.LENGTH_LONG).show();
                if(game.isRight(answer))
                {
                    int color = Color.rgb(0, 255, 0);
                    background.setBackgroundColor(color);
                }
                else
                {

                    int color = Color.rgb(255, 0, 0);
                    background.setBackgroundColor(color);
                }
                updateGameDisplay();
            }
        });
    }

    private void wiredWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
    }
}
