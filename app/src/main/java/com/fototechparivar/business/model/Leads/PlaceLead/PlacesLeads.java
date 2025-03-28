package com.fototechparivar.business.model.Leads.PlaceLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlacesLeads {


    @SerializedName("enquiryId")
    @Expose
    private String enquiryId;
    @SerializedName("placeId")
    @Expose
    private String placeId;
    @SerializedName("placeUserId")
    @Expose
    private String placeUserId;
    @SerializedName("enquirySenderId")
    @Expose
    private String enquirySenderId;
    @SerializedName("enquirySource")
    @Expose
    private String enquirySource;
    @SerializedName("enquiryName")
    @Expose
    private String enquiryName;
    @SerializedName("enquiryEmail")
    @Expose
    private String enquiryEmail;
    @SerializedName("enquiryMobile")
    @Expose
    private String enquiryMobile;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("clientMobile")
    @Expose
    private String client_mobile;
    @SerializedName("additionalServices")
    @Expose
    private String additionalServices;
    @SerializedName("appointmentDate")
    @Expose
    private String appointmentDate;
    @SerializedName("appointmentTime")
    @Expose
    private String appointmentTime;
    @SerializedName("enquiryMessage")
    @Expose
    private String enquiryMessage;
    @SerializedName("enquiryCategory")
    @Expose
    private String enquiryCategory;
    @SerializedName("enquiryLocation")
    @Expose
    private String enquiryLocation;
    @SerializedName("cityId")
    @Expose
    private String cityId;
    @SerializedName("paymentId")
    @Expose
    private String paymentId;
    @SerializedName("isGeneralId")
    @Expose
    private String isGeneralId;
    @SerializedName("totalAmount")
    @Expose
    private String totalAmount;
    @SerializedName("adminAmount")
    @Expose
    private String adminAmount;
    @SerializedName("userAmount")
    @Expose
    private String userAmount;
    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("enquirySave")
    @Expose
    private String enquirySave;
    @SerializedName("enquiryStatus")
    @Expose
    private String enquiryStatus;
    @SerializedName("cancelReason")
    @Expose
    private String cancelReason;
    @SerializedName("enquiryCdt")
    @Expose
    private String enquiryCdt;
    @SerializedName("enquiryUudt")
    @Expose
    private String enquiryUudt;
    @SerializedName("paymentCcdt")
    @Expose
    private String paymentCcdt;
    @SerializedName("cash_backAmount")
    @Expose
    private String cash_backAmount;
    @SerializedName("status")
    @Expose
    private String status;


    public PlacesLeads(String enquiryId, String placeId, String placeUserId, String enquirySenderId, String enquirySource, String enquiryName, String enquiryEmail, String enquiryMobile, String clientName, String client_mobile, String additionalServices, String appointmentDate, String appointmentTime, String enquiryMessage, String enquiryCategory, String enquiryLocation, String cityId, String paymentId, String isGeneralId, String totalAmount, String adminAmount, String userAmount, String paymentStatus, String enquirySave, String enquiryStatus, String cancelReason, String enquiryCdt, String enquiryUudt, String paymentCcdt, String cash_backAmount, String status) {
        this.enquiryId = enquiryId;
        this.placeId = placeId;
        this.placeUserId = placeUserId;
        this.enquirySenderId = enquirySenderId;
        this.enquirySource = enquirySource;
        this.enquiryName = enquiryName;
        this.enquiryEmail = enquiryEmail;
        this.enquiryMobile = enquiryMobile;
        this.clientName = clientName;
        this.client_mobile = client_mobile;
        this.additionalServices = additionalServices;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.enquiryMessage = enquiryMessage;
        this.enquiryCategory = enquiryCategory;
        this.enquiryLocation = enquiryLocation;
        this.cityId = cityId;
        this.paymentId = paymentId;
        this.isGeneralId = isGeneralId;
        this.totalAmount = totalAmount;
        this.adminAmount = adminAmount;
        this.userAmount = userAmount;
        this.paymentStatus = paymentStatus;
        this.enquirySave = enquirySave;
        this.enquiryStatus = enquiryStatus;
        this.cancelReason = cancelReason;
        this.enquiryCdt = enquiryCdt;
        this.enquiryUudt = enquiryUudt;
        this.paymentCcdt = paymentCcdt;
        this.cash_backAmount = cash_backAmount;
        this.status = status;
    }


    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceUserId() {
        return placeUserId;
    }

    public void setPlaceUserId(String placeUserId) {
        this.placeUserId = placeUserId;
    }

    public String getEnquirySenderId() {
        return enquirySenderId;
    }

    public void setEnquirySenderId(String enquirySenderId) {
        this.enquirySenderId = enquirySenderId;
    }

    public String getEnquirySource() {
        return enquirySource;
    }

    public void setEnquirySource(String enquirySource) {
        this.enquirySource = enquirySource;
    }

    public String getEnquiryName() {
        return enquiryName;
    }

    public void setEnquiryName(String enquiryName) {
        this.enquiryName = enquiryName;
    }

    public String getEnquiryEmail() {
        return enquiryEmail;
    }

    public void setEnquiryEmail(String enquiryEmail) {
        this.enquiryEmail = enquiryEmail;
    }

    public String getEnquiryMobile() {
        return enquiryMobile;
    }

    public void setEnquiryMobile(String enquiryMobile) {
        this.enquiryMobile = enquiryMobile;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClient_mobile() {
        return client_mobile;
    }

    public void setClient_mobile(String client_mobile) {
        this.client_mobile = client_mobile;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getEnquiryMessage() {
        return enquiryMessage;
    }

    public void setEnquiryMessage(String enquiryMessage) {
        this.enquiryMessage = enquiryMessage;
    }

    public String getEnquiryCategory() {
        return enquiryCategory;
    }

    public void setEnquiryCategory(String enquiryCategory) {
        this.enquiryCategory = enquiryCategory;
    }

    public String getEnquiryLocation() {
        return enquiryLocation;
    }

    public void setEnquiryLocation(String enquiryLocation) {
        this.enquiryLocation = enquiryLocation;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getIsGeneralId() {
        return isGeneralId;
    }

    public void setIsGeneralId(String isGeneralId) {
        this.isGeneralId = isGeneralId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAdminAmount() {
        return adminAmount;
    }

    public void setAdminAmount(String adminAmount) {
        this.adminAmount = adminAmount;
    }

    public String getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(String userAmount) {
        this.userAmount = userAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getEnquirySave() {
        return enquirySave;
    }

    public void setEnquirySave(String enquirySave) {
        this.enquirySave = enquirySave;
    }

    public String getEnquiryStatus() {
        return enquiryStatus;
    }

    public void setEnquiryStatus(String enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getEnquiryCdt() {
        return enquiryCdt;
    }

    public void setEnquiryCdt(String enquiryCdt) {
        this.enquiryCdt = enquiryCdt;
    }

    public String getEnquiryUudt() {
        return enquiryUudt;
    }

    public void setEnquiryUudt(String enquiryUudt) {
        this.enquiryUudt = enquiryUudt;
    }

    public String getPaymentCcdt() {
        return paymentCcdt;
    }

    public void setPaymentCcdt(String paymentCcdt) {
        this.paymentCcdt = paymentCcdt;
    }

    public String getCash_backAmount() {
        return cash_backAmount;
    }

    public void setCash_backAmount(String cash_backAmount) {
        this.cash_backAmount = cash_backAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
