package com.example.josep.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.josep.quiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.example.josep.quiz.answer_shown";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    public static boolean[] mButtonClicked = new boolean[QuizActivity.mQuestionBank.length];
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButtonClicks();
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                if(!mButtonClicked[QuizActivity.mCurrentIndex])  {
                    QuizActivity.mQuestionBank[QuizActivity.mCurrentIndex].setIsAnswered(true);
                    QuizActivity.mQuestionsAnswered++;
                }
                mButtonClicked[QuizActivity.mCurrentIndex] = true;
                setAnswerShownResult(true);
            }
        });
    }

    private void updateButtonClicks()   {
        for (int i = 0; i < QuizActivity.mQuestionBank.length; i++) {
            mButtonClicked[i] = QuizActivity.mQuestionBank[i].getIsAnswered();
        }
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
