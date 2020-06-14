package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {

    private static int amountOfCorrectFields = 0;
    private static int amountOfCorrectColorWrongField = 0;
    private static int amountOfWrongField = 0;

    private static int attempts = 0;



    public void displayResultTextView(){
        int[] result = MainActivity.getResult();
        TextView[] textViews = {findViewById(R.id.resultA), findViewById(R.id.resultB),
                                findViewById(R.id.resultC), findViewById(R.id.resultD)};

        for(int i = 0; i < 4; i++){
            if (result[i] == 0) {
                textViews[i].setBackgroundColor(Color.BLACK);
                amountOfCorrectFields++;
            } else if (result[i] == 1){
                textViews[i].setBackgroundColor(Color.WHITE);
                amountOfCorrectColorWrongField++;
            } else{
                textViews[i].setBackgroundColor(Color.parseColor("#FFA7A6A6"));
                amountOfWrongField++;
            }
        }
        TextView correct = (TextView) findViewById(R.id.amountCorrectTextView);
        TextView wrong = (TextView) findViewById(R.id.amountWrongTextView);
        correct.setText(amountOfCorrectFields + " pin(s) is/are fully correct.");
        wrong.setText(amountOfCorrectColorWrongField + " pin(s) have correct color, but wrong position.");
        amountOfCorrectFields = 0;
        amountOfCorrectColorWrongField = 0;



    }

    public void continueGame(View view){
        Button dismiss = (Button) findViewById(R.id.dismissButton);

        if(dismiss.isPressed()){
            finish();
            Toast.makeText(this, MainActivity.getRightOrWrongField(), Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        displayResultTextView();

    }
}
