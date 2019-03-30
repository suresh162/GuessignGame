package com.example.guessigngame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count;
    private  int r1 , r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giveNewRandom();
    }
    private void giveNewRandom() {
        if (count == 10) {
            count = 0;
            Toast.makeText(this, "YOu have won the game(Game Over)", Toast.LENGTH_SHORT).show();
        }
        else {
            Random rand = new Random();
            r1 = rand.nextInt(10);
            while (true) {
                r2 = rand.nextInt(10);
                if (r1 != r2) break;
            }
            Button b = (Button) findViewById(R.id.buttonL);
            b.setText(Integer.toString(r1));
            Button b2 = (Button) findViewById(R.id.buttonR);
            b2.setText(Integer.toString(r2));
        }
    }

    public void onClickLeft(View view) {
        if(r1 > r2)
            count++;
        else
            count--;
        TextView txt =(TextView) findViewById(R.id.textViewresult);
         txt.setText("Points:" +count);
         giveNewRandom();
    }

    public void onClickRight(View view) {
        if(r1 < r2)
            count++;
        else
            count--;
        TextView txt =(TextView) findViewById(R.id.textViewresult);
        txt.setText("Points:"+count);
        giveNewRandom();
    }
}
