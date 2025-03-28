package com.fototechparivar.business.model.invoice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCouponCodeListDetails {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("code")
    @Expose
    private String code;

    public GetCouponCodeListDetails(String id, String code) {
        super();
        this.id = id;
        this.code = code;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
