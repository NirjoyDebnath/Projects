package com.example.advancedcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.String;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity<tvdmain> extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdot,bpi,bequal,bplus,bmin,bmul,bdiv,binv,bsqrt,bsquare,bfact,bln,blog,btan,bcos,bsin,bb1,bb2,bac,bnPr,bnCr;
    ImageButton bswitch,bdel,bhis;
    TextView tvmain,tvsec;
    String pi = "3.14159265",tv;
    FirebaseDatabase rootnode;
    DatabaseReference dref,dref2;
    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bpi = findViewById(R.id.bpi);
        bdot = findViewById(R.id.bdot);
        bequal = findViewById(R.id.bequal);
        bplus = findViewById(R.id.bplus);
        bmin = findViewById(R.id.bmin);
        bmul = findViewById(R.id.bmul);
        bdiv = findViewById(R.id.bdiv);
        binv = findViewById(R.id.binv);
        bsqrt = findViewById(R.id.bsqrt);
        bsquare = findViewById(R.id.bsquare);
        bfact = findViewById(R.id.bfact);
        bln = findViewById(R.id.bln);
        blog = findViewById(R.id.blog);
        btan = findViewById(R.id.btan);
        bsin = findViewById(R.id.bsin);
        bcos = findViewById(R.id.bcos);
        bb1 = findViewById(R.id.bb1);
        bb2 = findViewById(R.id.bb2);
        bac = findViewById(R.id.bac);
        bswitch = findViewById(R.id.bswitch);
        bdel = findViewById(R.id.bdel);
        bhis=findViewById(R.id.bhis);
        bnCr=findViewById(R.id.bnCr);
        bnPr=findViewById(R.id.bnPr);

        tvmain = findViewById(R.id.tvmain);
        tvsec = findViewById(R.id.tvsec);


        //onclick listeners
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"0");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+".");
            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText("");
                tvsec.setText("");
                flag=1;
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"+");
            }
        });
        bmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"-");
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"×");
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"÷");
            }
        });
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String val = tvmain.getText().toString();
                double r = Math.sqrt(Double.parseDouble(val));
                tvmain.setText(String.valueOf(r));
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"(");
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+")");
            }
        });
        bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //tvsec.setText(bpi.getText());
                tvmain.setText(tvmain.getText()+pi);
            }
        });
        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"sin");
            }
        });
        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"cos");
            }
        });
        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"tan");
            }
        });
        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"^"+"(-1)");
            }
        });
        bfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(tvmain.getText().toString());
                int fact = factorial(val);
                tvmain.setText(String.valueOf(fact));
                tvsec.setText(val+"!");
            }
        });
        bsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d = Double.parseDouble(tvmain.getText().toString());
                double square = d*d;
                tvmain.setText(String.valueOf(square));
                tvsec.setText(d+"²");
            }
        });
        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"ln");
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tvmain.setText(tvmain.getText()+"log");
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                String replacedstr = val.replace('÷','/').replace('×','*');

                double result=0;
                int value1=0,value2=0,i=0;
                if(flag==1)
                {
                    result=eval(replacedstr);
                }
                else if (flag==2)
                {
                    replacedstr=replacedstr+"c";
                    while(!Character.isLetter(replacedstr.charAt(i)))
                    {
                        int x=Character.getNumericValue(replacedstr.charAt(i));
                        value1=value1*10+x;
                        i++;
                    }
                    i++;
                    while(!Character.isLetter(replacedstr.charAt(i)))
                    {
                        int x=Character.getNumericValue(replacedstr.charAt(i));
                        value2=value2*10+x;
                        i++;
                    }
                    if(value1>=value2)
                    {
                        result=factorial(value1)/factorial(value1-value2);
                    }

                }
                else
                {
                    replacedstr=replacedstr+"c";
                    while(!Character.isLetter(replacedstr.charAt(i)))
                    {
                        int x=Character.getNumericValue(replacedstr.charAt(i));
                        value1=value1*10+x;
                        i++;
                    }
                    i++;
                    while(!Character.isLetter(replacedstr.charAt(i)))
                    {
                        int x=Character.getNumericValue(replacedstr.charAt(i));
                        value2=value2*10+x;
                        i++;
                    }
                    if(value1>=value2)
                    {
                        result=factorial(value1)/(factorial(value1-value2)*factorial(value2));
                    }
                }
                if(value1<value2)
                {
                    tvmain.setText("");
                    tvsec.setText("");
                    Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
                    flag=1;
                }
                else
                {
                    tvmain.setText(String.valueOf(result));
                    tvsec.setText(val);
                    savedata();
                    flag=1;
                }



            }
        });
        bswitch.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent menu=new Intent(MainActivity.this, Finale.class);
                startActivity(menu);
            }
        });

        bhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent his=new Intent(MainActivity.this, Showhistory.class);
                startActivity(his);
            }
        });



        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv=tvmain.getText().toString();
                int i=tv.length();
                if(i>0)
                {
                    tv=tv.substring(0,i-1);
                    //tv = tv.replace(tv.substring(tv.length()-1), "");
                }
                i=tv.length();
                if(i>0&&Character.isLetter(tv.charAt(i-1)))
                {
                    tv=tv.substring(0,i-1);
                    //tv = tv.replace(tv.substring(tv.length()-1), "");
                }
                i=tv.length();
                if(i>0&&Character.isLetter(tv.charAt(i-1)))
                {
                    tv=tv.substring(0,i-1);
                    //tv = tv.replace(tv.substring(tv.length()-1), "");
                }
                tvmain.setText(tv);
            }
        });
        bnPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText()+"P");
                flag=2;
            }
        });
        bnCr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText()+"C");
                flag=3;
            }
        });




    }
    //submenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.sb1){
        Intent i =new Intent(MainActivity.this,sub1.class);
        startActivity(i);
        finish();
        return true;}
        return super.onOptionsItemSelected(item);
    }

    int factorial(int n)
    {
        return (n==1 || n==0) ? 1 : n*factorial(n-1);
    }



    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }

    ArrayList<String> list= new ArrayList<>();
    String xx,x1="None",x2="None",x3="None",x4="None",x5,inp;
    public void savedata()
    {
        String x,y;

        x=tvmain.getText().toString();
        y=tvsec.getText().toString();
        inp=y+"="+x;
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

        History  history=new History(x4,inp,x1,x2,x3);
        dref.setValue(history);
        //Intent intent=new Intent(MainActivity.this,Showhistory.class);
        //startActivity(intent);


    }
}