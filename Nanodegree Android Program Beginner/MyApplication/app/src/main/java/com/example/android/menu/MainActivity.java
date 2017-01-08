package com.example.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView text1 = (TextView) findViewById(R.id.menu_item_1);
        Log.i("MainActivity.java",text1.getText().toString());

        // Find second menu item TextView and print the text to the logs
        TextView text2 = (TextView) findViewById(R.id.menu_item_2);
        Log.i("MainActivity.java",text2.getText().toString());
        // Find third menu item TextView and print the text to the logs
        TextView text3 = (TextView) findViewById(R.id.menu_item_3);
        Log.i("MainActivity.java",text3.getText().toString());
    }
}
