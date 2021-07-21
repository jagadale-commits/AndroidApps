package com.example.serviceexample;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;

public class AnotherPage extends Activity {
    String msg = "Second Activity : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_page);
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
}