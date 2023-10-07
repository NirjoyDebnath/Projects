package com.example.advancedcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.String;
import java.util.ArrayList;
import java.util.Objects;

public class BMI extends AppCompatActivity {
    EditText height, weight;
    TextView resulttext;
    String calculation, BMIresult;
    Button calulateBMI ;
    ImageButton mb,cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);
        calulateBMI=findViewById(R.id.calulateBMI);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);

        calulateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = weight.getText().toString();
                String s2 = height.getText().toString();
                float weightvalue = Float.parseFloat(s1);
                float heightvalue = Float.parseFloat(s2);
                float bmi = (float) (weightvalue*10000 / (heightvalue * heightvalue*2.54*2.54));
                if (bmi < 16) {
                    BMIresult = "Severly Under weight";
                } else if (bmi < 18.5) {
                    BMIresult = "Under Weight";
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    BMIresult = "Normal Weight";
                } else if (bmi >= 25 && bmi <= 29.9) {
                    BMIresult = "Over Weight";
                } else {
                    BMIresult = "Obese";
                }
                calculation="\n"+bmi+"\n"+BMIresult;
                resulttext.setText(calculation);

            }




        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(BMI.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(BMI.this,MainActivity.class);
                startActivity(m2);
            }
        });


    }

}
