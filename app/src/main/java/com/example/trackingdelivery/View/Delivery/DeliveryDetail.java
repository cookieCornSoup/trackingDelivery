package com.example.trackingdelivery.View.Delivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.trackingdelivery.Controller.Task.DetailTask;
import com.example.trackingdelivery.R;


public class DeliveryDetail extends AppCompatActivity {

    /**
     * Creator : CornSoupCookie
     * Explanation : courier delivery detailing page
     * Used variable : recyclerview, adapter, layoutmanager, arraylist
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detail);
        {
            Intent intent = new Intent(this.getIntent());
            String company = intent.getStringExtra("company");
            Context context = getApplicationContext();
            String invoicNumber = intent.getStringExtra("invoiceNumber");

            new DetailTask(company, invoicNumber, context);


        }
    }



}
