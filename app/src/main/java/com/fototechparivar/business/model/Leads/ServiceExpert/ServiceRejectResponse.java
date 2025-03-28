package com.fototechparivar.business.model.Leads.ServiceExpert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceRejectResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    private ServiceAcceptDetails data;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public ServiceRejectResponse(String message, ServiceAcceptDetails data, String statusCode) {
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

    public ServiceAcceptDetails getData() {
        return data;
    }

    public void setData(ServiceAcceptDetails data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
