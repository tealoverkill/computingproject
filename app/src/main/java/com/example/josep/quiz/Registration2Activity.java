package com.example.josep.quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration2Activity extends AppCompatActivity {

    private Button mProceed;
    private EditText mEditText1;
    private EditText mEditText2;
    public static String p1_name_2player = "";
    public static String p2_name_2player = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        mEditText1 = (EditText) findViewById(R.id.player_1_name2);
        mEditText2 = (EditText) findViewById(R.id.player_2_name2);

        //sets a Listener on the proceed button
        mProceed = (Button) findViewById(R.id.proceed_registration2);
        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_name_2player = mEditText1.getText().toString().trim();
                p2_name_2player = mEditText2.getText().toString().trim();

                if ((p1_name_2player.isEmpty() || p1_name_2player.length() == 0 || p1_name_2player.equals(""))
                        || ((p2_name_2player.isEmpty() || p2_name_2player.length() == 0 || p2_name_2player.equals("")))) {
                    Toast.makeText(Registration2Activity.this, R.string.blank_registration, Toast.LENGTH_SHORT)
                            .show();
                } else if ((ResultActivity.playerMap.containsKey(p1_name_2player)) || (ResultActivity.playerMap.containsKey(p2_name_2player))) {
                    Toast.makeText(Registration2Activity.this, R.string.user_already_exists_registration, Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Intent player1start = new Intent(getApplicationContext(), Player1StartActivity.class);
                    startActivity(player1start);
                }

            }
        });
    }
}

