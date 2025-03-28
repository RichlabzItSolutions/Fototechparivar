package com.fototechparivar.business.model.invoice;

import com.fototechparivar.business.model.Login.GetLoginDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetCouponCodeResponse {

    @SerializedName("data")
    @Expose
    private ArrayList<GetCouponCodeListDetails> data = null;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;



    public GetCouponCodeResponse(ArrayList<GetCouponCodeListDetails> data, String success, String messag) {
        super();
        this.data = data;
        this.success = success;
        this.message = message;

    }


    public ArrayList<GetCouponCodeListDetails> getData() {
        return data;
    }

    public void setData(ArrayList<GetCouponCodeListDetails> data) {
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


}
