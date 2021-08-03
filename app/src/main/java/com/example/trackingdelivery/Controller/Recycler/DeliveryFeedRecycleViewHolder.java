package com.example.trackingdelivery.Controller.Recycler;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.trackingdelivery.R;


public class DeliveryFeedRecycleViewHolder extends RecyclerView.ViewHolder {

    TextView company;
    TextView invoicNumber;
    TextView status;

    public DeliveryFeedRecycleViewHolder(View itemView) {

        super(itemView);

        company = (TextView) itemView.findViewById(R.id.feedcompany);
        invoicNumber = (TextView) itemView.findViewById(R.id.feedinvoiceNumber);
        status = (TextView) itemView.findViewById(R.id.feedstatus);


    }
}
