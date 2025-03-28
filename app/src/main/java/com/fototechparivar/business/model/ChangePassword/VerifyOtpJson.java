package com.fototechparivar.business.model.ChangePassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOtpJson {

    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;
    @SerializedName("otp_code")
    @Expose
    private String otp_code;


    public VerifyOtpJson(String mobile_number, String otp_code) {
        super();
        this.mobile_number = mobile_number;
        this.otp_code = otp_code;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getOtp_code() {
        return otp_code;
    }

    public void setOtp_code(String otp_code) {
        this.otp_code = otp_code;
    }
}
