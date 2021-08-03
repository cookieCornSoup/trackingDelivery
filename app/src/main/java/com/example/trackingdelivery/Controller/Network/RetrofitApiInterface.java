package com.example.trackingdelivery.Controller.Network;

import com.example.trackingdelivery.Model.Delivery.DeliveryFeedResource;
import com.example.trackingdelivery.Model.Delivery.DeliveryResource;
import com.example.trackingdelivery.Model.User.UserResource;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApiInterface {

    /**
     * Creator : CornSoupCookie
     * Explanation : retrofit api interface
     * Used variable : okhttp, retrofit
     */


    //carrier

    @GET("carriers/{id}/delivery/{invoicNumber}")
    Call<DeliveryResource> getDeliveryData(

            @Path("id") String company,
            @Path("invoicNumber") String invoicNumber);


    //user

    @FormUrlEncoded
    @POST("users")
    Call<UserResource> signUp(
            @Field("email") String userId,
            @Field("password") String mPassword,
            @Field("username") String mUserName,
            @Field("ttl") String ttl);


    @GET("users/{id}")
    Call<UserResource> getToken(

            @Path("id") String email,
            @Header("X-Access-Token") String token);


    @GET("users/{id}/carriers/{nk}/delivery")
    Call<DeliveryFeedResource> getUserDeliveryList(

            @Path("id") String userId,
            @Path("nk") String nk);


    @FormUrlEncoded
    @POST("users/change-password")
    Call<UserResource> changePassword(
            @Field("oldPassword") String oldPassword,
            @Field("newPassword") String newPassword);


    @FormUrlEncoded
    @POST("users/login")
    Call<UserResource> logIn(
            @Field("email") String mEmail,
            @Field("password") String mPassword);


    @FormUrlEncoded
    @POST("users/reset-password")
    Call<ResponseBody> resetPassword(
            @Field("password") String mPassword);



}