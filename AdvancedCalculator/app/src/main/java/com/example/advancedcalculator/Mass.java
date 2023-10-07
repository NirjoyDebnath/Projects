package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Mass extends AppCompatActivity {

    String[] masses;
    private Spinner inputspinner,outputspinner;
    private EditText inputmass,outputmass;
    ImageButton massanswer,mb,cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);
        masses=getResources().getStringArray(R.array.masses);
        inputspinner=findViewById(R.id.inputspinner);
        outputspinner=findViewById(R.id.outputspinner);
        inputmass=findViewById(R.id.inputmass);
        outputmass=findViewById(R.id.outputmass);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample,R.id.spinner,masses);
        inputspinner.setAdapter(adapter);
        outputspinner.setAdapter(adapter);
        massanswer=findViewById(R.id.massanswer);
        massanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value,type1,type2;
                double input;
                value=inputmass.getText().toString();
                input=Double.parseDouble(value);
                type1=inputspinner.getSelectedItem().toString();
                type2=outputspinner.getSelectedItem().toString();
                if(type1.equals("Tonne"))
                {
                    input=input*1000000;
                }
                else if (type1.equals("Kilogram"))
                {
                    input=input*1000;
                }
                else if (type1.equals("Gram"))
                {
                    input=input;
                }
                else if (type1.equals("Milligram"))
                {
                    input=input/1000;
                }
                else if (type1.equals("Microgram"))
                {
                    input=input/1000000;
                }
                else if (type1.equals("Quintal"))
                {
                    input=input*100000;
                }
                else if (type1.equals("Pound"))
                {
                    input=input*453.592;
                }
                else if (type1.equals("Ounce"))
                {
                    input=input*28.3495;
                }
                else if (type1.equals("Carat"))
                {
                    input=input/5;
                }
                if(type2.equals("Tonne"))
                {
                    input=input/1000000;
                    type2=String.format("%.6f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Kilogram"))
                {
                    input=input/1000;
                    type2=String.format("%.4f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Gram"))
                {
                    input=input;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Milligram"))
                {
                    input=input*1000;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Microgram"))
                {
                    input=input*1000000;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Quintal"))
                {
                    input=input/100000;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Pound"))
                {
                    input=input/453.592;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Ounce"))
                {
                    input=input/28.3495;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
                else if (type2.equals("Carat"))
                {
                    input=input*5;
                    type2=String.format("%.2f",input);
                    outputmass.setText(type2);
                }
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Mass.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Mass.this,MainActivity.class);
                startActivity(m2);
            }
        });
    }
}