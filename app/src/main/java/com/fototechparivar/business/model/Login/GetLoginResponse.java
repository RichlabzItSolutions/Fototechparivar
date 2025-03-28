package com.fototechparivar.business.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLoginResponse {

    @SerializedName("userData")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    private GetLoginDetails userData;
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

    public GetLoginResponse(GetLoginDetails userData, String token, String newBillCheckStatus, String message, String statusCode) {
        super();
        this.userData = userData;
        this.token = token;
        this.newBillCheckStatus = newBillCheckStatus;
        this.message = message;
        this.statusCode = statusCode;
    }


    public GetLoginDetails getUserData() {
        return userData;
    }

    public void setUserData(GetLoginDetails userData) {
        this.userData = userData;
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

    /*public GetLoginResponse(String success, String message, GetLoginDetails userData) {
        super();
        this.success = success;
        this.message = message;
        this.userData = userData;
    }*/

    /*public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetLoginDetails getUserData() {
        return userData;
    }

    public void setUserData(GetLoginDetails result) {
        this.userData = userData;
    }*/

}
