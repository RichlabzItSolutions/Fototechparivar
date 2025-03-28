package com.fototechparivar.business.model.invoice;

import com.fototechparivar.business.model.Login.GetLoginDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetAllUserResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
   // private GetLoginDetails data;
    private ArrayList<GetLoginDetails> data = null;


    public GetAllUserResponse(String success, String message, ArrayList<GetLoginDetails> data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getSuccess() {
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

    public ArrayList<GetLoginDetails> getData() {
        return data;
    }

    public void setData(ArrayList<GetLoginDetails> data) {
        this.data = data;
    }
}
