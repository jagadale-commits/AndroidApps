package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8,button9, button0;
    Button buttoneq, buttonplus, buttonminus, buttonmult, buttondiv, buttonclear, buttondot;

    EditText Answer;
    float Res1, Res2;
    Boolean A, S, M, D;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button0 = (Button)findViewById(R.id.button0);
        buttondot = (Button)findViewById(R.id.buttondot);
        buttoneq = (Button)findViewById(R.id.buttoneq);
        buttonclear = (Button)findViewById(R.id.buttonclear);
        buttonplus = (Button)findViewById(R.id.buttonplus);
        buttonminus = (Button)findViewById(R.id.buttonminus);
        buttonmult = (Button)findViewById(R.id.buttonmult);
        buttondiv = (Button)findViewById(R.id.buttondiv);
        Answer = (EditText) findViewById(R.id.Answer);

        button0.setOnClickListener(view -> Answer.setText(Answer.getText() + "0"));

        button1.setOnClickListener(view -> Answer.setText(Answer.getText() + "1"));

        button2.setOnClickListener(view -> Answer.setText(Answer.getText() + "2"));

        button3.setOnClickListener(view -> Answer.setText(Answer.getText() + "3"));

        button4.setOnClickListener(view -> Answer.setText(Answer.getText() + "4"));

        button5.setOnClickListener(view -> Answer.setText(Answer.getText() + "5"));

        button6.setOnClickListener(view -> Answer.setText(Answer.getText() + "6"));

        button7.setOnClickListener(view -> Answer.setText(Answer.getText() + "7"));

        button8.setOnClickListener(view -> Answer.setText(Answer.getText() + "8"));

        button9.setOnClickListener(view -> Answer.setText(Answer.getText() + "9"));

        buttondot.setOnClickListener(view -> Answer.setText(Answer.getText() + "."));

        buttonplus.setOnClickListener(view -> {
            if(Answer.getText().toString().trim().length() == 0) {
                Answer.setText("");
            }
            else{
                Res1 = Float.parseFloat( Answer.getText()+ "");
                A = true;
                Answer.setText("");
            }
        });

        buttonminus.setOnClickListener(view -> {
            if(Answer.getText().toString().trim().length() == 0 ) {
                Answer.setText("");
            }
            else{
                Res1 = Float.parseFloat( Answer.getText()+ "");
                S = true;
                Answer.setText("");
            }
        });

        buttonmult.setOnClickListener(view -> {
            if(Answer.getText().toString().trim().length() == 0) {
                Answer.setText("");
            }
            else{
                Res1 = Float.parseFloat( Answer.getText()+ "");
                M = true;
                Answer.setText("");
            }
        });

        buttondiv.setOnClickListener(view -> {
            if(Answer.getText().toString().trim().length() == 0) {
                Answer.setText("");
            }
            else{
                Res1 = Float.parseFloat( Answer.getText()+ "");
                D = true;
                Answer.setText("");
            }
        });

        buttoneq.setOnClickListener(view -> {
            if(Answer.getText().toString().trim().length() == 0 ) {
                Answer.setText("");
            }
                Res2 = Float.parseFloat( Answer.getText()+ "");
                if(A!=null && A)
                {
                    Answer.setText(Res1+Res2 + "");
                    A = false;
                }

                if(S!=null && S)
                {
                    Answer.setText(Res1 - Res2 + "");
                    S = false;
                }

                if(M!=null && M)
                {
                    Answer.setText(Res1 * Res2 + "");
                    M = false;
                }

                if(D!=null && D)
                {
                    Answer.setText(Res1 / Res2 + "");
                    D = false;
                }
        });

        buttonclear.setOnClickListener(view -> Answer.setText(""));
    }
}