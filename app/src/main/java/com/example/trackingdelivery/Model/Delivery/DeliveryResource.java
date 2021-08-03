package com.example.trackingdelivery.Model.Delivery;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class DeliveryResource {

    /**
     * Creator : CornSoupCookie
     * Explanation : Delivery data parsing class
     * Used variable : variable
     */

    @SerializedName("deliveryInfo")
    public UserInfo deliveryInfo = new UserInfo();

    public class UserInfo {

        @SerializedName(value = "sender")
        public String sender;

        @SerializedName(value = "recipient")
        public String recipient;

        @SerializedName(value = "invoicNumber")
        public String invoicNumber;

        @SerializedName(value = "finalState")
        public String finalState;
    }

    @SerializedName("deliveryDetailInfo")
    public ArrayList<Detail> deliveryDetailInfo = new ArrayList();

    public class Detail {

        @SerializedName(value = "message")
        public String message;

        @SerializedName(value = "time")
        public String time;

        @SerializedName(value = "location")
        public String location;

        @SerializedName(value = "status")
        public String status;

        @SerializedName(value = "action")
        public String action;

    }

}


