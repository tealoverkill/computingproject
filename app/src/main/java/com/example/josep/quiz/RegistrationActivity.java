package com.example.josep.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//This activity allows players to input their names
public class RegistrationActivity extends AppCompatActivity {

    private Button mProceed;
    private EditText mEditText;
    public static String p1_name_1player = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mEditText = (EditText) findViewById(R.id.player_1_name);

        //sets a Listener on the proceed button
        mProceed = (Button) findViewById(R.id.proceed_registration);
        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                p1_name_1player = mEditText.getText().toString().trim();
                if (p1_name_1player.isEmpty() || p1_name_1player.length() == 0 || p1_name_1player.equals(""))    {
                    Toast.makeText(RegistrationActivity.this, R.string.blank_registration, Toast.LENGTH_SHORT)
                            .show();
                }
                else if (ResultActivity.playerMap.containsKey(p1_name_1player)) {
                    Toast.makeText(RegistrationActivity.this, R.string.user_already_exists_registration, Toast.LENGTH_SHORT)
                            .show();
                }
                else    {
                    Intent player1start = new Intent(getApplicationContext(), com.example.josep.quiz.Player1StartActivity.class);
                    startActivity(player1start);
                }
            }
        });
    }
}
