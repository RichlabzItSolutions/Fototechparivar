package com.fototechparivar.business.model.Leads.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumAcceptJson {

    @SerializedName("album_enquiry_id")
    @Expose
    private String album_enquiry_id;


    public AlbumAcceptJson(String album_enquiry_id) {
        this.album_enquiry_id = album_enquiry_id;
    }

    public String getAlbum_enquiry_id() {
        return album_enquiry_id;
    }

    public void setAlbum_enquiry_id(String album_enquiry_id) {
        this.album_enquiry_id = album_enquiry_id;
    }
}
