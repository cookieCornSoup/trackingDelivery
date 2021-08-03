package com.example.trackingdelivery.Controller.Task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.trackingdelivery.Controller.Network.APIClient;
import com.example.trackingdelivery.Controller.Network.RetrofitApiInterface;
import com.example.trackingdelivery.Model.User.UserPreferences;
import com.example.trackingdelivery.Model.User.UserResource;
import com.example.trackingdelivery.View.Login.EmailLoginActivity;
import com.example.trackingdelivery.View.OtherAti.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginTask extends AsyncTask<Void, Void, Void> {

    private final String mEmail;
    private final String mPassword;
    private String token;
    RetrofitApiInterface apiInterface;
    UserPreferences userPreferences = new UserPreferences();
    Context LoginAtiContext;
    UserResource userResource;
    private boolean autoLogin;

    public UserLoginTask(String email, String password, Context context, boolean autoLogin) {
        mEmail = email;
        mPassword = password;
        this.LoginAtiContext = context;
        this.autoLogin = autoLogin;
    }

    @Override
    protected Void doInBackground(Void... params) {


        apiInterface = APIClient.getClient().create(RetrofitApiInterface.class);
        Call<UserResource> call = apiInterface.logIn(mEmail, mPassword);
        call.enqueue(new Callback<UserResource>() {
            @Override
            public void onResponse(Call<UserResource> call, Response<UserResource> response) {
                userResource = response.body();

                if (autoLogin) {
                    if (response.isSuccessful()) {


                        loginMain();

                    } else {
                        Toast.makeText(LoginAtiContext, "다시 로그인", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (response.isSuccessful()) {

                        Intent intent = new Intent(LoginAtiContext, MainActivity.class);
                        LoginAtiContext.startActivity(intent);

                    } else {

                    }
                }

            }

            @Override
            public void onFailure(Call<UserResource> call, Throwable t) {

            }
        });
        return null;
    }


    private void loginMain(){

        userPreferences.saveToken(LoginAtiContext, userResource.getId());
        userPreferences.saveEmail(LoginAtiContext, userResource.getUserId());
        Intent intent = new Intent(LoginAtiContext, MainActivity.class);
        LoginAtiContext.startActivity(intent);
    }
}
