package com.example.android.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Main", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Main", "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("main","onresume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("main","onrestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("main","onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Main", "onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("main", "ondestroy");
    }
}
