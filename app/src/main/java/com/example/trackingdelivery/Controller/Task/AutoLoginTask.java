package com.example.trackingdelivery.Controller.Task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.example.trackingdelivery.Controller.Network.APIClient;
import com.example.trackingdelivery.Controller.Network.RetrofitApiInterface;
import com.example.trackingdelivery.Model.User.UserResource;
import com.example.trackingdelivery.View.Login.MainLoginActivity;
import com.example.trackingdelivery.View.OtherAti.MainActivity;
import com.example.trackingdelivery.View.OtherAti.SplashActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AutoLoginTask extends AsyncTask<Void, Void, Void> {

    private String mEmail;
    private String mToken;
    UserResource userResource;
    Context context;
    RetrofitApiInterface apiInterface;

    public AutoLoginTask(String mEmail, String mToken, Context context) {
        this.mEmail = mEmail;
        this.mToken = mToken;
        this.context = context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Void doInBackground(Void... voids) {

        apiInterface = APIClient.getClient().create(RetrofitApiInterface.class);
        Call<UserResource> call = apiInterface.getToken(mEmail, mToken);
        call.enqueue(new Callback<UserResource>() {
            @Override
            public void onResponse(Call<UserResource> call, Response<UserResource> response) {

                //자동로그인 로직 성공
                if (response.isSuccessful()) {

                        userResource = response.body();
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);


                }
                else {
                    //Toast.makeText(context, "자동 로그인이 해제되었습니다. 재로그인 부탁드립니다..", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, MainLoginActivity.class);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserResource> call, Throwable t) {

            }
        });
        return null;
    }

}