package com.example.android.footballcourtapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0; //score variable for team A
    int teamBScore = 0;//score variable for team B
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Display team A's score on team_a_score TextView
    //private: can't be accessed from ouside the class
    private void displayTeamAScore(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    //Display team B's score on team_b_score TextView
    //private: can't be accessed from ouside the class
    private void displayTeamBScore(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * use switch-case for onClick behaviours (all buttons and imageview)
     */
    public void getScore(View view){
        /**get the clicked button id
         * Both Button and ImageView are subclasses of android.view.View
         */
        View clickedButton = view;
        switch (clickedButton.getId()){
            /**
             *add 6 points for team A
             */
            case R.id.addSixPointA:
                teamAScore += 6;
                displayTeamAScore(teamAScore);
                break;
            /**
             *add 3 points for team A
             */
            case R.id.addThreePointA:
                teamAScore += 3;
                displayTeamAScore(teamAScore);
                break;
            /**
             *add 2 points for team A
             */
            case R.id.addTwoPointsA:
                teamAScore += 2;
                displayTeamAScore(teamAScore);
                break;
            /**
             *add 1 points for team A
             */
            case R.id.addOnePointsA:
                teamAScore += 1;
                displayTeamAScore(teamAScore);
                break;
            /**
             *add 6 points for team B
             */
            case R.id.addSixPointB:
                teamBScore += 6;
                displayTeamBScore(teamBScore);
                break;
            /**
            *add 3 points for team B
            */
            case R.id.addThreePointB:
                teamBScore += 3;
                displayTeamBScore(teamBScore);
                break;
            /**
             *add 2 points for team B
             */
            case R.id.addTwoPointB:
                teamBScore += 2;
                displayTeamBScore(teamBScore);
                break;
            /**
             *add 1 points for team B
             */
            case R.id.addOnePointB:
                teamBScore += 1;
                displayTeamBScore(teamBScore);
                break;
            /**
             * Reset the score both teams
             */
            case  R.id.resetButton:
                teamAScore=0;
                teamBScore=0;
                displayTeamAScore(teamAScore);
                displayTeamBScore(teamBScore);
                break;
        }

    }

}
