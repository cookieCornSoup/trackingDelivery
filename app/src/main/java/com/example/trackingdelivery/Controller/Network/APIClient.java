package com.example.trackingdelivery.Controller.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static String SeverUrl = "http://10.0.2.2:80/api/";

    //public static String SeverUrl = "http://172.30.1.1:80/api/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client;

            client= new OkHttpClient.Builder().addInterceptor(interceptor).build();
            Retrofit builder = retrofit = new Retrofit.Builder()
                    .baseUrl(SeverUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit;



    }
}
