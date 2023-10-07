package com.example.advancedcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Currency extends AppCompatActivity {

    String[] curs;
    private Spinner inputspinner,outputspinner;
    private EditText inputcur,outputcur;
    ImageButton curanswer,mb,cb;
    FirebaseDatabase rootnode;
    DatabaseReference dref,dref2;
    TextView showdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);
        curs=getResources().getStringArray(R.array.curs);
        inputspinner=findViewById(R.id.inputspinner);
        outputspinner=findViewById(R.id.outputspinner);
        inputcur=findViewById(R.id.inputcur);
        outputcur=findViewById(R.id.outputcur);
        showdate=findViewById(R.id.showdate);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample,R.id.spinner,curs);
        inputspinner.setAdapter(adapter);
        outputspinner.setAdapter(adapter);
        curanswer=findViewById(R.id.curanswer);
        curanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                savedata();
            }
        });
    }
    String USD,E,CAD,BIT,RUP,DATE;
    public void savedata()
    {
        rootnode=FirebaseDatabase.getInstance();
        dref2=rootnode.getReference().child("Currencyinfo");
        dref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                USD= snapshot.child("dol").getValue().toString();
                E= snapshot.child("euro").getValue().toString();
                CAD= snapshot.child("cad").getValue().toString();
                BIT= snapshot.child("bit").getValue().toString();
                RUP= snapshot.child("rup").getValue().toString();
                DATE= snapshot.child("date").getValue().toString();
                //outputcur.setText(USD);
                String value,type1,type2;
                double input;
                double val;

                value=inputcur.getText().toString();
                input=Double.parseDouble(value);
                type1=inputspinner.getSelectedItem().toString();
                type2=outputspinner.getSelectedItem().toString();
                if(type1.equals("US Dollar"))
                {
                    val=Double.parseDouble(USD);
                    input=input*val;
                }
                else if (type1.equals("Euro"))
                {
                    val=Double.parseDouble(E);
                    input=input*val;
                }
                else if (type1.equals("CAD"))
                {
                    val=Double.parseDouble(CAD);
                    input=input*val;
                }
                else if (type1.equals("Bitcoin"))
                {
                    val=Double.parseDouble(BIT);
                    input=input*val;
                }
                else if (type1.equals("Rupee"))
                {
                    val=Double.parseDouble(RUP);
                    input=input*val;
                }
                if(type2.equals("US Dollar"))
                {
                    val=Double.parseDouble(USD);
                    input=input/val;
                    type2=String.format("%.2f",input);
                    outputcur.setText(type2);
                }
                else if (type2.equals("Euro"))
                {
                    val=Double.parseDouble(E);
                    input=input/val;
                    type2=String.format("%.2f",input);
                    outputcur.setText(type2);
                }
                else if (type2.equals("CAD"))
                {
                    val=Double.parseDouble(CAD);
                    input=input/val;
                    type2=String.format("%.2f",input);
                    outputcur.setText(type2);
                }
                else if (type2.equals("Bitcoin"))
                {
                    val=Double.parseDouble(BIT);
                    input=input/val;
                    type2=String.format("%.2f",input);
                    outputcur.setText(type2);
                }
                else if (type2.equals("Rupee"))
                {
                    val=Double.parseDouble(RUP);
                    input=input/val;
                    type2=String.format("%.2f",input);
                    outputcur.setText(type2);
                }
                else
                {
                    type2=String.format("%.2f",input);
                    outputcur.setText(type2);
                }
                showdate.setText("Last Update "+DATE);
                //outputcur.setText(USD);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        //outputcur.setText(USD);
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Currency.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Currency.this,MainActivity.class);
                startActivity(m2);
            }
        });

    }
}