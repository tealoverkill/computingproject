package com.example.josep.quiz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizFragment extends Fragment{

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;

    private void setQuestion(int i)  {
        int question = QuizActivity.mQuestionBank[i].getTextResId();
        QuizActivity.mQuestionTextView.setText(question);
        QuizActivity.mIsCheater = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        mButton1 = (Button) view.findViewById(R.id.fragment_button_1);
        mButton1.setOnClickListener(
                new View.OnClickListener()  {
                    public void onClick (View v)    {
                        QuizActivity.mCurrentIndex = 0;
                        setQuestion(0);
                    }
                }
        );

        mButton2 = (Button) view.findViewById(R.id.fragment_button_2);
        mButton2.setOnClickListener(
                new View.OnClickListener()  {
                    public void onClick (View v)    {
                        QuizActivity.mCurrentIndex = 1;
                        setQuestion(1);
                    }
                }
        );

        mButton3 = (Button) view.findViewById(R.id.fragment_button_3);
        mButton3.setOnClickListener(
                new View.OnClickListener()  {
                    public void onClick (View v)    {
                        QuizActivity.mCurrentIndex = 2;
                        setQuestion(2);
                    }
                }
        );

        mButton4 = (Button) view.findViewById(R.id.fragment_button_4);
        mButton4.setOnClickListener(
                new View.OnClickListener()  {
                    public void onClick (View v)    {
                        QuizActivity.mCurrentIndex = 3;
                        setQuestion(3);
                    }
                }
        );

        mButton5 = (Button) view.findViewById(R.id.fragment_button_5);
        mButton5.setOnClickListener(
                new View.OnClickListener()  {
                    public void onClick (View v)    {
                        QuizActivity.mCurrentIndex = 4;
                        setQuestion(4);
                    }
                }
        );

        return view;







    }



}
