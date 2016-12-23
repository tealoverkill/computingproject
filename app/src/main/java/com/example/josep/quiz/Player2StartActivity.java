package com.example.josep.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Player2StartActivity extends AppCompatActivity {

    private Button mStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2start);

        //sets a Listener on the Start button
        mStart = (Button) findViewById(R.id.start);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Update that Player 2 is now having his turn
                QuizActivity.playerOneDone = true;
                Intent quizActivity = new Intent(getApplicationContext(), com.example.josep.quiz.QuizActivity.class);
                startActivity(quizActivity);
            }
        });
    }
}
