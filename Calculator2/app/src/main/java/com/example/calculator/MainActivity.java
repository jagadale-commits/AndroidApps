package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

import static com.example.calculator.MathCalculate.CalculateExpression;

public class MainActivity extends AppCompatActivity {
    private EditText usersInputBox;
    private Button backspace;
    private Button btnClear;
    private Button btnPar;
    private Button btnPercent;
    private Button btnDivide;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnMultiply;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnMinus;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnPlus;
    private Button btnPlus_Minus;
    private Button btnZero;
    private Button btnDecimal;
    private Button btnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        //clear all text in users input
        usersInputBox.setText("");

        backspace.setOnClickListener(v -> {
            //gets the cursors position
            int cursorPosEnd = usersInputBox.getSelectionEnd();
            int textLength = usersInputBox.getText().length();

            if (cursorPosEnd != 0 && textLength != 0){
                SpannableStringBuilder selection = (SpannableStringBuilder) usersInputBox.getText();
                selection.replace(cursorPosEnd - 1, cursorPosEnd, "");
                //updates the text
                usersInputBox.setText(selection);
                //puts the cursor back in the correct spot
                usersInputBox.setSelection(cursorPosEnd - 1);
            }
        });

        btnZero.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("0", usersInputBox.getText().toString(), pos));
            usersInputBox.setSelection(pos + 1);
        });

        btnOne.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("1", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnTwo.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("2", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnThree.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("3", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnFour.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("4", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnFive.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("5", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnSix.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("6", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnSeven.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("7", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnEight.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("8", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnNine.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("9", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnClear.setOnClickListener(v -> usersInputBox.setText(""));

        btnPercent.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("%", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnPlus_Minus.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("-", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnDecimal.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText(".", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnEqual.setOnClickListener(v -> {
            String expression = usersInputBox.getText().toString();

            String result = String.valueOf(CalculateExpression(expression));

            usersInputBox.setText(result);
            usersInputBox.setSelection(result.length());

        });

        btnDivide.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("/", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnMultiply.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("*", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnMinus.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("-", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnPlus.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            usersInputBox.setText(updateText("+", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            usersInputBox.setSelection(pos + 1);
        });

        btnPar.setOnClickListener(v -> {
            int pos = usersInputBox.getSelectionStart();
            int openPar = 0;
            int closedPar = 0;
            int inboxLength = usersInputBox.getText().toString().length();

            for (int i = 0; i < usersInputBox.getSelectionStart(); i++){
                if (usersInputBox.getText().toString().charAt(i) == '('){
                    openPar += 1;
                }
                else if (usersInputBox.getText().toString().charAt(i) == ')'){
                    closedPar += 1;
                }
            }

            if (openPar == closedPar || usersInputBox.getText().toString().charAt(inboxLength - 1) == '('){
                usersInputBox.setText(updateText("(", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            }
            else if (closedPar < openPar && usersInputBox.getText().toString().charAt(inboxLength - 1) != '('){
                usersInputBox.setText(updateText(")", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
            }
            usersInputBox.setSelection(pos + 1);
        });

    }

    private void setupUI(){
        usersInputBox = findViewById(R.id.textView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            usersInputBox.setShowSoftInputOnFocus(false);   //used to prevent the users keyboard from popping up but keeps the carrot
        }

        backspace = findViewById(R.id.backspace);

        btnClear = findViewById(R.id.clear);
        btnPar = findViewById(R.id.parentheses);
        btnPercent = findViewById(R.id.exponent);
        btnDivide = findViewById(R.id.divide);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);
        btnMultiply = findViewById(R.id.multiply);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnSix = findViewById(R.id.six);
        btnMinus = findViewById(R.id.minus);
        btnOne = findViewById(R.id.one);
        btnTwo = findViewById(R.id.two);
        btnThree = findViewById(R.id.three);
        btnPlus = findViewById(R.id.add);
        btnPlus_Minus = findViewById(R.id.plusMinus);
        btnZero = findViewById(R.id.zero);
        btnDecimal = findViewById(R.id.point);
        btnEqual = findViewById(R.id.equals);
    }

    private String updateText(String stringToAdd, String oldString, int cursorPos){
        String leftOfCursor = oldString.substring(0, cursorPos);
        String rightOfCursor = oldString.substring(cursorPos);

        return leftOfCursor + stringToAdd + rightOfCursor;

    }
}