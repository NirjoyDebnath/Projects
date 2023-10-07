package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Time extends AppCompatActivity {

    String[] times;
    private Spinner inputspinner,outputspinner;
    private EditText inputtime,outputtime;
    ImageButton timeanswer,mb,cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);

        times=getResources().getStringArray(R.array.times);
        inputspinner=findViewById(R.id.inputspinner);
        outputspinner=findViewById(R.id.outputspinner);
        inputtime=findViewById(R.id.inputtime);
        outputtime=findViewById(R.id.outputtime);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample,R.id.spinner,times);
        inputspinner.setAdapter(adapter);
        outputspinner.setAdapter(adapter);
        timeanswer=findViewById(R.id.timeanswer);

        timeanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value,type1,type2;
                double input;
                value=inputtime.getText().toString();
                input=Double.parseDouble(value);
                type1=inputspinner.getSelectedItem().toString();
                type2=outputspinner.getSelectedItem().toString();
                if (type1.equals("Month"))
                {
                    input=input*30*24*60*60*1000;
                }
                else if (type1.equals("Week"))
                {
                    input=input*7*24*60*60*1000;
                }
                else if (type1.equals("Day"))
                {
                    input=input*24*60*60*1000;
                }
                else if (type1.equals("Hour"))
                {
                    input=input*60*60*1000;
                }
                else if (type1.equals("Minute"))
                {
                    input=input*60*1000;
                }
                else if (type1.equals("Second"))
                {
                    input=input*1000;
                }
                if (type2.equals("Month"))
                {
                    input=input/30/24/60/60/1000;
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
                else if (type2.equals("Week"))
                {
                    input=input/7/24/60/60/1000;
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
                else if (type2.equals("Day"))
                {
                    input=input/24/60/60/1000;
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
                else if (type2.equals("Hour"))
                {
                    input=input/60/60/1000;
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
                else if (type2.equals("Minute"))
                {
                    input=input/60/1000;
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
                else if (type2.equals("Second"))
                {
                    input=input/1000;
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
                else
                {
                    type2=String.format("%.2f",input);
                    outputtime.setText(type2);
                }
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Time.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Time.this,MainActivity.class);
                startActivity(m2);
            }
        });
    }
}