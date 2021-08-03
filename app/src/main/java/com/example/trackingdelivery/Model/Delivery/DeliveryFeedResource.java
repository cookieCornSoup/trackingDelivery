package com.example.trackingdelivery.Model.Delivery;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


/**
 * 유저 피드용 데이터 리소스(추후 결과 따라 수정필요)
 */


public class DeliveryFeedResource {




    public ArrayList<DeliveryFeedList> deliveryFeedList = new ArrayList<DeliveryFeedList>();

    public class DeliveryFeedList {


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
        public List<Detail> deliveryDetailInfo = new ArrayList();

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
}
