package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    String[] stringid;
    private Spinner spinnerid;
    private Button buttonid;
    private TextView textViewid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        stringid = getResources().getStringArray(R.array.temps);

        spinnerid = (Spinner) findViewById(R.id.spinnerid);
        buttonid = (Button) findViewById(R.id.buttonid);
        textViewid = (TextView) findViewById(R.id.textviewid);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.sample,R.id.spinner,stringid);
        spinnerid.setAdapter(adapter);
    }
}