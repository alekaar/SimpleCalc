package com.example.aleksander.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    TextView t;
    int i;
    Button[] numbers = new Button[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.addButton);
        t = (TextView)findViewById(R.id.counterText);
        numbers[0] = (Button)findViewById(R.id.button0);
    }

    public void addPressed(View view){
        i++;
        String s = Integer.toString(i);
        t.setText(s);
    }
}
