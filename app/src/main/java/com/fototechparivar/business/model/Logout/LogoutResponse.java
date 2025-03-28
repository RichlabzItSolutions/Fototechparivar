package com.fototechparivar.business.model.Logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_Code")
    @Expose
    private String status_Code;

    public LogoutResponse(String message, String status_Code) {
        super();
        this.message = message;
        this.status_Code = status_Code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus_Code() {
        return status_Code;
    }

    public void setStatus_Code(String status_Code) {
        this.status_Code = status_Code;
    }
}
