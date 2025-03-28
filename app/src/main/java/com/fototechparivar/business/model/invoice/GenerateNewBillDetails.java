package com.fototechparivar.business.model.invoice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateNewBillDetails {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("invoiceNo")
    @Expose
    private String invoiceNo;
    @SerializedName("sroteBillNumber")
    @Expose
    private String sroteBillNumber;
    @SerializedName("EnterCode")
    @Expose
    private String EnterCode;
    @SerializedName("saleServiceDetails")
    @Expose
    private String saleServiceDetails;
    @SerializedName("billAmount")
    @Expose
    private String billAmount;

    public GenerateNewBillDetails(String id,  String userId, String mobileNumber, String invoiceNo, String sroteBillNumber, String EnterCode, String saleServiceDetails, String billAmount) {
        super();
        this.id = id;
        this.userId = userId;
        this.mobileNumber = mobileNumber;
        this.invoiceNo = invoiceNo;
        this.sroteBillNumber = sroteBillNumber;
        this.EnterCode = EnterCode;
        this.saleServiceDetails = saleServiceDetails;
        this.billAmount = billAmount;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.userId = id;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getSroteBillNumber() {
        return sroteBillNumber;
    }

    public void setSroteBillNumber(String sroteBillNumber) {
        this.sroteBillNumber = sroteBillNumber;
    }

    public String getEnterCode() {
        return EnterCode;
    }

    public void setEnterCode(String enterCode) {
        EnterCode = enterCode;
    }

    public String getSaleServiceDetails() {
        return saleServiceDetails;
    }

    public void setSaleServiceDetails(String saleServiceDetails) {
        this.saleServiceDetails = saleServiceDetails;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }
}
