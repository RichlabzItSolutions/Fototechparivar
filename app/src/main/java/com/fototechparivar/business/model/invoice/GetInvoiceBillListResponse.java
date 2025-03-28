package com.fototechparivar.business.model.invoice;

import com.fototechparivar.business.model.Login.GetLoginDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetInvoiceBillListResponse {


    @SerializedName("allBills")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    // private GetLoginDetails data;
    private ArrayList<GetInvoiceBillListDetails> allBills = null;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;


    public GetInvoiceBillListResponse(ArrayList<GetInvoiceBillListDetails> allBills, String statusCode) {
        this.allBills = allBills;
        this.statusCode = statusCode;
    }

    public ArrayList<GetInvoiceBillListDetails> getAllBills() {
        return allBills;
    }

    public void setAllBills(ArrayList<GetInvoiceBillListDetails> allBills) {
        this.allBills = allBills;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
