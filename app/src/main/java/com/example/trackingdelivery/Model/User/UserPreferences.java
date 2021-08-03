package com.example.trackingdelivery.Model.User;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences {

    SharedPreferences sharedPreferences;
    String mToken;
    String mEmail;

    public String getToken(Context context) {
        sharedPreferences = context.getSharedPreferences("token", MODE_PRIVATE);
        mToken = sharedPreferences.getString("token", mToken);
        return mToken;
    }

    public String getEmail(Context context) {
        sharedPreferences = context.getSharedPreferences("email", MODE_PRIVATE);
        mEmail = sharedPreferences.getString("email", mEmail);
        return mEmail;
    }

    public void saveToken(Context context, String token){
        SharedPreferences pref = context.getSharedPreferences("token", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("token", token);
        editor.apply();
    }


    public void saveEmail(Context context, String email){
        SharedPreferences pref = context.getSharedPreferences("email", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("email", email);
        editor.apply();
    }

    public void logOut() {
        sharedPreferences.edit().remove("token").apply();
        sharedPreferences.edit().remove("email").apply();
    }


}
