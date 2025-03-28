package com.fototechparivar.business.model.Leads.PlaceLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceCompleteResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    private PlaceAcceptDetails data;


    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public PlaceCompleteResponse(String message, PlaceAcceptDetails data,  String statusCode) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PlaceAcceptDetails getData() {
        return data;
    }

    public void setData(PlaceAcceptDetails data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
