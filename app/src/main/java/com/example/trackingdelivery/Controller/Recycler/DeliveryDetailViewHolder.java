package com.example.trackingdelivery.Controller.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.trackingdelivery.R;

public class DeliveryDetailViewHolder extends RecyclerView.ViewHolder {

    TextView message;
    TextView time;
    TextView location;
    TextView status;
    TextView action;
    TextView sender;
    TextView recipient;
    TextView company;
    TextView invoicNumber;


    public DeliveryDetailViewHolder(View itemView) {
        super(itemView);

        message = (TextView) itemView.findViewById(R.id.message_cardview);
        time = (TextView) itemView.findViewById(R.id.time_caredview);
        location = (TextView) itemView.findViewById(R.id.location_cardview);
        status = (TextView) itemView.findViewById(R.id.status_cardview);
        action = (TextView) itemView.findViewById(R.id.action_cardview);
        sender = (TextView) itemView.findViewById(R.id.sender);
        recipient = (TextView) itemView.findViewById(R.id.recipient);
        company = (TextView) itemView.findViewById(R.id.company);
        invoicNumber = (TextView) itemView.findViewById(R.id.invoicNumber);
    }
}

