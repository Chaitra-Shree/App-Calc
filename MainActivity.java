package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button equ;
    private Button decimal;
    private Button zero;
    private Button dzero;
    private Button clear;
    private Button bspace;
    private Button bkt;

    private TextView ip;
    private TextView res;

    private double val1 = Double.NaN;
    private double val2;
    private char action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"0");
            }
        });

        dzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"00");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    ip.setText(null);
                    res.setText(null);
            }
        });

        bspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ip.getText().length() > 0) {
                    CharSequence name = ip.getText().toString();
                    ip.setText(name.subSequence(0, name.length() - 1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    ip.setText(null);
                    res.setText(null);
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip.setText(ip.getText().toString()+"9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '+';
                res.setText(String.valueOf(val1) + "+");
                ip.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '-';
                res.setText(String.valueOf(val1) + "-");
                ip.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = 'x';
                res.setText(String.valueOf(val1) + "x");
                ip.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '÷';
                res.setText(String.valueOf(val1) + "÷ ");
                ip.setText(null);
            }
        });

        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '=';
                res.setText(res.getText().toString() + String.valueOf(val2) + "="+ String.valueOf(val1));
                ip.setText(null);
            }
        });
    }

    private void setView(){
        one = (Button)findViewById(R.id.b1);
        two = (Button)findViewById(R.id.b2);
        three = (Button)findViewById(R.id.b3);
        four = (Button)findViewById(R.id.b4);
        five = (Button)findViewById(R.id.b5);
        six = (Button)findViewById(R.id.b6);
        seven = (Button)findViewById(R.id.b7);
        eight = (Button)findViewById(R.id.b8);
        nine = (Button)findViewById(R.id.b9);
        add = (Button)findViewById(R.id.badd);
        sub = (Button)findViewById(R.id.bsub);
        mul = (Button)findViewById(R.id.bmul);
        div = (Button)findViewById(R.id.bdiv);
        equ = (Button)findViewById(R.id.bequ);
        decimal = (Button)findViewById(R.id.bdeci);
        zero = (Button)findViewById(R.id.b0);
        dzero = (Button)findViewById(R.id.b00);
        clear = (Button)findViewById(R.id.bclear);
        bspace = (Button)findViewById(R.id.backsp);
        bkt = (Button)findViewById(R.id.bbraket);

        ip = (TextView) findViewById(R.id.textip);
        res = (TextView) findViewById(R.id.textres);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(ip.getText().toString());

            switch(action){
                case '+':
                        val1 = val1 + val2;
                        break;
                case '-':
                    val1 = val1 - val2;
                    break;

                case 'x':
                    val1 = val1 * val2;
                    break;

                case '÷':
                    val1 = val1 / val2;
                    break;

                case '=':
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(ip.getText().toString());
        }
    }
}
