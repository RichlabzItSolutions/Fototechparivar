package com.fototechparivar.business.model.invoice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateNewBillJson {

    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;
    @SerializedName("invoice_no")
    @Expose
    private String invoice_no;
    @SerializedName("store_bill_number")
    @Expose
    private String store_bill_number;
    @SerializedName("code_id")
    @Expose
    private String code_id;
    @SerializedName("sale_service_details")
    @Expose
    private String sale_service_details;
    @SerializedName("bill_amount")
    @Expose
    private String bill_amount;

 /*   @SerializedName("owner_id")
    @Expose
    private String owner_id;*/


    public GenerateNewBillJson(String user_id, String mobile_number, String invoice_no, String store_bill_number, String code_id, String sale_service_details, String bill_amount /*String owner_id*/) {
        super();
        this.user_id = user_id;
        this.mobile_number = mobile_number;
        this.invoice_no = invoice_no;
        this.store_bill_number = store_bill_number;
        this.code_id = code_id;
        this.sale_service_details = sale_service_details;
        this.bill_amount = bill_amount;
       /* this.owner_id = owner_id;*/
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getStore_bill_number() {
        return store_bill_number;
    }

    public void setStore_bill_number(String store_bill_number) {
        this.store_bill_number = store_bill_number;
    }

    public String getCode_id() {
        return code_id;
    }

    public void setCode_id(String code_id) {
        this.code_id = code_id;
    }

    public String getSale_service_details() {
        return sale_service_details;
    }

    public void setSale_service_details(String sale_service_details) {
        this.sale_service_details = sale_service_details;
    }

    public String getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(String bill_amount) {
        this.bill_amount = bill_amount;
    }

   /* public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }*/


}
