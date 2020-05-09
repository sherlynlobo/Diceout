package com.sl.diceout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Field to hold the roll result text
    TextView rollResult;

    //Field to hold roll Button
    Button rollButton;

    //Field to hold the score
    int score;

    Random rand;

    //Fields to hold the dice value
    int die1;
    int die2;
    int die3;

    //ArrayList to hold all 3 dice values
    ArrayList<Integer> dice;

    //ArrayList to hold all 3 dice images
    ArrayList<ImageView> diceImageViews;


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

        //Create ArrayList container for the dice values
        dice = new ArrayList<Integer>();

        ImageView die1Image = findViewById(R.id.die1Image);
        ImageView die2Image = findViewById(R.id.die2Image);
        ImageView die3Image = findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);





        //create greeting
        Toast.makeText(getApplicationContext(),"Welcome to DiceOut!",Toast.LENGTH_SHORT).show();

    }
    public void rollDice(View view) throws IOException {
        rollResult.setText("Clicked");
        /*
        int num = rand.nextInt(6)+1;
        String randomValue = "Number Generated: " + num;
        Toast.makeText(getApplicationContext(),randomValue,Toast.LENGTH_SHORT).show();
         */

        //roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        //set dice values into an ArrayList
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        for(int dieOfSet=0; dieOfSet<3; dieOfSet++ )
        {

            String imageName = "die_" + dice.get(dieOfSet) + ".png";

            try{

                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream, null);
                diceImageViews.get(dieOfSet).setImageDrawable(d);

            }

            catch (IOException e){
                e.printStackTrace();
            }
        }


        //Build message with the result
        String msg = "You rolled a " + die1 + ", a " + die2 + " and a " + die3;

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
