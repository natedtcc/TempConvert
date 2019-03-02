/*
 *   Nathan Nasteff
 *   Delaware Tech
 *   Spring 2019
 */
package com.nnasteff.tempconvert;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class CalcActivity extends AppCompatActivity {

    private TextView tempOut;
    private Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        getWindow().setExitTransition(new Explode());
        final Intent myIntent = new Intent(this, MainActivity.class);
        final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);

        // Define elements

        tempOut = (TextView) findViewById(R.id.temp);
        buttonReturn = (Button) findViewById(R.id.return_button);

        // Define TextView's temp using getTemps() method

        tempOut.setText(String.valueOf(MainActivity.tempCalc.getTemps()));

        // Return button

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(myIntent, options.toBundle());
                finish();
            }
        });

    }
}
