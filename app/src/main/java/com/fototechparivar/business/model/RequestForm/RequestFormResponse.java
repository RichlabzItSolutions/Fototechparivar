package com.fototechparivar.business.model.RequestForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestFormResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public RequestFormResponse(String message, String statusCode) {
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
