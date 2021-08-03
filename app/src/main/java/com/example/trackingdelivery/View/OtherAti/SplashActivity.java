package com.example.trackingdelivery.View.OtherAti;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.example.trackingdelivery.Controller.Task.AutoLoginTask;
import com.example.trackingdelivery.Model.User.UserPreferences;
import com.example.trackingdelivery.View.Login.MainLoginActivity;


public class SplashActivity extends AppCompatActivity {

    String token;
    String email;
    View v;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Context context = getApplicationContext();

        int SPLASH_DISPLAY_LENGTH = 500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                UserPreferences userPreferences = new UserPreferences();
                token = userPreferences.getToken(context);
                email = userPreferences.getEmail(context);

                if (token ==null && email == null) {


                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();

                }
                else {

                    new AutoLoginTask(email, token, context).execute();
                    SplashActivity.this.finish();

                }


            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}