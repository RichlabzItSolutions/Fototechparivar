package com.fototechparivar.business.model.Leads.Album;

import com.fototechparivar.business.model.Leads.Album.AlbumCancelDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumCancelResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    private AlbumCancelDetails data;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public AlbumCancelResponse(String message, AlbumCancelDetails data, String statusCode) {
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

    public AlbumCancelDetails getData() {
        return data;
    }

    public void setData(AlbumCancelDetails data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
