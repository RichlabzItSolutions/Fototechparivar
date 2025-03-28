package com.fototechparivar.business.model.Leads.ServiceExpert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceExpertLeads {

    @SerializedName("enquiryId")
    @Expose
    private String enquiryId;
    @SerializedName("expertId")
    @Expose
    private String expertId;
    @SerializedName("expertUserId")
    @Expose
    private String expertUserId;
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
    @SerializedName("stateId")
    @Expose
    private String stateId;
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
    @SerializedName("enquiryUdt")
    @Expose
    private String enquiryUdt;
    @SerializedName("paymentCdt")
    @Expose
    private String paymentCdt;
    @SerializedName("enquiryAddress")
    @Expose
    private String enquiryAddress;
    @SerializedName("fromTime")
    @Expose
    private String fromTime;
    @SerializedName("toTime")
    @Expose
    private String toTime;
    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("expertRating")
    @Expose
    private String expertRating;
    @SerializedName("expertReview")
    @Expose
    private String expertReview;
    @SerializedName("slot")
    @Expose
    private String slot;
    @SerializedName("cashBackAmount")
    @Expose
    private String cashBackAmount;


    public ServiceExpertLeads(String enquiryId, String expertId, String expertUserId, String enquirySenderId, String enquirySource, String enquiryName, String enquiryEmail, String enquiryMobile, String appointmentDate, String appointmentTime, String enquiryMessage, String enquiryCategory, String enquiryLocation, String stateId, String cityId, String paymentId, String isGeneralId, String totalAmount, String adminAmount, String userAmount, String paymentStatus, String enquirySave, String enquiryStatus, String cancelReason, String enquiryCdt, String enquiryUdt, String paymentCdt, String enquiryAddress, String fromTime, String toTime, String eventName, String expertRating, String expertReview, String slot, String cashBackAmount) {
        this.enquiryId = enquiryId;
        this.expertId = expertId;
        this.expertUserId = expertUserId;
        this.enquirySenderId = enquirySenderId;
        this.enquirySource = enquirySource;
        this.enquiryName = enquiryName;
        this.enquiryEmail = enquiryEmail;
        this.enquiryMobile = enquiryMobile;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.enquiryMessage = enquiryMessage;
        this.enquiryCategory = enquiryCategory;
        this.enquiryLocation = enquiryLocation;
        this.stateId = stateId;
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
        this.enquiryUdt = enquiryUdt;
        this.paymentCdt = paymentCdt;
        this.enquiryAddress = enquiryAddress;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.eventName = eventName;
        this.expertRating = expertRating;
        this.expertReview = expertReview;
        this.slot = slot;
        this.cashBackAmount = cashBackAmount;
    }


    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getExpertUserId() {
        return expertUserId;
    }

    public void setExpertUserId(String expertUserId) {
        this.expertUserId = expertUserId;
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

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
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

    public String getEnquiryUdt() {
        return enquiryUdt;
    }

    public void setEnquiryUdt(String enquiryUdt) {
        this.enquiryUdt = enquiryUdt;
    }

    public String getPaymentCdt() {
        return paymentCdt;
    }

    public void setPaymentCdt(String paymentCdt) {
        this.paymentCdt = paymentCdt;
    }

    public String getEnquiryAddress() {
        return enquiryAddress;
    }

    public void setEnquiryAddress(String enquiryAddress) {
        this.enquiryAddress = enquiryAddress;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getExpertRating() {
        return expertRating;
    }

    public void setExpertRating(String expertRating) {
        this.expertRating = expertRating;
    }

    public String getExpertReview() {
        return expertReview;
    }

    public void setExpertReview(String expertReview) {
        this.expertReview = expertReview;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getCashBackAmount() {
        return cashBackAmount;
    }

    public void setCashBackAmount(String cashBackAmount) {
        this.cashBackAmount = cashBackAmount;
    }
}
