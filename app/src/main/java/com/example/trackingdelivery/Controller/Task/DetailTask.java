package com.example.trackingdelivery.Controller.Task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.trackingdelivery.Controller.Network.APIClient;
import com.example.trackingdelivery.Controller.Recycler.DeliveryDetailAdapter;
import com.example.trackingdelivery.Model.Delivery.DeliveryResource;
import com.example.trackingdelivery.Controller.Network.RetrofitApiInterface;
import com.example.trackingdelivery.Model.Delivery.DeliveryStructure;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailTask extends AsyncTask<Void, Void, Void> {

    private String company;
    private String invoicNumber;
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private RetrofitApiInterface retrofitApiInterface;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DeliveryDetailAdapter deliveryDetailAdapter;
    private ArrayList<DeliveryStructure> deliveryDetailList = new ArrayList();


    public DetailTask(String company, String invoicNumber, Context context) {
        this.company = company;
        this.invoicNumber = invoicNumber;
        this.context = context;
        retrofitApiInterface = APIClient.getClient().create(RetrofitApiInterface.class);

    }


    @Override
    protected Void doInBackground(Void... voids) {

        Call<DeliveryResource> call = retrofitApiInterface.getDeliveryData(company, invoicNumber);
        call.enqueue(new Callback<DeliveryResource>() {

            @Override
            public void onResponse(Call<DeliveryResource> call, Response<DeliveryResource> response) {
                DeliveryResource resource = response.body();
                if (response.isSuccessful()) {


                    setCallbackData(resource);
                    setRecyclerAdapter();
                }
                else {
                // error case
                switch (response.code()) {
                    case 404:
                        Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show();
                        break;
                    case 500:
                        Toast.makeText(context, "server broken", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(context, "unknown error", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
//                } else {
//                    setRecyclerAdapter();
//                }
            }

            @Override
            public void onFailure(Call<DeliveryResource> call, Throwable t) {

            }


        });

        return null;
    }


    private void setRecyclerAdapter() {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        deliveryDetailAdapter = new DeliveryDetailAdapter(deliveryDetailList, company, invoicNumber);
        recyclerView.setAdapter(deliveryDetailAdapter);

    }


    public void setCallbackData(DeliveryResource resource) {

        List<DeliveryResource.Detail> detalList = resource.deliveryDetailInfo;
        int count = 0;
        for (DeliveryResource.Detail detail : detalList) {
            DeliveryStructure deliveryData = new DeliveryStructure(detail.message, detail.time, detail.location, detail.status, detail.action);
            deliveryDetailList.add(count, deliveryData);
            count++;
        }
    }


}

