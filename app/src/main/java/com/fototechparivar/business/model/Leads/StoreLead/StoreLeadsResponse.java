package com.fototechparivar.business.model.Leads.StoreLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoreLeadsResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("store_leads")
    @Expose
    private ArrayList<StoreLeads> store_leads = null;


    public StoreLeadsResponse(String status, String statusCode, String message, ArrayList<StoreLeads> store_leads) {
        this.status = status;
        this.statusCode =statusCode;
        this.message = message;
        this.store_leads = store_leads;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<StoreLeads> getStore_leads() {
        return store_leads;
    }

    public void setStore_leads(ArrayList<StoreLeads> store_leads) {
        this.store_leads = store_leads;
    }
}
