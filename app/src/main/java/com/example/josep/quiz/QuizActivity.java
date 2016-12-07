package com.example.josep.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView; //imports TextView class
import android.view.View;     //imports View class
import android.widget.Button; //imports Button class
import android.widget.Toast;  //imports Toast class

//This activity shows each question of the quiz
public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_text, true),
            new Question(R.string.question_1, true),
            new Question(R.string.question_2, false),
            new Question(R.string.question_3, false),
            new Question(R.string.question_4, false),
    };
    private int mCurrentIndex = 0;
    private boolean answer = mQuestionBank[mCurrentIndex].isAnswerTrue();

    //method for loading next question
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        //sets question text
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        //sets a Listener on the true button and creates Toast for answers
        mTrueButton = (Button) findViewById(R.id.true_button);
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (answer) {
                        Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(QuizActivity.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });




        //sets a Listener on the false button and creates Toast for answers
        mFalseButton = (Button) findViewById(R.id.false_button);
            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (answer) {
                        Toast.makeText(QuizActivity.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                    else    {
                        Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });


        //sets a Listener on the next button and increases mCurrentIndex every time next button is clicked
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                answer = mQuestionBank[mCurrentIndex].isAnswerTrue();
                updateQuestion();
            }
        });

        updateQuestion();
    }
}
