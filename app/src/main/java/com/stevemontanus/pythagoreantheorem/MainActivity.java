package com.stevemontanus.pythagoreantheorem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Initialize variables for UI elements.
    EditText sideA;
    EditText sideB;
    TextView sideC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Assign UI elements to variables.
        sideA = (EditText) findViewById(R.id.sideA);
        sideB = (EditText) findViewById(R.id.sideB);
        sideC = (TextView) findViewById(R.id.sideC);
        Button calcButton = (Button) findViewById(R.id.calcButton);

        // Button click event listener.
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculate the length of side c.
                double aLength = Float.parseFloat(sideA.getText().toString());
                double bLength = Float.parseFloat(sideB.getText().toString());
                double cLength = Math.hypot(aLength, bLength);
                sideC.setText(String.format("%.1f", cLength));
            }
        });
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
