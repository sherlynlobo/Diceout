package com.sl.diceout;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Field to hold the roll result text
    TextView rollResult;

    //Field to hold roll Button
    Button rollButton;

    //Field to hold the score
    int score;

    Random rand;

    //Field to hold the die value
    int die1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Set initial score
        score = 0;

        rollResult = findViewById(R.id.rollResult);
        rollButton = findViewById(R.id.rollButton);

        //initialize the random number generator
        rand = new Random();


        //create greeting
        Toast.makeText(getApplicationContext(),"Welcome to DiceOut!",Toast.LENGTH_SHORT).show();

    }
    public void rollDice(View view)
    {
        rollResult.setText("Clicked");
        /*
        int num = rand.nextInt(6)+1;
        String randomValue = "Number Generated: " + num;
        Toast.makeText(getApplicationContext(),randomValue,Toast.LENGTH_SHORT).show();
         */

        //roll dice
        die1 = rand.nextInt(6)+1;
        //Build message with the result
        String msg = "You rolled a " + die1;

        //update the app to display the result msg
        rollResult.setText(msg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
