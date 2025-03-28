package com.fototechparivar.business.model.Leads.StoreLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreLeads {


    @SerializedName("enquiryId")
    @Expose
    private String enquiryId;
    @SerializedName("listingId")
    @Expose
    private String listingId;
    @SerializedName("eventId")
    @Expose
    private String eventId;
    @SerializedName("blogId")
    @Expose
    private String blogId;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("listingUserId")
    @Expose
    private String listingUserId;
    @SerializedName("enquirySenderId")
    @Expose
    private String enquirySenderId;
    @SerializedName("enquiryMobile")
    @Expose
    private String enquiryMobile;
    @SerializedName("enquirySource")
    @Expose
    private String enquirySource;
    @SerializedName("enquiryName")
    @Expose
    private String enquiryName;
    @SerializedName("enquiryEmail")
    @Expose
    private String enquiryEmail;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
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
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("servicePrice")
    @Expose
    private String servicePrice;
    @SerializedName("paymentId")
    @Expose
    private String paymentId;
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
    @SerializedName("enquiry_save")
    @Expose
    private String enquiry_save;
    @SerializedName("enquiry_cdt")
    @Expose
    private String enquiry_cdt;
    @SerializedName("paymentCdt")
    @Expose
    private String paymentCdt;


    public StoreLeads(String enquiryId, String listingId, String eventId, String blogId, String productId, String listingUserId, String enquirySenderId, String enquiryMobile, String enquirySource, String enquiryName, String enquiryEmail, String city, String state, String dateTime, String appointmentDate, String appointmentTime, String enquiryMessage, String enquiryCategory, String serviceName, String servicePrice, String paymentId, String totalAmount, String adminAmount, String userAmount, String paymentStatus, String enquiry_save, String enquiry_cdt, String paymentCdt) {
        this.enquiryId = enquiryId;
        this.listingId = listingId;
        this.eventId = eventId;
        this.blogId = blogId;
        this.productId = productId;
        this.listingUserId = listingUserId;
        this.enquirySenderId = enquirySenderId;
        this.enquiryMobile = enquiryMobile;
        this.enquirySource = enquirySource;
        this.enquiryName = enquiryName;
        this.enquiryEmail = enquiryEmail;
        this.city = city;
        this.state = state;
        this.dateTime = dateTime;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.enquiryMessage = enquiryMessage;
        this.enquiryCategory = enquiryCategory;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.paymentId = paymentId;
        this.totalAmount = totalAmount;
        this.adminAmount = adminAmount;
        this.userAmount = userAmount;
        this.paymentStatus = paymentStatus;
        this.enquiry_save = enquiry_save;
        this.enquiry_cdt = enquiry_cdt;
        this.paymentCdt = paymentCdt;
    }


    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getListingUserId() {
        return listingUserId;
    }

    public void setListingUserId(String listingUserId) {
        this.listingUserId = listingUserId;
    }

    public String getEnquirySenderId() {
        return enquirySenderId;
    }

    public void setEnquirySenderId(String enquirySenderId) {
        this.enquirySenderId = enquirySenderId;
    }

    public String getEnquiryMobile() {
        return enquiryMobile;
    }

    public void setEnquiryMobile(String enquiryMobile) {
        this.enquiryMobile = enquiryMobile;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public String getEnquiry_save() {
        return enquiry_save;
    }

    public void setEnquiry_save(String enquiry_save) {
        this.enquiry_save = enquiry_save;
    }

    public String getEnquiry_cdt() {
        return enquiry_cdt;
    }

    public void setEnquiry_cdt(String enquiry_cdt) {
        this.enquiry_cdt = enquiry_cdt;
    }

    public String getPaymentCdt() {
        return paymentCdt;
    }

    public void setPaymentCdt(String paymentCdt) {
        this.paymentCdt = paymentCdt;
    }
}
