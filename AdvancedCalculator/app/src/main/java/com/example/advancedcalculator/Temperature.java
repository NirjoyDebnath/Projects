package com.example.advancedcalculator;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Temperature extends AppCompatActivity {

    String[] temps;
    private Spinner inputspinner,outputspinner;
    private EditText inputtem,outputtem;
    ImageButton tempanswer,mb,cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);
        temps=getResources().getStringArray(R.array.temps);
        inputspinner=findViewById(R.id.inputspinner);
        outputspinner=findViewById(R.id.outputspinner);
        inputtem=findViewById(R.id.inputtem);
        outputtem=findViewById(R.id.outputtem);

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,R.layout.sample,R.id.spinner,temps);
        inputspinner.setAdapter(adapter);
        outputspinner.setAdapter(adapter);
        tempanswer=findViewById(R.id.tempanswer);
        tempanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value,type1,type2;
                double input;
                value=inputtem.getText().toString();
                input=Double.parseDouble(value);
                type1=inputspinner.getSelectedItem().toString();
                type2=outputspinner.getSelectedItem().toString();
                if(type1.equals("Fahrenheit"))
                {
                    input=(input-32.00)/1.8;
                }
                else if (type1.equals("Kelvin"))
                {
                    input=input-273;
                }
                if(type2.equals("Fahrenheit"))
                {
                    input=input*(5.00/9.00)+32.00;
                    type2=String.format("%.2f",input);
                    outputtem.setText(type2);
                }
                else if (type2.equals("Kelvin"))
                {
                    input=input+273;
                    type2=String.format("%.2f",input);
                    outputtem.setText(type2);
                }
                else
                {
                    type2=String.format("%.2f",input);
                    outputtem.setText(type2);
                }
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Temperature.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Temperature.this,MainActivity.class);
                startActivity(m2);
            }
        });

    }
}