package com.fototechparivar.business.model.Leads.PlaceLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlaceLeadsResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("place_leads")
    @Expose
    private ArrayList<PlacesLeads> place_leads = null;


    public PlaceLeadsResponse(String status, String statusCode, String message, ArrayList<PlacesLeads> place_leads) {
        this.status = status;
        this.statusCode =statusCode;
        this.message = message;
        this.place_leads = place_leads;
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

    public ArrayList<PlacesLeads> getPlace_leads() {
        return place_leads;
    }

    public void setPlace_leads(ArrayList<PlacesLeads> place_leads) {
        this.place_leads = place_leads;
    }
}
