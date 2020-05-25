package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    private static int amountOfCorrectFields = 0;
    private static int amountOfWrongFields = 0;


    public void displayResultTextView(){
        boolean[] result = MainActivity.getResult();
        TextView[] textViews = {findViewById(R.id.resultA), findViewById(R.id.resultB),
                                findViewById(R.id.resultC), findViewById(R.id.resultD)};

        MainActivity.
        for(int i = 0; i < 4; i++){
            if (result[i]) {
                textViews[i].setBackgroundColor(Color.GREEN);
                amountOfCorrectFields++;
            } else {
                textViews[i].setBackgroundColor(Color.RED);
                amountOfWrongFields++;
            }
        }
        TextView correct = (TextView) findViewById(R.id.amountCorrectTextView);
        TextView wrong = (TextView) findViewById(R.id.amountWrongTextView);
        correct.setText(amountOfCorrectFields + " pin(s) is/are fully correct.");
        wrong.setText(amountOfWrongFields + " pin(s) is/are fully wrong.");
        amountOfCorrectFields = 0;
        amountOfWrongFields = 0;

    }

    public void continueGame(View view){
        Button dismiss = (Button) findViewById(R.id.dismissButton);

        if(dismiss.isPressed()){
            finish();
        }
    }

    T
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        displayResultTextView();

    }
}
