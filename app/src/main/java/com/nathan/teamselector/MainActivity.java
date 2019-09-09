package com.nathan.teamselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //Declare Variables
    private Button mSelectButton;
    private EditText mTeamOne;
    private EditText mTeamTwo;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define Variables as my items
        mSelectButton = findViewById(R.id.select_team_button);
        mTeamOne = findViewById(R.id.enter_team_one);
        mTeamTwo = findViewById(R.id.enter_team_two);
        mResultText = findViewById(R.id.results_view);

        //Button Action
        mSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Convert Text Widgets into strings
                String teamOneText = mTeamOne.getText().toString();
                String teamTwoText = mTeamTwo.getText().toString();
                Toast noTeam = Toast.makeText(MainActivity.this, "Please enter two team names", Toast.LENGTH_LONG);

                if (!teamOneText.isEmpty() && !teamTwoText.isEmpty()){
                    mResultText.setText(showTeam(teamOneText,teamTwoText));
                } else{
                    noTeam.show();
                }

            }
        });
    }

    private String showTeam(String teamOneText, String teamTwoText) {
        // returns ternary statement true will return team one else team two
        return new Random().nextBoolean() ? teamOneText : teamTwoText;
    }

}
