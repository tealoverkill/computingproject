package com.example.josep.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultActivity extends AppCompatActivity {

    private TextView mScoreText;
    private Button mPlayAgainButton;
    public static Map<String, Integer> playerMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String printScores = "Score\t\t\t\t Player Name\n\n" ;

        Intent intent = getIntent();

        int final_score = intent.getIntExtra("final_score", 0);

        playerMap.put(RegistrationActivity.p1_name_1player, final_score);

        Map<Integer, String> rankingMap = new HashMap<>();
        for (int i = QuizActivity.mQuestionBank.length; i >= 0; i--)    {
            for (String key : playerMap.keySet())   {
                if (playerMap.get(key) == i)    {
                    rankingMap.put(i, key);
                    printScores = printScores + (i + "\t\t\t\t\t\t\t\t\t\t" + key + "\n");
                }
            }
        }



        mScoreText = (TextView) findViewById(R.id.result_text);
        mScoreText.setText(printScores);






        mPlayAgainButton = (Button) findViewById(R.id.play_again_button);
        mPlayAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Resets quiz parameters for new game
                QuizActivity.mQuestionsAnswered = 0;
                QuizActivity.mCurrentIndex = 0;
                for (int i = 0; i < QuizActivity.mQuestionBank.length; i++) {
                    QuizActivity.mQuestionBank[i].setIsAnswered(false);
                }
                CheatActivity.mButtonClicked = new boolean[QuizActivity.mQuestionBank.length];

                //Starts new game
                Intent playAgain = new Intent(getApplicationContext(), com.example.josep.quiz.MainActivity.class);
                startActivity(playAgain);
            }
        });


    }
}
