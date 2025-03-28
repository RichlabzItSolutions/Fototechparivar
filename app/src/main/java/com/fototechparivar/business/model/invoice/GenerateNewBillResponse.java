package com.fototechparivar.business.model.invoice;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateNewBillResponse {


    @SerializedName("data")
    @Expose
    private GenerateNewBillDetails data;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;


    public GenerateNewBillResponse(GenerateNewBillDetails data, String success, String message) {
        super();
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public GenerateNewBillDetails getData() {
        return data;
    }

    public void setData(GenerateNewBillDetails data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
