package com.fototechparivar.business.model.invoice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetInvoiceBillListJson {

    @SerializedName("user_id")
    @Expose
    private String user_id;

    /*@SerializedName("name")
    @Expose
    private String name;*/

    public GetInvoiceBillListJson(String user_id) {
        super();
        this.user_id = user_id;
        //this.name = name;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
