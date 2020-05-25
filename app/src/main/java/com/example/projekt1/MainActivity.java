package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    // This array checks which checkbox (A-D) is clicked
    // to know which textviews (A-D) should be coloured
    private static Boolean[] checkClicked = {
            false, false, false, false
    };

    //this is an array with all the hexadecimal values of the needed colors
    private static int[] colors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW
    };

    // this is the random color code
    private static int[] randomColorCode = new int[4];

    private static boolean[] result = new boolean[4];

    private static int attempts = 0;



    //this function sets a checkbox as true or false, depending on if it's pressed or not
    //the boolean value will be set on the checkClicked array
    public void putCheckedField(View view){
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()){
            checkClicked[Integer.parseInt(checkBox.getTag().toString())] = true;
        }
        else{
            checkClicked[Integer.parseInt(checkBox.getTag().toString())] = false;
        }
    }


    /*This function handles the input of the color code including the input
    via radioButtons and Checkboxes*/
    public void pickColor(View view){
        RadioButton radioButton = (RadioButton) view;
        TextView[] textViews = {findViewById(R.id.textViewA),findViewById(R.id.textViewB),
                                findViewById(R.id.textViewC),findViewById(R.id.textViewD)};

        for(int i = 0; i < checkClicked.length; i++){
            if(checkClicked[i]){
                if(radioButton.getText().toString().equals("Red")){
                    textViews[i].setBackgroundColor(Color.RED);
                }
                else if(radioButton.getText().toString().equals("Green")){
                    textViews[i].setBackgroundColor(Color.GREEN);
                }
                else if(radioButton.getText().toString().equals("Blue")){
                    textViews[i].setBackgroundColor(Color.BLUE);
                }
                else if(radioButton.getText().toString().equals("Cyan")){
                    textViews[i].setBackgroundColor(Color.CYAN);
                }
                else if(radioButton.getText().toString().equals("Magenta")){
                    textViews[i].setBackgroundColor(Color.MAGENTA);
                }
                else if(radioButton.getText().toString().equals("Yellow")){
                    textViews[i].setBackgroundColor(Color.YELLOW);
                }
            }
        }
    }


    //this function is the a getter for a random Color (Hexadecimal - value)
    public int getRandomColor(){
        int randomColorIndex = new Random().nextInt(colors.length);
        return colors[randomColorIndex];
    }

    /*This function generates the random color code which has to be found out by the user*/
    public void generateRandomColorCode(View view){
        Button generateButton = (Button) view;
        TextView[] textViews = {findViewById(R.id.textViewA),findViewById(R.id.textViewB),
                                findViewById(R.id.textViewC),findViewById(R.id.textViewD)};
        if(generateButton.isPressed()){
            //set the randomColorCode array
            for(int i = 0; i < 4; i++){
                randomColorCode[0] = getRandomColor();
            }
        }
        Toast.makeText(this, "A new secret color code has been generated. GOOD LUCK!", Toast.LENGTH_SHORT).show();
    }


    public void compareColorCode(View view){
        TextView[] textViews = {findViewById(R.id.textViewA),findViewById(R.id.textViewB),
                                findViewById(R.id.textViewC),findViewById(R.id.textViewD)};

        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        String rightOrWrongField = "";
        ColorDrawable colorDrawableA = (ColorDrawable)(textViews[0].getBackground());
        int colorA = colorDrawableA.getColor();
        ColorDrawable colorDrawableB = (ColorDrawable)(textViews[1].getBackground());
        int colorB = colorDrawableB.getColor();
        ColorDrawable colorDrawableC = (ColorDrawable)(textViews[2].getBackground());
        int colorC = colorDrawableC.getColor();
        ColorDrawable colorDrawableD = (ColorDrawable)(textViews[3].getBackground());
        int colorD = colorDrawableD.getColor();

        int[] submittedColorCode = {colorA, colorB, colorC, colorD};
        for(int i = 0; i < 4; i++){
            if(randomColorCode[i] == submittedColorCode[i]){
                rightOrWrongField += "Field " + i + " is correct!\n";
                result[i] = true;
            }
            else{
                rightOrWrongField += "Field " + i + " is not correct!\n";
                result[i] = false;
            }
        }

        Toast.makeText(this, rightOrWrongField, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, result.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);




    }



    public static boolean[] getResult(){
        return result;
    }

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomColorCode = new int[]{getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor()};

    }
}
