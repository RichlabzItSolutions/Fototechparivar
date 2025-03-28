package com.fototechparivar.business.model;

public class LeadsModel {

    private String LeadsName;
    private int imgId;


    public LeadsModel(String leadsName, int imgId) {
        this.LeadsName = leadsName;
        this.imgId = imgId;
    }

    public String getLeadsName() {
        return LeadsName;
    }

    public void setLeadsName(String leadsName) {
        LeadsName = leadsName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
