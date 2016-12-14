package com.example.josep.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;     //imports View class
import android.widget.Button; //imports Button class
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

//This activity shows the starting page where one chooses single or multiplayer mode
public class MainActivity extends AppCompatActivity {

    private Button mOnePlayerButton;
    private Button mTwoPlayerButton;
    private Button mScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets a Listener on the 1 player button
        mOnePlayerButton = (Button) findViewById(R.id.no1_player);
        mOnePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent onePlayer = new Intent(getApplicationContext(), com.example.josep.quiz.RegistrationActivity.class);
                //creates an Intent named onePlayer
                startActivity(onePlayer);
                //starts onePlayer
            }
        });


        //sets a Listener on the 2 player button
        mTwoPlayerButton = (Button) findViewById(R.id.no2_players);
        mTwoPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent twoPlayer = new Intent(getApplicationContext(), com.example.josep.quiz.RegistrationActivity.class);
                //creates an Intent named twoPlayer
                startActivity(twoPlayer);
                //starts twoPlayer
            }
        });

        mScoreButton = (Button) findViewById(R.id.score_button);
        mScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /**
                Intent Scorelist = new Intent(getApplicationContext(), com.example.josep.quiz.ScorelistActivity.class);
                //creates an Intent named Scorelist
                startActivity(Scorelist);
                //starts Scorelist
                 */

            }
        });
    }

    /** Called when the user clicks the 1 player button
    public void OnePlayerMessage(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    */



        //setContentView(R.layout.numberofplayers); - screen to request number of players
        //setContentView(R.layout.registration1); - screen to register player 1 name
        //setContentView(R.layout.registration2); - screen to register player 2 name
        //setContentView(R.layout.player1start); - screen for player 1 to start
        //setContentView(R.layout.player2start); - screen for player 2 to start


}

