package com.fototechparivar.business.model.Leads.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumCancelDetails {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("listing_id")
    @Expose
    private String listing_id;

    @SerializedName("listing_user_id")
    @Expose
    private String listing_user_id;

    @SerializedName("enquiry_sender_id")
    @Expose
    private String enquiry_sender_id;

    @SerializedName("enquiry_source")
    @Expose
    private String enquiry_source;

    @SerializedName("enquiry_name")
    @Expose
    private String enquiry_name;

    @SerializedName("enquiry_email")
    @Expose
    private String enquiry_email;

    @SerializedName("enquiry_mobile")
    @Expose
    private String enquiry_mobile;

    @SerializedName("album_name")
    @Expose
    private String album_name;

    @SerializedName("aprox_no_of_sheets")
    @Expose
    private String aprox_no_of_sheets;

    @SerializedName("no_of_albums")
    @Expose
    private String no_of_albums;

    @SerializedName("album_urls")
    @Expose
    private String album_urls;

    @SerializedName("enquiry_message")
    @Expose
    private String enquiry_message;

    @SerializedName("invoice_no")
    @Expose
    private String invoice_no;

    @SerializedName("amount")
    @Expose
    private String amount;

    @SerializedName("cash_back_amount")
    @Expose
    private String cash_back_amount;

    @SerializedName("added_on")
    @Expose
    private String added_on;

    @SerializedName("status")
    @Expose
    private String status;


    public AlbumCancelDetails(String id, String listing_id, String listing_user_id, String enquiry_sender_id, String enquiry_source, String enquiry_name, String enquiry_email, String enquiry_mobile, String album_name, String aprox_no_of_sheets, String no_of_albums, String album_urls, String enquiry_message, String invoice_no, String amount, String cash_back_amount, String added_on, String status) {
        this.id = id;
        this.listing_id = listing_id;
        this.listing_user_id = listing_user_id;
        this.enquiry_sender_id = enquiry_sender_id;
        this.enquiry_source = enquiry_source;
        this.enquiry_name = enquiry_name;
        this.enquiry_email = enquiry_email;
        this.enquiry_mobile = enquiry_mobile;
        this.album_name = album_name;
        this.aprox_no_of_sheets = aprox_no_of_sheets;
        this.no_of_albums = no_of_albums;
        this.album_urls = album_urls;
        this.enquiry_message = enquiry_message;
        this.invoice_no = invoice_no;
        this.amount = amount;
        this.cash_back_amount = cash_back_amount;
        this.added_on = added_on;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListing_id() {
        return listing_id;
    }

    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }

    public String getListing_user_id() {
        return listing_user_id;
    }

    public void setListing_user_id(String listing_user_id) {
        this.listing_user_id = listing_user_id;
    }

    public String getEnquiry_sender_id() {
        return enquiry_sender_id;
    }

    public void setEnquiry_sender_id(String enquiry_sender_id) {
        this.enquiry_sender_id = enquiry_sender_id;
    }

    public String getEnquiry_source() {
        return enquiry_source;
    }

    public void setEnquiry_source(String enquiry_source) {
        this.enquiry_source = enquiry_source;
    }

    public String getEnquiry_name() {
        return enquiry_name;
    }

    public void setEnquiry_name(String enquiry_name) {
        this.enquiry_name = enquiry_name;
    }

    public String getEnquiry_email() {
        return enquiry_email;
    }

    public void setEnquiry_email(String enquiry_email) {
        this.enquiry_email = enquiry_email;
    }

    public String getEnquiry_mobile() {
        return enquiry_mobile;
    }

    public void setEnquiry_mobile(String enquiry_mobile) {
        this.enquiry_mobile = enquiry_mobile;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAprox_no_of_sheets() {
        return aprox_no_of_sheets;
    }

    public void setAprox_no_of_sheets(String aprox_no_of_sheets) {
        this.aprox_no_of_sheets = aprox_no_of_sheets;
    }

    public String getNo_of_albums() {
        return no_of_albums;
    }

    public void setNo_of_albums(String no_of_albums) {
        this.no_of_albums = no_of_albums;
    }

    public String getAlbum_urls() {
        return album_urls;
    }

    public void setAlbum_urls(String album_urls) {
        this.album_urls = album_urls;
    }

    public String getEnquiry_message() {
        return enquiry_message;
    }

    public void setEnquiry_message(String enquiry_message) {
        this.enquiry_message = enquiry_message;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCash_back_amount() {
        return cash_back_amount;
    }

    public void setCash_back_amount(String cash_back_amount) {
        this.cash_back_amount = cash_back_amount;
    }

    public String getAdded_on() {
        return added_on;
    }

    public void setAdded_on(String added_on) {
        this.added_on = added_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
