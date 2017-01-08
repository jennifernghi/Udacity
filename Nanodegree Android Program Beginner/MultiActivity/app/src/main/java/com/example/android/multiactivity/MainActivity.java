package com.example.android.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    public int number =0;

    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
    public int plus(){
        return number += 1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        // Do something in response to button

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("number", plus());
        startActivity(intent);

    }
}
