package com.example.josep.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//This activity allows players to input their names
public class RegistrationActivity extends AppCompatActivity {

    private Button mProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //sets a Listener on the proceed button
        mProceed = (Button) findViewById(R.id.proceed_registration);
        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent player1start = new Intent(getApplicationContext(), com.example.josep.quiz.Player1StartActivity.class);
                startActivity(player1start);
            }
        });

        /*Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_registration);
        layout.addView(textView);
        */
    }
}
