package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Finale extends AppCompatActivity {

    ImageButton  bmi,tem,unit,cur,num,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalmenu);
        bmi=findViewById(R.id.bmi);
        tem=findViewById(R.id.tem);
        unit=findViewById(R.id.unit);
        cur=findViewById(R.id.cur);
        num=findViewById(R.id.num);
        time=findViewById(R.id.time);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent bm=new Intent(Finale.this,BMI.class);
                startActivity(bm);
            }
        });
        tem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tem=new Intent(Finale.this,Temperature.class);
                startActivity(tem);
            }
        });
        unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unit=new Intent(Finale.this,Unimenu.class);
                startActivity(unit);
            }
        });
        cur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currency=new Intent(Finale.this,Currency.class);
                startActivity(currency);
            }
        });
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersystem=new Intent(Finale.this,Numbersystem.class);
                startActivity(numbersystem);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent time=new Intent(Finale.this,Time.class);
                startActivity(time);
            }
        });
    }
}