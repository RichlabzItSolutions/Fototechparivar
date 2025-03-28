package com.fototechparivar.business.model.Leads.ServiceExpert;

import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceExpertLeads;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ServiceLeadsResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("expert_leads")
    @Expose
    private ArrayList<ServiceExpertLeads> expert_leads = null;


    public ServiceLeadsResponse(String status, String statusCode, String message, ArrayList<ServiceExpertLeads> expert_leads) {
        this.status = status;
        this.statusCode =statusCode;
        this.message = message;
        this.expert_leads = expert_leads;
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

    public ArrayList<ServiceExpertLeads> getExpert_leads() {
        return expert_leads;
    }

    public void setExpert_leads(ArrayList<ServiceExpertLeads> expert_leads) {
        this.expert_leads = expert_leads;
    }
}
