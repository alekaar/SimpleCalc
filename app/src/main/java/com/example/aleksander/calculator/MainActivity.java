package com.example.aleksander.calculator;

import android.content.res.TypedArray;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add;
    TextView t;
    Integer sum;
    StringBuilder str;
    Button[] numbers = new Button[10];
    ArrayList<Integer> values = new ArrayList<>();
    int latestPlus = -1;
    //Button[] numbers = getResources().obtainTypedArray(R.array.button_id_array);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.addButton);
        t = (TextView)findViewById(R.id.counterText);
        str = new StringBuilder();
        numbers[0] = (Button)findViewById(R.id.button0);
        numbers[1] = (Button)findViewById(R.id.button1);
        numbers[2] = (Button)findViewById(R.id.button2);
        numbers[3] = (Button)findViewById(R.id.button3);
        numbers[4] = (Button)findViewById(R.id.button4);
        numbers[5] = (Button)findViewById(R.id.button5);
        numbers[6] = (Button)findViewById(R.id.button6);
        numbers[7] = (Button)findViewById(R.id.button7);
        numbers[8] = (Button)findViewById(R.id.button8);
        numbers[9] = (Button)findViewById(R.id.button9);


    }

    //when push add, check if empty field and numbers present or if numbers before latest plus
    public void addPressed(View view){
        if(latestPlus == -1 && str.length() > 0) {
            values.add(Integer.valueOf(str.toString()));
            System.out.println(Integer.valueOf(str.toString()));
            latestPlus = str.length()+1;
            str.append("+");
            t.setText(str);
        }
        else if (latestPlus > 0 && str.lastIndexOf("+") != str.length()){
            values.add(Integer.valueOf(str.substring(latestPlus).toString()));
            System.out.println(Integer.valueOf(str.substring(latestPlus).toString()));
            latestPlus = str.length()+1;
            str.append("+");
            t.setText(str);
        }
        int j;
        for(j = 0; j<values.size(); j++){
            System.out.println(values.get(j));
        }
        System.out.println("j value: " + j);

    }
    //add number to text and str
    public void numberPressed(View view){
        int i;
        for(i = 0; i < numbers.length; i++){
            if(numbers[i].getId() == view.getId()){
                numbers[i].getText();
                str.append(numbers[i].getText());
                t.setText(str);
                break;
            }
        }
    }

    //clear all
    public void clearPressed(View view){
        t.setText("");
        str = new StringBuilder();
        values.clear();
        latestPlus = -1;
    }

    //show result
    public void equalsPressed(View view){
        for(int j = 0; j<values.size(); j++){
            sum = sum + values.get(j);
        }
        t.setText(sum.toString());
    }
}
