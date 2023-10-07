package com.example.advancedcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Showhistory extends AppCompatActivity {

    FirebaseDatabase rootnode;
    DatabaseReference dref,dref2;
    String xx;
    String x1,x2,x3,x4,x5,inp;
    TextView showh,showh1,showh2,showh3,showh4;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhistory);
        String x,y;
        showh=findViewById(R.id.showh);
        showh1=findViewById(R.id.showh1);
        showh2=findViewById(R.id.showh2);
        showh3=findViewById(R.id.showh3);
        showh4=findViewById(R.id.showh4);


        //inp="2";

        rootnode=FirebaseDatabase.getInstance();
        dref=rootnode.getReference("History");
        dref2=rootnode.getReference().child("History");
        dref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                x1= snapshot.child("i2").getValue().toString();
                x2= snapshot.child("i3").getValue().toString();
                x3= snapshot.child("i4").getValue().toString();
                x4= snapshot.child("i5").getValue().toString();
                x5= snapshot.child("input").getValue().toString();
                showh.setText(x1);
                showh1.setText(x2);
                showh2.setText(x3);
                showh3.setText(x4);
                showh4.setText(x5);
                //tvsec.setText(x1+"a"+x2+"s"+x3+"d"+x4);
                //tvmain.setText(x1);
                //tvsec.setText(x4);
                //dref2.child("i5").setValue(x3);
                //dref2.child("i4").setValue(x2);
                //dref2.child("i3").setValue(x1);
                //dref2.child("i2").setValue(x4);

                //dref2.child("i2").setValue(inp);


                //History  history=new History(x4,input,x1,x2,x3);
                //dref.setValue(history);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //tvsec.setText(x1+"a"+x2+"s"+x3+"d"+x4);


        //dref.push().setValue(input);

        //History  history=new History(x4,inp,x1,x2,x3);
        //dref.setValue(history);
        //Intent intent=new Intent(MainActivity.this,Showhistory.class);
        //startActivity(intent);
    }
    String yy=xx;
}