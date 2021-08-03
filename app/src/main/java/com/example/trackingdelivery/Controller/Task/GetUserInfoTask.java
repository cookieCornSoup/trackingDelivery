package com.example.trackingdelivery.Controller.Task;

import android.os.AsyncTask;

import com.example.trackingdelivery.Controller.Network.APIClient;
import com.example.trackingdelivery.Controller.Network.RetrofitApiInterface;
import com.example.trackingdelivery.Model.Delivery.DeliveryFeedResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserInfoTask extends AsyncTask<Void, Void, Void> {

    private String userId;
    private String nk;


    RetrofitApiInterface apiInterface;

    public GetUserInfoTask(String userId, String nk) {
        this.userId = userId;
        this.nk = nk;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Void doInBackground(Void... voids) {

        apiInterface = APIClient.getClient().create(RetrofitApiInterface.class);
        Call<DeliveryFeedResource> call = apiInterface.getUserDeliveryList(userId, nk);
        call.enqueue(new Callback<DeliveryFeedResource>() {
            @Override
            public void onResponse(Call<DeliveryFeedResource> call, Response<DeliveryFeedResource> response) {

                DeliveryFeedResource deliveryFeedResource = response.body();


                if (response.isSuccessful()) {


                } else {

                }
            }

            @Override
            public void onFailure(Call<DeliveryFeedResource> call, Throwable t) {

            }
        });
        return null;
    }

}
