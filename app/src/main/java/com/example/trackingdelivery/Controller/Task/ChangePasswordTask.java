package com.example.trackingdelivery.Controller.Task;

import android.os.AsyncTask;

import com.example.trackingdelivery.Controller.Network.APIClient;
import com.example.trackingdelivery.Controller.Network.RetrofitApiInterface;
import com.example.trackingdelivery.Model.User.UserResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordTask extends AsyncTask<Void, Void, Void> {

    private String oldPassword;
    private String newPassword;
    RetrofitApiInterface apiInterface;

    public ChangePasswordTask(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;

    }

    @Override
    protected Void doInBackground(Void... params) {


        apiInterface = APIClient.getClient().create(RetrofitApiInterface.class);
        Call<UserResource> call = apiInterface.changePassword(oldPassword, newPassword);
        call.enqueue(new Callback<UserResource>() {
            @Override
            public void onResponse(Call<UserResource> call, Response<UserResource> response) {
                if (response.isSuccessful()) {



                }

            }

            @Override
            public void onFailure(Call<UserResource> call, Throwable t) {

            }
        });

        return null;
    }
}