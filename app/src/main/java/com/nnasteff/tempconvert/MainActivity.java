/*
 *   Nathan Nasteff
 *   Delaware Tech
 *   Spring 2019
 */

package com.nnasteff.tempconvert;
import android.app.ActivityOptions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Create instance of TempConverter

    public static TempConverter tempCalc = new TempConverter();

    // Define elements

    private EditText tempET;
    private Button buttonFar;
    private Button buttonCel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setExitTransition(new Explode());
        // Assign IDs to elements

        tempET = (EditText) findViewById(R.id.temp);
        buttonFar = (Button) findViewById(R.id.fahrenheit);
        buttonCel = (Button) findViewById(R.id.celsius);
        final Intent myIntent = new Intent(this, CalcActivity.class);
        final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);

        // If fahrenheit is clicked..

        buttonFar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tempCalc.setTempIn(tempET.getText().toString());
                tempCalc.setTempSelect(true);
                startActivity(myIntent, options.toBundle());
                finish();
            }
        });

        // If celsius is clicked..

        buttonCel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tempCalc.setTempIn(tempET.getText().toString());
                tempCalc.setTempSelect(false);
                startActivity(myIntent, options.toBundle());
                finish();
           }
        });

    }
}
