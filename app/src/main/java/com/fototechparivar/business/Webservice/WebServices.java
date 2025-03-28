package com.fototechparivar.business.Webservice;

import com.fototechparivar.business.model.ChangePassword.ChangePasswordJson;
import com.fototechparivar.business.model.ChangePassword.ChangePasswordResponse;
import com.fototechparivar.business.model.ChangePassword.SendOtpJson;
import com.fototechparivar.business.model.ChangePassword.VerifyOtpJson;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptJson;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCancelResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteJson;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumLeadsResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumRejectResponse;
import com.fototechparivar.business.model.Leads.LeadsJson;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceAcceptJson;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceAcceptResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceCancelResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceCompleteResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceLeadsResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceRejectResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceAcceptJson;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceAcceptResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCancelResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCompleteJson;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCompleteResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceLeadsResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceRejectResponse;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeadDeleteJson;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeadDeleteResponse;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeadsResponse;
import com.fototechparivar.business.model.Login.GetLoginResponse;
import com.fototechparivar.business.model.Login.LoginJson;
import com.fototechparivar.business.model.Logout.LogoutResponse;
import com.fototechparivar.business.model.RequestForm.RequestFormJson;
import com.fototechparivar.business.model.RequestForm.RequestFormResponse;
import com.fototechparivar.business.model.ResetPassword.ResetPasswordJson;
import com.fototechparivar.business.model.ResetPassword.ResetPasswordResponse;
import com.fototechparivar.business.model.invoice.GenerateInvoiceNumberResponse;
import com.fototechparivar.business.model.invoice.GenerateNewBillJson;
import com.fototechparivar.business.model.invoice.GenerateNewBillResponse;
import com.fototechparivar.business.model.invoice.GetAllUserResponse;
import com.fototechparivar.business.model.invoice.GetCouponCodeJson;
import com.fototechparivar.business.model.invoice.GetCouponCodeResponse;
import com.fototechparivar.business.model.invoice.GetInvoiceBillListResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebServices {

    @POST("login")
    io.reactivex.Observable<GetLoginResponse>
    getLoginResponse(@Body LoginJson loginJson);

    @GET("generate-invoice-number")
    io.reactivex.Observable<GenerateInvoiceNumberResponse>
    getGetInvoiceNumber(@Header("Authorization") String authorization);



   // https://fototechparivar.in/api/get/parivarusers/codes

    @GET("get-all-users")
    io.reactivex.Observable<GetAllUserResponse>
    getGetAllUsers(@Header("Authorization") String authorization);

    @GET("get/parivarusers/codes")
    io.reactivex.Observable<GetCouponCodeResponse>
    getCouponCode(@Header("Authorization") String authorization,  @Query("user_id") String userId);



    @POST("generate-new-bill")
    io.reactivex.Observable<GenerateNewBillResponse>
    getGetNewBill(@Header("Authorization") String authorization,
                  @Body GenerateNewBillJson generateNewBillJson);

    @POST("get-all-leads")
    io.reactivex.Observable<AlbumLeadsResponse>
    getAlbumLeads(@Header("Authorization") String authorization,
                 @Body LeadsJson leadsJson);

    @POST("get-all-leads")
    io.reactivex.Observable<PlaceLeadsResponse>
    getPlaceLeads(@Header("Authorization") String authorization,
                  @Body LeadsJson leadsJson);

    @POST("get-all-leads")
    io.reactivex.Observable<ServiceLeadsResponse>
    getServiceLeads(@Header("Authorization") String authorization,
                  @Body LeadsJson leadsJson);

    @POST("get-all-leads")
    io.reactivex.Observable<StoreLeadsResponse>
    getStoreLeads(@Header("Authorization") String authorization,
                  @Body LeadsJson leadsJson);

    @POST("album-accept")
    io.reactivex.Observable<AlbumAcceptResponse>
    getAlbumAccept(@Header("Authorization") String authorization,
                    @Body AlbumAcceptJson albumAcceptJson);

    @POST("album-reject")
    io.reactivex.Observable<AlbumRejectResponse>
    getAlbumReject(@Header("Authorization") String authorization,
                   @Body AlbumAcceptJson albumAcceptJson);

    @POST("album-cancel")
    io.reactivex.Observable<AlbumCancelResponse>
    getAlbumCancel(@Header("Authorization") String authorization,
                   @Body AlbumAcceptJson albumAcceptJson);

    @POST("album-complete")
    io.reactivex.Observable<AlbumCompleteResponse>
    getAlbumComplete(@Header("Authorization") String authorization,
                   @Body AlbumCompleteJson albumCompleteJson);

    @POST("service-except-accept")
    io.reactivex.Observable<ServiceAcceptResponse>
    getServiceAccept(@Header("Authorization") String authorization,
                   @Body ServiceAcceptJson serviceAcceptJson);

    @POST("service-except-reject")
    io.reactivex.Observable<ServiceRejectResponse>
    getServiceReject(@Header("Authorization") String authorization,
                   @Body ServiceAcceptJson serviceAcceptJson);

    @POST("service-except-cancel")
    io.reactivex.Observable<ServiceCancelResponse>
    getServiceCancel(@Header("Authorization") String authorization,
                   @Body ServiceAcceptJson serviceAcceptJson);

    @POST("service-except-complete")
    io.reactivex.Observable<ServiceCompleteResponse>
    getServiceComplete(@Header("Authorization") String authorization,
                     @Body ServiceCompleteJson serviceCompleteJson);

    @POST("place-accept")
    io.reactivex.Observable<PlaceAcceptResponse>
    getPlaceAccept(@Header("Authorization") String authorization,
                     @Body PlaceAcceptJson placeAcceptJson);

    @POST("place-reject")
    io.reactivex.Observable<PlaceRejectResponse>
    getPlaceReject(@Header("Authorization") String authorization,
                     @Body PlaceAcceptJson placeAcceptJson);

    @POST("place-cancel")
    io.reactivex.Observable<PlaceCancelResponse>
    getPlaceCancel(@Header("Authorization") String authorization,
                     @Body PlaceAcceptJson placeAcceptJson);

    @POST("place-complete")
    io.reactivex.Observable<PlaceCompleteResponse>
    getPlaceComplete(@Header("Authorization") String authorization,
                       @Body PlaceAcceptJson placeAcceptJson);

    @POST("store-enquiry-delete")
    io.reactivex.Observable<StoreLeadDeleteResponse>
    getStoreLeadDelete(@Header("Authorization") String authorization,
                     @Body StoreLeadDeleteJson storeLeadDeleteJson);

    @GET("get-all-by-user")
    io.reactivex.Observable<GetInvoiceBillListResponse>
    getGetViewBill(@Header("Authorization") String authorization,
                   @Query("user_id") String userId);

    @POST("change-password")
    io.reactivex.Observable<ChangePasswordResponse>
    getChangePassword(@Header("Authorization") String authorization,
                  @Body ChangePasswordJson changePasswordJson);

    @POST("send-otp")
    io.reactivex.Observable<ChangePasswordResponse>
    getSendOtp(@Body SendOtpJson sendOtpJson);

    @POST("verify-otp")
    io.reactivex.Observable<ChangePasswordResponse>
    getVerifyOtp(@Body VerifyOtpJson verifyOtpJson);

    @POST("reset-password")
    io.reactivex.Observable<ResetPasswordResponse>
    getResetPassword(@Body ResetPasswordJson resetPasswordJson);

    @POST("logout")
    io.reactivex.Observable<LogoutResponse>
    getLogout(@Header("Authorization") String authorization);

    @POST("req-form-submit")
    io.reactivex.Observable<RequestFormResponse>
    getRequestForm(@Body RequestFormJson requestFormJson);


}
