package com.example.trackingdelivery.Model.Delivery;

public class DeliveryStructure {

    /**
     * Creator : CornSoupCookie
     * Explanation : Delivery data parsing class
     * Used variable : variable
     */

    private String message;
    private String time;
    private String location;
    private String status;
    private String action;

    public DeliveryStructure(String message, String time, String location, String status, String action) {

        this.message = message;
        this.time = time;
        this.location = location;
        this.status = status;
        this.action = action;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
