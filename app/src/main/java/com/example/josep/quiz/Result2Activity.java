package com.example.josep.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Result2Activity extends AppCompatActivity {

    private TextView mScoreText;
    private Button mNextPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        String printScores = "Score\t\t\t\t Player Name\n\n" ;

        Intent intent = getIntent();

        int final_score1 = intent.getIntExtra("final_score1", 0);

        ResultActivity.playerMap.put(Registration2Activity.p1_name_2player, final_score1);

        Map<Integer, String> rankingMap = new HashMap<>();
        for (int i = QuizActivity.mQuestionBank.length; i >= 0; i--)    {
            for (String key : ResultActivity.playerMap.keySet())   {
                if (ResultActivity.playerMap.get(key) == i)    {
                    rankingMap.put(i, key);
                    printScores = printScores + (i + "\t\t\t\t\t\t\t\t\t\t" + key + "\n");
                }
            }
        }

        mScoreText = (TextView) findViewById(R.id.result_text);
        mScoreText.setText(printScores);

        mNextPlayerButton = (Button) findViewById(R.id.next_player_button);
        mNextPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Resets quiz parameters for new game
                QuizActivity.mQuestionsAnswered = 0;
                QuizActivity.mCurrentIndex = 0;
                QuizActivity.mIsCheater = false;
                for (int i = 0; i < QuizActivity.mQuestionBank.length; i++) {
                    QuizActivity.mQuestionBank[i].setIsAnswered(false);
                }

                CheatActivity.mButtonClicked = new boolean[QuizActivity.mQuestionBank.length];

                //Goes to Player2StartActivity
                Intent nextPlayer = new Intent(getApplicationContext(), com.example.josep.quiz.Player2StartActivity.class);
                startActivity(nextPlayer);
            }
        });
    }
}
