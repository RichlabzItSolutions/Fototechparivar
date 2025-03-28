package com.fototechparivar.business.model.Leads.StoreLead;

import com.fototechparivar.business.model.Leads.PlaceLead.PlaceAcceptDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreLeadDeleteResponse {

    @SerializedName("message")
    @Expose
    private String message;


    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public StoreLeadDeleteResponse(String message,  String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
