package com.fototechparivar.business.model.Leads.Album;

import com.fototechparivar.business.model.Leads.Album.AlbumLeads;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AlbumLeadsResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("album_leads")
    @Expose
    private ArrayList<AlbumLeads> album_leads = null;


    public AlbumLeadsResponse(String status, String statusCode, String message, ArrayList<AlbumLeads> album_leads) {
        this.status = status;
        this.statusCode =statusCode;
        this.message = message;
        this.album_leads = album_leads;
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

    public ArrayList<AlbumLeads> getAlbum_leads() {
        return album_leads;
    }

    public void setData(ArrayList<AlbumLeads> album_leads) {
        this.album_leads = album_leads;
    }
}
