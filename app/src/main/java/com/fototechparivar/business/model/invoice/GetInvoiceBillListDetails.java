package com.fototechparivar.business.model.invoice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetInvoiceBillListDetails {

    @SerializedName("id")
    @Expose
    private String id;
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
    @SerializedName("enter_code")
    @Expose
    private String enter_code;
    @SerializedName("sale_service_details")
    @Expose
    private String sale_service_details;

    @SerializedName("bill_amount")
    @Expose
    private String bill_amount;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("plan_type_name")
    @Expose
    private String plan_type_name;


    public GetInvoiceBillListDetails(String id, String user_id, String mobile_number, String invoice_no, String store_bill_number, String enter_code, String sale_service_details, String bill_amount, String first_name, String plan_type_name) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.mobile_number = mobile_number;
        this.invoice_no = invoice_no;
        this.store_bill_number = store_bill_number;
        this.enter_code = enter_code;
        this.sale_service_details = sale_service_details;
        this.bill_amount = bill_amount;
        this.first_name = first_name;
        this.plan_type_name = plan_type_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEnter_code() {
        return enter_code;
    }

    public void setEnter_code(String enter_code) {
        this.enter_code = enter_code;
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


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }



    public String getPlan_type_name() {
        return plan_type_name;
    }

    public void setPlan_type_name(String plan_type_name) {
        this.plan_type_name = plan_type_name;
    }


















}
