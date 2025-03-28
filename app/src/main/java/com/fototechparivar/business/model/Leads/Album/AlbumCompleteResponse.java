package com.fototechparivar.business.model.Leads.Album;

import com.fototechparivar.business.model.Leads.Album.AlbumCompleteDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumCompleteResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    //private ArrayList<GetLoginDetails> userData = null;
    private AlbumCompleteDetails data;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public AlbumCompleteResponse(String message, AlbumCompleteDetails data, String statusCode) {
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

    public AlbumCompleteDetails getData() {
        return data;
    }

    public void setData(AlbumCompleteDetails data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
