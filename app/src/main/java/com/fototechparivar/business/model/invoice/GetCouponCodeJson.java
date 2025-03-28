package com.fototechparivar.business.model.invoice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCouponCodeJson {

    @SerializedName("user_id")
    @Expose
    private String user_id;

    public GetCouponCodeJson(String user_id) {
        super();
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
