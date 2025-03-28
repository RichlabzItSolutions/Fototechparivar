package com.fototechparivar.business.model.Leads.PlaceLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceAcceptJson {

    @SerializedName("enquiry_id")
    @Expose
    private String enquiry_id;


    public PlaceAcceptJson(String enquiry_id) {
        this.enquiry_id = enquiry_id;
    }

    public String getEnquiry_id() {
        return enquiry_id;
    }

    public void setEnquiry_id(String enquiry_id) {
        this.enquiry_id = enquiry_id;
    }
}
