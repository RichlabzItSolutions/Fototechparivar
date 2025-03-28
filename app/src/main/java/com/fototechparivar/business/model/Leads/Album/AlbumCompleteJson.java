package com.fototechparivar.business.model.Leads.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumCompleteJson {

    @SerializedName("album_enquiry_id")
    @Expose
    private String album_enquiry_id;

    @SerializedName("invoice_no")
    @Expose
    private String invoice_no;

    @SerializedName("amount")
    @Expose
    private String amount;


    public AlbumCompleteJson(String album_enquiry_id, String invoice_no, String amount) {
        this.album_enquiry_id = album_enquiry_id;
        this.invoice_no = invoice_no;
        this.amount = amount;
    }


    public String getAlbum_enquiry_id() {
        return album_enquiry_id;
    }

    public void setAlbum_enquiry_id(String album_enquiry_id) {
        this.album_enquiry_id = album_enquiry_id;
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
}
