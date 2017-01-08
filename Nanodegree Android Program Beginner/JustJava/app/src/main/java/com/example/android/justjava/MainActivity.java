package com.example.android.justjava;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity =2;//global scope
    boolean hasWhippedCreamChecked = false;
    boolean hasChocolateChecked = false;
    int pricePerCup =5;
    int whippedCreamPrice = 1;
    int chocolatePrice = 2;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        CheckBox chocolateCheck = (CheckBox) findViewById(R.id.chocolate_check_box);
        hasWhippedCreamChecked = whippedCreamCheck.isChecked();
        hasChocolateChecked = chocolateCheck.isChecked();
        if(hasWhippedCreamChecked)
        {
            Log.i("MainActivity","whipped cream is checked");
        }else {
            Log.i("MainActivity","whipped cream is unchecked");
        }

        if(hasChocolateChecked)
        {
            Log.i("MainActivity","chocolate is checked");
        }else {
            Log.i("MainActivity","chocolate is unchecked");
        }
        EditText nameText = (EditText) findViewById(R.id.name_edit_view);
        name = nameText.getText().toString();
        //displayMessage(createOrderSummary(name, quantity, hasWhippedCreamChecked, hasChocolateChecked));

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:jennifernghi@yahoo.com"));// email address
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject,name));//subject
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(name, quantity, hasWhippedCreamChecked, hasChocolateChecked));// content of the email
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }

    private int calculatePrice(){
        int totalPrice=0;

        if(hasWhippedCreamChecked && hasChocolateChecked){
            totalPrice = (pricePerCup + whippedCreamPrice + chocolatePrice) * quantity;
        }else if(hasWhippedCreamChecked && !hasChocolateChecked){
            totalPrice = (pricePerCup + whippedCreamPrice ) * quantity;
        }else if(!hasWhippedCreamChecked && hasChocolateChecked){
            totalPrice = (pricePerCup + chocolatePrice ) * quantity;
        }else {
            totalPrice = pricePerCup * quantity;
        }

        return totalPrice;
    }
    private String createOrderSummary(String name, int quantity, boolean whippedCream, boolean chocalate){
        int price = calculatePrice();
        String message = getString(R.string.order_summary_name,name);
        message+= "\n"+ getString(R.string.order_summary_whipped_cream,whippedCream);
        message+= "\n"+ getString(R.string.order_summary_chocolate,chocalate);
        message+= "\n"+ getString(R.string.order_summary_quantity,quantity);
        message+= "\n"+ getString(R.string.order_summary_total,price);
        message+= "\n" + getString(R.string.thank_you);//get string resourse from strings.xml
        return message;
    }
    public void increment(View view){
        quantity += 1;
        display(quantity);
        if(quantity>100){
            Toast toast = Toast.makeText(this, "Quantity only between 1 - 100", Toast.LENGTH_SHORT);
            toast.show();
            quantity =100;
            display(100);
        }
    }

    public void decrement(View view){
        quantity -= 1;
        display(quantity);
        if(quantity<1){
            Toast toast = Toast.makeText(this, "Quantity only between 1 - 100", Toast.LENGTH_SHORT);
            toast.show();
            quantity = 1;
            display(1);
        }
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}