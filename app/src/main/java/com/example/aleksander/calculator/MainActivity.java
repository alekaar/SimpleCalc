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
    int sum;
    StringBuilder str;
    Button[] numbers = new Button[10];
    ArrayList<Integer> values = new ArrayList<>();
    int latestPlus = -1;
    //Button[] numbers = getResources().obtainTypedArray(R.array.button_id_array);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        add = (Button)findViewById(R.id.addButton);


    }

    //add number to text and str
    public void buttonPressed(View view){
        int i;

        if(view.getId() == R.id.addButton
                && str.length() > 0
                && str.lastIndexOf("+") != str.length()){
            str.append("+");
            t.setText(str);
        }
        else if(view.getId() == R.id.clear){
            t.setText("");
            str = new StringBuilder();
            values.clear();
        }

        for(i = 0; i < numbers.length; i++){
            if(numbers[i].getId() == view.getId()){
                numbers[i].getText();
                str.append(numbers[i].getText());
                t.setText(str);
                break;
            }
        }
        System.out.println(str + "|end");
    }

    //show result
    public void equalsPressed(View view){
        String[] temp = str.toString().split("\\+");
        for(int j = 0; j<temp.length; j++){
            sum = sum + Integer.valueOf(temp[j]);
            System.out.println(temp[j]);
        }
        t.setText(Integer.toString(sum));
        str = new StringBuilder();
        sum = 0;
    }
}
