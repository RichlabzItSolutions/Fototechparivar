package com.fototechparivar.business.model.Leads.ServiceExpert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceCompleteJson {

    @SerializedName("enquiry_id")
    @Expose
    private String enquiry_id;


    @SerializedName("amount")
    @Expose
    private String amount;


    public ServiceCompleteJson(String enquiry_id, String amount) {
        this.enquiry_id = enquiry_id;
        this.amount = amount;
    }


    public String getEnquiry_id() {
        return enquiry_id;
    }

    public void setEnquiry_id(String enquiry_id) {
        this.enquiry_id = enquiry_id;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
