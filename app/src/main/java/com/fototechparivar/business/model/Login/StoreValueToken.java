package com.fototechparivar.business.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreValueToken {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("newBillCheckStatus")
    @Expose
    private String newBillCheckStatus;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public StoreValueToken( String token, String newBillCheckStatus, String message, String statusCode) {
        super();
        this.token = token;
        this.newBillCheckStatus = newBillCheckStatus;
        this.message = message;
        this.statusCode = statusCode;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewBillCheckStatus() {
        return newBillCheckStatus;
    }

    public void setNewBillCheckStatus(String newBillCheckStatus) {
        this.newBillCheckStatus = newBillCheckStatus;
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
