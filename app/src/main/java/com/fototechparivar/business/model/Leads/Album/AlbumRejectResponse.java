package com.fototechparivar.business.model.Leads.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumRejectResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    private AlbumAcceptDetails data;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public AlbumRejectResponse(String message, AlbumAcceptDetails data, String statusCode) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlbumAcceptDetails getData() {
        return data;
    }

    public void setData(AlbumAcceptDetails data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }}
