package com.fototechparivar.business.model.Leads.PlaceLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceAcceptDetails {

    @SerializedName("enquiry_id")
    @Expose
    private String enquiry_id;

    @SerializedName("place_id")
    @Expose
    private String place_id;

    @SerializedName("place_user_id")
    @Expose
    private String place_user_id;

    @SerializedName("enquiry_sender_id")
    @Expose
    private String enquiry_sender_id;

    @SerializedName("enquiry_source")
    @Expose
    private String enquiry_source;

    @SerializedName("enquiry_name")
    @Expose
    private String enquiry_name;

    @SerializedName("enquiry_email")
    @Expose
    private String enquiry_email;

    @SerializedName("enquiry_mobile")
    @Expose
    private String enquiry_mobile;

    @SerializedName("client_name")
    @Expose
    private String client_name;

    @SerializedName("client_mobile")
    @Expose
    private String client_mobile;

    @SerializedName("additional_services")
    @Expose
    private String additional_services;


    @SerializedName("appointment_date")
    @Expose
    private String appointment_date;

    @SerializedName("appointment_time")
    @Expose
    private String appointment_time;

    @SerializedName("enquiry_message")
    @Expose
    private String enquiry_message;

    @SerializedName("enquiry_category")
    @Expose
    private String enquiry_category;

    @SerializedName("enquiry_location")
    @Expose
    private String enquiry_location;

    @SerializedName("state_id")
    @Expose
    private String state_id;

    @SerializedName("city_id")
    @Expose
    private String city_id;

    @SerializedName("payment_id")
    @Expose
    private String payment_id;

    @SerializedName("is_general_id")
    @Expose
    private String is_general_id;

    @SerializedName("total_amount")
    @Expose
    private String total_amount;

    @SerializedName("admin_amount")
    @Expose
    private String admin_amount;

    @SerializedName("user_amount")
    @Expose
    private String user_amount;

    @SerializedName("payment_status")
    @Expose
    private String payment_status;

    @SerializedName("enquiry_save")
    @Expose
    private String enquiry_save;

    @SerializedName("enquiry_status")
    @Expose
    private String enquiry_status;

    @SerializedName("cancel_reason")
    @Expose
    private String cancel_reason;

    @SerializedName("enquiry_cdt")
    @Expose
    private String enquiry_cdt;

    @SerializedName("enquiry_udt")
    @Expose
    private String enquiry_udt;

    @SerializedName("payment_cdt")
    @Expose
    private String payment_cdt;


    public PlaceAcceptDetails(String enquiry_id, String place_id, String place_user_id, String enquiry_sender_id, String enquiry_source, String enquiry_name, String enquiry_email, String enquiry_mobile, String client_name, String client_mobile, String additional_services, String appointment_date, String appointment_time, String enquiry_message, String enquiry_category, String enquiry_location, String state_id, String city_id, String payment_id, String is_general_id, String total_amount, String admin_amount, String user_amount, String payment_status, String enquiry_save, String enquiry_status, String cancel_reason, String enquiry_cdt, String enquiry_udt, String payment_cdt) {
        this.enquiry_id = enquiry_id;
        this.place_id = place_id;
        this.place_user_id = place_user_id;
        this.enquiry_sender_id = enquiry_sender_id;
        this.enquiry_source = enquiry_source;
        this.enquiry_name = enquiry_name;
        this.enquiry_email = enquiry_email;
        this.enquiry_mobile = enquiry_mobile;
        this.client_name = client_name;
        this.client_mobile = client_mobile;
        this.additional_services = additional_services;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.enquiry_message = enquiry_message;
        this.enquiry_category = enquiry_category;
        this.enquiry_location = enquiry_location;
        this.state_id = state_id;
        this.city_id = city_id;
        this.payment_id = payment_id;
        this.is_general_id = is_general_id;
        this.total_amount = total_amount;
        this.admin_amount = admin_amount;
        this.user_amount = user_amount;
        this.payment_status = payment_status;
        this.enquiry_save = enquiry_save;
        this.enquiry_status = enquiry_status;
        this.cancel_reason = cancel_reason;
        this.enquiry_cdt = enquiry_cdt;
        this.enquiry_udt = enquiry_udt;
        this.payment_cdt = payment_cdt;
    }


    public String getEnquiry_id() {
        return enquiry_id;
    }

    public void setEnquiry_id(String enquiry_id) {
        this.enquiry_id = enquiry_id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getPlace_user_id() {
        return place_user_id;
    }

    public void setPlace_user_id(String place_user_id) {
        this.place_user_id = place_user_id;
    }

    public String getEnquiry_sender_id() {
        return enquiry_sender_id;
    }

    public void setEnquiry_sender_id(String enquiry_sender_id) {
        this.enquiry_sender_id = enquiry_sender_id;
    }

    public String getEnquiry_source() {
        return enquiry_source;
    }

    public void setEnquiry_source(String enquiry_source) {
        this.enquiry_source = enquiry_source;
    }

    public String getEnquiry_name() {
        return enquiry_name;
    }

    public void setEnquiry_name(String enquiry_name) {
        this.enquiry_name = enquiry_name;
    }

    public String getEnquiry_email() {
        return enquiry_email;
    }

    public void setEnquiry_email(String enquiry_email) {
        this.enquiry_email = enquiry_email;
    }

    public String getEnquiry_mobile() {
        return enquiry_mobile;
    }

    public void setEnquiry_mobile(String enquiry_mobile) {
        this.enquiry_mobile = enquiry_mobile;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_mobile() {
        return client_mobile;
    }

    public void setClient_mobile(String client_mobile) {
        this.client_mobile = client_mobile;
    }

    public String getAdditional_services() {
        return additional_services;
    }

    public void setAdditional_services(String additional_services) {
        this.additional_services = additional_services;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getEnquiry_message() {
        return enquiry_message;
    }

    public void setEnquiry_message(String enquiry_message) {
        this.enquiry_message = enquiry_message;
    }

    public String getEnquiry_category() {
        return enquiry_category;
    }

    public void setEnquiry_category(String enquiry_category) {
        this.enquiry_category = enquiry_category;
    }

    public String getEnquiry_location() {
        return enquiry_location;
    }

    public void setEnquiry_location(String enquiry_location) {
        this.enquiry_location = enquiry_location;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getIs_general_id() {
        return is_general_id;
    }

    public void setIs_general_id(String is_general_id) {
        this.is_general_id = is_general_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getAdmin_amount() {
        return admin_amount;
    }

    public void setAdmin_amount(String admin_amount) {
        this.admin_amount = admin_amount;
    }

    public String getUser_amount() {
        return user_amount;
    }

    public void setUser_amount(String user_amount) {
        this.user_amount = user_amount;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getEnquiry_save() {
        return enquiry_save;
    }

    public void setEnquiry_save(String enquiry_save) {
        this.enquiry_save = enquiry_save;
    }

    public String getEnquiry_status() {
        return enquiry_status;
    }

    public void setEnquiry_status(String enquiry_status) {
        this.enquiry_status = enquiry_status;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public String getEnquiry_cdt() {
        return enquiry_cdt;
    }

    public void setEnquiry_cdt(String enquiry_cdt) {
        this.enquiry_cdt = enquiry_cdt;
    }

    public String getEnquiry_udt() {
        return enquiry_udt;
    }

    public void setEnquiry_udt(String enquiry_udt) {
        this.enquiry_udt = enquiry_udt;
    }

    public String getPayment_cdt() {
        return payment_cdt;
    }

    public void setPayment_cdt(String payment_cdt) {
        this.payment_cdt = payment_cdt;
    }
}
