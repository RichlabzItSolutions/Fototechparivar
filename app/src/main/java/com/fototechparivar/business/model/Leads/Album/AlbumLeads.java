package com.fototechparivar.business.model.Leads.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumLeads {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("listingUserId")
    @Expose
    private String listingUserId;
    @SerializedName("enquirySenderId")
    @Expose
    private String enquirySenderId;
    @SerializedName("enquirySource")
    @Expose
    private String enquirySource;
    @SerializedName("enquiryName")
    @Expose
    private String enquiryName;
    @SerializedName("enquiryEmail")
    @Expose
    private String enquiryEmail;
    @SerializedName("enquiryMobile")
    @Expose
    private String enquiryMobile;
    @SerializedName("userAddress")
    @Expose
    private String userAddress;
    @SerializedName("aproxNoofSheets")
    @Expose
    private String aproxNoofSheets;
    @SerializedName("noOfAlbums")
    @Expose
    private String noOfAlbums;
    @SerializedName("albumUrls")
    @Expose
    private String albumUrls;
    @SerializedName("enquiryMessage")
    @Expose
    private String enquiryMessage;
    @SerializedName("invoiceNo")
    @Expose
    private String invoiceNo;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("cashBackAmount")
    @Expose
    private String cashBackAmount;
    @SerializedName("addedOn")
    @Expose
    private String addedOn;
    @SerializedName("status")
    @Expose
    private String status;


    public AlbumLeads(String id, String listingUserId, String enquirySenderId, String enquirySource, String enquiryName, String enquiryEmail, String enquiryMobile,  String userAddress, String aproxNoofSheets, String noOfAlbums, String albumUrls, String enquiryMessage, String invoiceNo, String amount, String cashBackAmount, String addedOn, String status) {
        this.id = id;
        this.listingUserId = listingUserId;
        this.enquirySenderId = enquirySenderId;
        this.enquirySource = enquirySource;
        this.enquiryName = enquiryName;
        this.enquiryEmail = enquiryEmail;
        this.enquiryMobile = enquiryMobile;
        this.userAddress = userAddress;
        this.aproxNoofSheets = aproxNoofSheets;
        this.noOfAlbums = noOfAlbums;
        this.albumUrls = albumUrls;
        this.enquiryMessage = enquiryMessage;
        this.invoiceNo = invoiceNo;
        this.amount = amount;
        this.cashBackAmount = cashBackAmount;
        this.addedOn = addedOn;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListingUserId() {
        return listingUserId;
    }

    public void setListingUserId(String listingUserId) {
        this.listingUserId = listingUserId;
    }

    public String getEnquirySenderId() {
        return enquirySenderId;
    }

    public void setEnquirySenderId(String enquirySenderId) {
        this.enquirySenderId = enquirySenderId;
    }

    public String getEnquirySource() {
        return enquirySource;
    }

    public void setEnquirySource(String enquirySource) {
        this.enquirySource = enquirySource;
    }

    public String getEnquiryName() {
        return enquiryName;
    }

    public void setEnquiryName(String enquiryName) {
        this.enquiryName = enquiryName;
    }

    public String getEnquiryEmail() {
        return enquiryEmail;
    }

    public void setEnquiryEmail(String enquiryEmail) {
        this.enquiryEmail = enquiryEmail;
    }


    public String getEnquiryMobile() {
        return enquiryMobile;
    }

    public void setEnquiryMobile(String enquiryMobile) {
        this.enquiryMobile = enquiryMobile;
    }



    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getAproxNoofSheets() {
        return aproxNoofSheets;
    }

    public void setAproxNoofSheets(String aproxNoofSheets) {
        this.aproxNoofSheets = aproxNoofSheets;
    }

    public String getNoOfAlbums() {
        return noOfAlbums;
    }

    public void setNoOfAlbums(String noOfAlbums) {
        this.noOfAlbums = noOfAlbums;
    }

    public String getAlbumUrls() {
        return albumUrls;
    }

    public void setAlbumUrls(String albumUrls) {
        this.albumUrls = albumUrls;
    }

    public String getEnquiryMessage() {
        return enquiryMessage;
    }

    public void setEnquiryMessage(String enquiryMessage) {
        this.enquiryMessage = enquiryMessage;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCashBackAmount() {
        return cashBackAmount;
    }

    public void setCashBackAmount(String cashBackAmount) {
        this.cashBackAmount = cashBackAmount;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
