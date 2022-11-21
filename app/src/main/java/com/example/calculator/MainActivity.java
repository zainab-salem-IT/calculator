package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity  {
    private static final char plus='+';
    private static final char minus='-';
    private static final char divided='/';
    private static final char multy='*';
    private char currentsymbl;
    private double firstvalue=Double.NaN;
    private double secondvalue;
    private TextView input,output;
    private DecimalFormat decimalFormat;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttondot;
   private Button buttonequal,buttobplus,buttonmultiply,buttonminus,buttondivide,buttondelet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat=new DecimalFormat("#.###########");
        output=findViewById(R.id.result);
        input=findViewById(R.id.solution);
        buttondelet=findViewById(R.id.button16);
        buttobplus=findViewById(R.id.button13);
        buttonminus=findViewById(R.id.button11);
        buttonmultiply=findViewById(R.id.button12);
        buttonequal=findViewById(R.id.button17);
        buttondivide=findViewById(R.id.button10);
        button0=findViewById(R.id.button15);
        buttondot =findViewById(R.id.button14);
        button1=findViewById(R.id.button7);
        button2=findViewById(R.id.button8);
        button3=findViewById(R.id.button9);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button);
        button8=findViewById(R.id.button2);
        button9=findViewById(R.id.button3);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"9");
            }
        });
        buttobplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               allcalculated();
               currentsymbl=plus;
               output.setText(decimalFormat.format(firstvalue)+"+");
               input.setText(null);
            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allcalculated();
                currentsymbl=minus;
                output.setText(decimalFormat.format(firstvalue)+"-");
                input.setText(null);
            }
        });
        buttondivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allcalculated();
                currentsymbl=divided;
                output.setText(decimalFormat.format(firstvalue)+"/");
                input.setText(null);
            }
        });
        buttonmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allcalculated();
                currentsymbl=multy;
                output.setText(decimalFormat.format(firstvalue)+"*");
                input.setText(null);
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(decimalFormat.format(firstvalue)+".");
            }
        });
        buttondelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().length()> 0)
                {
                    CharSequence currenttext=input.getText();
                    input.setText(currenttext.subSequence(0,currenttext.length()-1));
                }
                else {
                    firstvalue=Double.NaN;
                    secondvalue=Double.NaN;
                    input.setText("");
                    output.setText("");
                }
            }
        });
        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allcalculated();

                output.setText(decimalFormat.format(firstvalue));
                firstvalue=Double.NaN;
                currentsymbl='0';
            }
        });


    }

    private void allcalculated()
    {
        if(!Double.isNaN(firstvalue)) {
            secondvalue = Double.parseDouble(input.getText().toString());
            input.setText(null);
            if (currentsymbl == plus)
                firstvalue = this.firstvalue + secondvalue;
            else if (currentsymbl == minus)
                firstvalue = this.firstvalue - secondvalue;
            else if (currentsymbl == multy)
                firstvalue = this.firstvalue * secondvalue;
            else if (currentsymbl == divided)
                firstvalue = this.firstvalue / secondvalue;
        }
        else
            try {
             firstvalue=Double.parseDouble(input.getText().toString());
           } catch (Exception e){
        }
    }
    }
