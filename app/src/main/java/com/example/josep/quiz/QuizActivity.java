package com.example.josep.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView; //imports TextView class
import android.view.View;     //imports View class
import android.widget.Button; //imports Button class
import android.widget.Toast;  //imports Toast class

//This activity shows each question of the quiz
public class QuizActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CHEAT = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;
    private TextView mScoreText;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_text, true),
            new Question(R.string.question_1, true),
            new Question(R.string.question_2, false),
            new Question(R.string.question_3, false),
            new Question(R.string.question_4, false),
    };
    private int mCurrentIndex = 0;
    private boolean mIsCheater;
    public int mScoreCounter = 0;

    //method for loading next question
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    //method for checking answer
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (mIsCheater) {
            messageResId = R.string.judgment_toast;
        } else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    //method to add point if answer is correct, created public so result class can use it to calculate score
    public void isAnswerCorrect(boolean userPressedTrue) {
            boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

            if (!mIsCheater && (userPressedTrue == answerIsTrue))
                mScoreCounter++;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

    /* TO BE COMPLETED

      1. Create boolean variable to determine if question has been answered before.
         If yes, then mScoreCounter will not increase.
         Conditions: if he chooses "show answer", clicks "true" or clicks "false", it records as answered.
         Currently it increases if the answer is clicked correctly, but allows repetition.

      2. Create boolean variable to determine whether all questions answered.

      3. Create Submit button which appears if all questions answered, add Listener to send intent to ResultActivity when clicked

       CODE TESTED

       Intent finalscore = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("final_score", mScoreCounter);
                startActivity(finalscore);
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //sets a Listener on the cheat button
        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CheatActivity
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent i = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);
                startActivityForResult(i, REQUEST_CODE_CHEAT);
            }
        });

        //sets question text
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        //defines score text
        mScoreText = (TextView) findViewById(R.id.score_text);


        //sets a Listener on the true button and creates Toast for answers
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                isAnswerCorrect(true);
                mScoreText.setText("Score: " + mScoreCounter);
            }
        });


        //sets a Listener on the false button and creates Toast for answers
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                isAnswerCorrect(false);
                mScoreText.setText("Score: " + mScoreCounter);
            }
        });


        //sets a Listener on the next button and increases mCurrentIndex every time next button is clicked
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mIsCheater = false;
                updateQuestion();
            }
        });

        updateQuestion();
    }

}
