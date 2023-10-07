package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Numbersystem extends AppCompatActivity {

    String[] numbers;
    private Spinner inputspinner,outputspinner;
    private EditText inputnumber,outputnumber;
    ImageButton numberanswer,mb,cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbersystem);
        cb = findViewById(R.id.cb);
        mb = findViewById(R.id.mb);
        numbers=getResources().getStringArray(R.array.numbers);
        inputspinner=findViewById(R.id.inputspinner);
        outputspinner=findViewById(R.id.outputspinner);
        inputnumber=findViewById(R.id.inputnumber);
        outputnumber=findViewById(R.id.outputnumber);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample,R.id.spinner,numbers);
        inputspinner.setAdapter(adapter);
        outputspinner.setAdapter(adapter);
        numberanswer=findViewById(R.id.numberanswer);

        numberanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value,type1,type2,output;
                value=inputnumber.getText().toString();
                String input = inputnumber.getText().toString();
                int decimal = 0,i;
                boolean flag=false;

                type1=inputspinner.getSelectedItem().toString();
                type2=outputspinner.getSelectedItem().toString();
                if(!type1.equals("HexaDecimal"))
                {
                    for(i=0;i<value.length();i++)
                    {
                        if(Character.isLetter(value.charAt(i)))
                        {
                            flag=true;
                        }
                    }
                }
                else
                {
                    for(i=0;i<value.length();i++)
                    {
                        if(value.charAt(i)!='a'&&value.charAt(i)!='b'&&value.charAt(i)!='c'&&value.charAt(i)!='d'&&value.charAt(i)!='e'&&value.charAt(i)!='f')
                        {
                            flag=true;
                        }
                    }
                }
                if(type1.equals("Binary")&&flag==false)
                {
                    decimal = Integer.parseInt(input, 10);
                    while(decimal!=0)
                    {
                        if(decimal%10>1)
                        {
                            flag=true;
                        }
                        decimal=decimal/10;
                    }
                    if(flag==false)decimal = Integer.parseInt(input, 2);
                }
                else if (type1.equals("Octal")&&flag==false)
                {
                    decimal = Integer.parseInt(input, 10);
                    while(decimal!=0)
                    {
                        if(decimal%10>8)
                        {
                            flag=true;
                        }
                        decimal=decimal/10;
                    }
                    if(flag==false)decimal = Integer.parseInt(input, 8);
                }
                else if (type1.equals("HexaDecimal")&&flag==false)
                {
                    decimal = Integer.parseInt(input, 16);
                }
                else if(flag==false)
                {
                    decimal = Integer.parseInt(input, 10);
                }
                if(flag==true)
                {
                    //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
                }
                else if(type2.equals("Binary"))
                {
                    output = Integer.toBinaryString(decimal);
                    outputnumber.setText(output);
                }
                else if (type2.equals("Octal"))
                {
                    output = Integer.toOctalString(decimal);
                    outputnumber.setText(output);
                }
                else if (type2.equals("Decimal"))
                {
                    output = Integer.toString(decimal);
                    outputnumber.setText(output);
                }
                else if (type2.equals("HexaDecimal"))
                {
                    output = Integer.toHexString(decimal);
                    outputnumber.setText(output);
                }
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m1=new Intent(Numbersystem.this,Finale.class);
                startActivity(m1);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent m2=new Intent(Numbersystem.this,MainActivity.class);
                startActivity(m2);
            }
        });
    }
}