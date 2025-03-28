package com.fototechparivar.business.model.Leads;

public class UserModal {

    private String id;
    private String listing_id;


    public UserModal(String id, String listing_id) {
        this.id = id;
        this.listing_id = listing_id;
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
}
