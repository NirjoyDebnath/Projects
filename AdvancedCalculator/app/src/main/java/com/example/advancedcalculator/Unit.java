package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Unit extends AppCompatActivity {

    String[] units;
    private Spinner inputspinner,outputspinner;
    private EditText inputunit,outputunit;
    ImageButton unitanswer,mb,cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);
        units=getResources().getStringArray(R.array.units);
        inputspinner=findViewById(R.id.inputspinner);
        outputspinner=findViewById(R.id.outputspinner);
        inputunit=findViewById(R.id.inputunit);
        outputunit=findViewById(R.id.outputunit);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample,R.id.spinner,units);
        inputspinner.setAdapter(adapter);
        outputspinner.setAdapter(adapter);
        unitanswer=findViewById(R.id.unitanswer);
        unitanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value,type1,type2;
                double input;
                value=inputunit.getText().toString();
                input=Double.parseDouble(value);
                type1=inputspinner.getSelectedItem().toString();
                type2=outputspinner.getSelectedItem().toString();
                if(type1.equals("Kilometer"))
                {
                    input=input*1000;
                }
                else if (type1.equals("Centimeter"))
                {
                    input=input/100;
                }
                else if (type1.equals("Millimete"))
                {
                    input=input/1000;
                }
                else if (type1.equals("Micrometer"))
                {
                    input=input/1000000;
                }
                else if (type1.equals("Nanometer"))
                {
                    input=input/1000000000;
                }
                if(type2.equals("Kilometer"))
                {
                    input=input/1000;
                    type2=String.format("%.2f",input);
                    outputunit.setText(type2);
                }
                else if (type2.equals("Centimeter"))
                {
                    input=input*100;
                    type2=String.format("%.2f",input);
                    outputunit.setText(type2);
                }
                else if (type2.equals("Millimete"))
                {
                    input=input*1000;
                    type2=String.format("%.2f",input);
                    outputunit.setText(type2);
                }
                else if (type2.equals("Micrometer"))
                {
                    input=input*1000000;
                    type2=String.format("%.6f",input);
                    outputunit.setText(type2);
                }
                else if (type2.equals("Nanometer"))
                {
                    input=input*1000000000;
                    type2=String.format("%.9f",input);
                    outputunit.setText(type2);
                }
                else
                {
                    type2=String.format("%.2f",input);
                    outputunit.setText(type2);
                }
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Unit.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Unit.this,MainActivity.class);
                startActivity(m2);
            }
        });

    }
}