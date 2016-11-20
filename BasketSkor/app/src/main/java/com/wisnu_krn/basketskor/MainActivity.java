package com.wisnu_krn.basketskor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    final int POINTS_FOR_FREE_THROW = 1;
    final int POINTS_FOR_TWO_POINTS = 2;
    final int POINT_FOR_THREE_POINTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button forAOnePoint = (Button) findViewById(R.id.a_poin_1);
        Button forATwoPoint = (Button) findViewById(R.id.a_poin_2);
        Button forAThreePoint = (Button) findViewById(R.id.a_poin_3);
        Button forBOnePoint = (Button) findViewById(R.id.b_poin_1);
        Button forBTwoPoint = (Button) findViewById(R.id.b_poin_2);
        Button forBThreePoint = (Button) findViewById(R.id.b_poin_3);
        Button reset = (Button) findViewById(R.id.reset);
        Button finish = (Button) findViewById(R.id.finish);

        forATwoPoint.setOnClickListener(this);
        forAOnePoint.setOnClickListener(this);
        forAThreePoint.setOnClickListener(this);
        forBTwoPoint.setOnClickListener(this);
        forBOnePoint.setOnClickListener(this);
        forBThreePoint.setOnClickListener(this);
        reset.setOnClickListener(this);
        finish.setOnClickListener(this);

    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.tim_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.tim_b_score);
        scoreView.setText(String.valueOf(score));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.a_poin_1:
                addOneForTeamA();
                break;
            case R.id.a_poin_2:
                addTwoForTeamA();
                break;
            case R.id.a_poin_3:
                addThreeForTeamA();
                break;
            case R.id.b_poin_1:
                addOneForTeamB();
                break;
            case R.id.b_poin_2:
                addTwoForTeamB();
                break;
            case R.id.b_poin_3:
                addThreeForTeamB();
                break;
            case R.id.reset:
                resetSkor();
                break;
            case R.id.finish:
                move();
                break;
        }
    }

    private void move() {
        String hasil;
        String winner;
        if (scoreTeamA > scoreTeamB) {
            hasil = "Cavaliers";
            winner = "a";
        } else if (scoreTeamA < scoreTeamB) {
            hasil = "Miami Heat";
            winner = "b";
        } else {
            winner = "";
            hasil = "Imbang -_-";
        }

        hasil = hasil
                + "\nDengan Skor\n" + scoreTeamA + " melawan " + scoreTeamB;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("hasil", hasil);
        intent.putExtra("winner", winner);
        startActivity(intent);
    }

    public void addOneForTeamA() {
        scoreTeamA = scoreTeamA + POINTS_FOR_FREE_THROW;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA() {
        scoreTeamA = scoreTeamA + POINTS_FOR_TWO_POINTS;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamA() {
        scoreTeamA = scoreTeamA + POINT_FOR_THREE_POINTS;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamB() {
        scoreTeamB = scoreTeamB + POINTS_FOR_FREE_THROW;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB() {
        scoreTeamB = scoreTeamB + POINTS_FOR_TWO_POINTS;
        displayForTeamB(scoreTeamB);
    }

    public void addThreeForTeamB() {
        scoreTeamB = scoreTeamB + POINT_FOR_THREE_POINTS;
        displayForTeamB(scoreTeamB);
    }

    public void resetSkor() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
