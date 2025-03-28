package com.fototechparivar.business.model.Leads.ServiceExpert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceCompleteResponse {

    @SerializedName("message")
    @Expose
    private String message;


    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public ServiceCompleteResponse(String message, String statusCode) {
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
