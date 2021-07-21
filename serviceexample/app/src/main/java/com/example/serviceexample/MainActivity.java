package com.example.serviceexample;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends Activity implements View.OnClickListener {
    Button buttonStart, buttonStop,buttonNext;
    String msg = "Main Activity : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonNext = findViewById(R.id.buttonNext);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        Log.d(msg, "The onCreate() event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event - activity has become visible");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event - another activity ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event - activity is invisible");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event - destroyed");
    }
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.buttonStart:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.buttonStop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.buttonNext:
                Intent intent=new Intent(this,AnotherPage.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + src.getId());
        }
    }
}