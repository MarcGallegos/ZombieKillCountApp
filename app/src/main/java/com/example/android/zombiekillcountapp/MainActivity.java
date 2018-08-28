package com.example.android.zombiekillcountapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//----Background image is under creative commons zero (CC0) license from https://www.pexels.com/photo/aurora-borealis-902756 Button image is under creative commons zero (CC0) license from https://www.pexels.com/photo/horror-crime-death-psychopath-8578/ ----//
public class MainActivity extends AppCompatActivity {
    int p1_score = 0;
    int p2_score = 0;
    int player1_KDR = 0;
    int player2_KDR = 0;
    int player1_assist = 0;
    int player2_assist = 0;
    int player1_death_or_infection = 0;
    int player2_death_or_infection = 0;
    int player1_Humans_Infected = 0;
    int player2_Humans_Infected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForPlayer1Kills(0);
        displayForPlayer2Kills(p2_score);
        displayForP1KillDeathRatio(0);
        displayForP2KillDeathRatio(player2_KDR);
        displayForplayer1_Humans_Infected(player1_Humans_Infected);
        displayForplayer2_Humans_Infected(player2_Humans_Infected);
        displayForPlayer1Assists(player1_assist);
        displayForPlayer2Assists(player2_assist);
        displayForplayer1_death_or_infection(player1_death_or_infection);
        displayForplayer2_death_or_infection(player2_death_or_infection);
    }

    /**
     * Resets both counters to 0
     */
    public void resetAll(View v) {
        p1_score = 0;
        p2_score = 0;
        player1_KDR = 0;
        player2_KDR = 0;
        player1_assist = 0;
        player2_assist = 0;
        player1_death_or_infection = 0;
        player2_death_or_infection = 0;
        player1_Humans_Infected = 0;
        player2_Humans_Infected = 0;
        displayForplayer1_Humans_Infected(player1_Humans_Infected);
        displayForplayer2_Humans_Infected(player2_Humans_Infected);
        displayForPlayer1Kills(p1_score);
        displayForPlayer2Kills(p2_score);
        displayForP1KillDeathRatio(player1_KDR);
        displayForP2KillDeathRatio(player2_KDR);
        displayForplayer1_death_or_infection(player1_death_or_infection);
        displayForplayer2_death_or_infection(player2_death_or_infection);
        displayForPlayer1Assists(player1_assist);
        displayForPlayer2Assists(player2_assist);
    }
    /**
     * Increments Player 1 Zombies Killed Score each time "+1 Zombie Kill" button is pressed, calculate KDR, and update Kill and KDR results.
     */
    public void p1_zombieKill(View view) {
        p1_score = p1_score + 1;
        displayForPlayer1Kills(p1_score);
    }
    /**
     * Increments Player 1 Assists each time "+1 Assist" is pressed and updates KDR
     */
    public void player1_assist(View view) {
        player1_assist = player1_assist + 1;
        displayForPlayer1Assists(player1_assist);
    }
    /**
     * Increments Player 1 Death/Infection Counter each time "+1 Died/Infected" button is pressed.
     */
    public void player1_death_or_infection(View view) {

        player1_death_or_infection = player1_death_or_infection + 1;
        displayForplayer1_death_or_infection(player1_death_or_infection);
    }
    /**
     * Increments Player 1 Humans Infected Counter upon button click and updates KDR
     */
    public void increment_Player1_Humans_Infected(View view) {

        player1_Humans_Infected = player1_Humans_Infected + 1;
        displayForplayer1_Humans_Infected(player1_Humans_Infected);
    }
    /**
     * Calculates KillDeathRatio for Player1 and updates K:D upon click
     */
    public void P1KillDeathRatio(View v) {
        if (player1_death_or_infection == 0) {
            player1_KDR = 0;
            displayForP1KillDeathRatio(0);
        } else {
            player1_KDR = p1_score + player1_Humans_Infected;
            player1_KDR = player1_KDR / player1_death_or_infection;
            displayForP1KillDeathRatio(player1_KDR);
        }
    }
    /**
     * Displays the given Kills for Player 1.
     */
    public void displayForPlayer1Kills(int p1_score) {
        TextView scoreView = findViewById(R.id.player1_score);
        scoreView.setText(String.valueOf(p1_score));
    }
    /**
     * Displays the current Kill Death Ratio for Player 1.
     */
    public void displayForP1KillDeathRatio(int player1_KDR) {
        TextView scoreView = findViewById(R.id.P1_KillDeathRatio);
        scoreView.setText(String.valueOf(player1_KDR));
    }
    /**
     * Displays the given Assists for Player 1.
     */
    public void displayForPlayer1Assists(int player1_assist) {
        TextView scoreView = findViewById(R.id.Player1_assist);
        scoreView.setText(String.valueOf(player1_assist));
    }
    /**
     * Displays the given Deaths or Infections for Player 1.
     */
    public void displayForplayer1_death_or_infection(int player1_death_or_infection) {
        TextView scoreView = findViewById(R.id.player1_death_or_infection);
        scoreView.setText(String.valueOf(player1_death_or_infection));
    }
    /**
     * Displays the given # of Humans Infected by Player 1.
     */
    public void displayForplayer1_Humans_Infected(int player1_Humans_Infected) {
        TextView scoreView = findViewById(R.id.player1_humans_infected);
        scoreView.setText(String.valueOf(player1_Humans_Infected));
    }

    //-------------------PLAYER 2 Methods below this point-----------------//

    /**
     * Increments Player  Zombies Killed Score each time "+1 Zombie Kill" button is pressed, calculate KDR, and update Kill and KDR results.
     */
    public void p2_zombieKill(View view) {
        p2_score = p2_score + 1;
        displayForPlayer2Kills(p2_score);
    }
    /**
     * Increments Player 2 Assists each time "+1 Assist" is pressed and updates KDR
     */
    public void player2_assist(View view) {

        player2_assist = player2_assist + 1;
        displayForPlayer2Assists(player2_assist);
    }
    /**
     * Increments Player 2 Death/Infection Counter each time "+1 Died/Infected" button is pressed.
     */
    public void player2_death_or_infection(View view) {

        player2_death_or_infection = player2_death_or_infection + 1;
        displayForplayer2_death_or_infection(player2_death_or_infection);
    }
    /**
     * Increments Player 2 Humans Infected Counter upon button click and updates KDR
     */
    public void increment_Player2_Humans_Infected(View view) {
        player2_Humans_Infected = player2_Humans_Infected + 1;
        displayForplayer2_Humans_Infected(player2_Humans_Infected);
    }
    /**
     * Calculates KillDeathRatio for Player2 and updates K:D upon click
     */
    public void P2KillDeathRatio(View v) {
        if (player2_death_or_infection == 0) {
            player2_KDR = 0;
            displayForP2KillDeathRatio(0);
        } else {
            player2_KDR = p2_score + player2_Humans_Infected;
            player2_KDR = player2_KDR / player2_death_or_infection;
            displayForP2KillDeathRatio(player2_KDR);
        }
    }
    /**
     * Displays the given Kills for Player 2.
     */
    public void displayForPlayer2Kills(int p2_score) {
        TextView scoreView = findViewById(R.id.player2_score);
        scoreView.setText(String.valueOf(p2_score));
    }
    /**
     * Displays the current Kill Death Ratio for Player 2.
     */
    public void displayForP2KillDeathRatio(int player2_KDR) {
        TextView scoreView = findViewById(R.id.P2_KillDeathRatio);
        scoreView.setText(String.valueOf(player2_KDR));
    }
    /**
     * Displays the given Assists for Player 2.
     */
    public void displayForPlayer2Assists(int player2_assist) {
        TextView scoreView = findViewById(R.id.Player2_assist);
        scoreView.setText(String.valueOf(player2_assist));
    }
    /**
     * Displays the given Deaths or Infections for Player 2.
     */
    public void displayForplayer2_death_or_infection(int player2_death_or_infection) {
        TextView scoreView = findViewById(R.id.player2_death_or_infection);
        scoreView.setText(String.valueOf(player2_death_or_infection));
    }
    /**
     * Displays the given # of Humans Infected by Player 2.
     */
    public void displayForplayer2_Humans_Infected(int player2_Humans_Infected) {
        TextView scoreView = findViewById(R.id.player2_humans_infected);
        scoreView.setText(String.valueOf(player2_Humans_Infected));
    }
}

