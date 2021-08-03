package com.example.trackingdelivery.Controller.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.trackingdelivery.R;
import com.example.trackingdelivery.Model.Delivery.DeliveryStructure;
import java.util.ArrayList;

public class DeliveryDetailAdapter extends RecyclerView.Adapter<DeliveryDetailViewHolder> {

    private ArrayList<DeliveryStructure> deliveryDetailList;
    private Context mContext;
    private String company;
    private String invoicNumber;

    public DeliveryDetailAdapter(ArrayList<DeliveryStructure> deliveryDetailList, String company, String invoicNumber) {

        this.deliveryDetailList = deliveryDetailList;
        this.company = company;
        this.invoicNumber = invoicNumber;


    }

    @Override
    public DeliveryDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ui_delivery_recyclerview_item, parent, false);
        mContext = parent.getContext();
        DeliveryDetailViewHolder holder = new DeliveryDetailViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DeliveryDetailViewHolder holder, final int position) {

        holder.company.setText(company);
        holder.invoicNumber.setText(invoicNumber);

        for (int i = 0; i < deliveryDetailList.size(); i++) {
            holder.message.setText(deliveryDetailList.get(position).getMessage());
            holder.time.setText(deliveryDetailList.get(position).getTime());
            holder.location.setText(deliveryDetailList.get(position).getLocation());
            holder.status.setText(deliveryDetailList.get(position).getStatus());
            holder.action.setText(deliveryDetailList.get(position).getAction());
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