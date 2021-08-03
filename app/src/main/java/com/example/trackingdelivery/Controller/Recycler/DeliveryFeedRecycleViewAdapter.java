package com.example.trackingdelivery.Controller.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trackingdelivery.Model.Delivery.DeliveryStructure;
import com.example.trackingdelivery.R;

import java.util.ArrayList;

public class DeliveryFeedRecycleViewAdapter extends RecyclerView.Adapter<DeliveryFeedRecycleViewHolder> {
    private ArrayList<DeliveryStructure> deliveryDetailList;
    Context mContext;

    public DeliveryFeedRecycleViewAdapter(ArrayList<DeliveryStructure> itemList) {
        deliveryDetailList = itemList;
    }

    @Override
    public DeliveryFeedRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_deliveryfeed_item, parent, false);
        mContext = parent.getContext();
        DeliveryFeedRecycleViewHolder holder = new DeliveryFeedRecycleViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(DeliveryFeedRecycleViewHolder holder, final int position) {

        for (int i = 0; i < deliveryDetailList.size(); i++) {
            holder.company.setText(deliveryDetailList.get(position).getMessage());
            holder.invoicNumber.setText(deliveryDetailList.get(position).getTime());
            holder.status.setText(deliveryDetailList.get(position).getLocation());

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, String.format("%d 선택", position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return deliveryDetailList.size();
    }
}

