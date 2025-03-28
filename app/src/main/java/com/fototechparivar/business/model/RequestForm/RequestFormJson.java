package com.fototechparivar.business.model.RequestForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestFormJson {


    @SerializedName("business_name")
    @Expose
    private String business_name;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;
    @SerializedName("city")
    @Expose
    private String city;


    public RequestFormJson(String business_name, String name, String email, String mobile_number, String city) {
        super();
        this.business_name = business_name;
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.city = city;
    }


    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
