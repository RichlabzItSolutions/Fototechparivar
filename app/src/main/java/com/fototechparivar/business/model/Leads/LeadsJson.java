package com.fototechparivar.business.model.Leads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadsJson {

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("fetch_type")
    @Expose
    private String fetch_type;


    public LeadsJson(String user_id, String fetch_type) {
        this.user_id = user_id;
        this.fetch_type = fetch_type;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getFetch_type() {
        return fetch_type;
    }

    public void setFetch_type(String fetch_type) {
        this.fetch_type = fetch_type;
    }
}
