package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Unimenu extends AppCompatActivity {
    ImageButton len,mass,cb,mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unimenu);
        len=findViewById(R.id.len);
        mass=findViewById(R.id.mass);
        mb=findViewById(R.id.mb);
        cb=findViewById(R.id.cb);
        len.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent bm=new Intent(Unimenu.this,Unit.class);
                startActivity(bm);
            }
        });
        mass.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m=new Intent(Unimenu.this,Mass.class);
                startActivity(m);
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Unimenu.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Unimenu.this,MainActivity.class);
                startActivity(m2);
            }
        });

    }
}