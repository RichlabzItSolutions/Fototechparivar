package com.fototechparivar.business.model.ChangePassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendOtpJson {

    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;


    public SendOtpJson(String mobile_number) {
        super();
        this.mobile_number = mobile_number;
    }


    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}
