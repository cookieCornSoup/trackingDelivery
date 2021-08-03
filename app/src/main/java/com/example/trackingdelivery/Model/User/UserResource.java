package com.example.trackingdelivery.Model.User;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class UserResource {

    @SerializedName(value = "userId")
    public String userId;

    @SerializedName(value = "ttl")
    public String ttl;

    @SerializedName(value = "id")
    public String id;

    @SerializedName(value = "created")
    public String created;

    public UserResource(@NonNull String userId, String created, String ttl, @NonNull String id){

        this.id=userId;
        this.created = created;
        this.ttl =ttl;
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public String getId() {
        return id;
    }

    public String getTtl() {
        return ttl;
    }

    public String getUserId() {
        return userId;
    }


}
