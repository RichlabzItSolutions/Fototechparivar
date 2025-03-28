package com.fototechparivar.business.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLoginDetails {

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("userCode")
    @Expose
    private String userCode;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("userAddress")
    @Expose
    private String userAddress;
    @SerializedName("userCity")
    @Expose
    private String userCity;
    @SerializedName("userCountry")
    @Expose
    private String userCountry;
    @SerializedName("userState")
    @Expose
    private String userState;
    @SerializedName("userZipCode")
    @Expose
    private String userZipCode;
    @SerializedName("userContactName")
    @Expose
    private String userContactName;
    @SerializedName("userContactEmail")
    @Expose
    private String userContactEmail;
    @SerializedName("userContactMobile")
    @Expose
    private String userContactMobile;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("profileIdProof")
    @Expose
    private String profileIdProof;
    @SerializedName("paypalEmailId")
    @Expose
    private String paypalEmailId;
    @SerializedName("userFacebook")
    @Expose
    private String userFacebook;
    @SerializedName("userTwitter")
    @Expose
    private String userTwitter;
    @SerializedName("userYoutube")
    @Expose
    private String userYoutube;
    @SerializedName("userWebsite")
    @Expose
    private String userWebsite;
    @SerializedName("profileHelp")
    @Expose
    private String profileHelp;
    @SerializedName("registerMode")
    @Expose
    private String registerMode;
    @SerializedName("userType")
    @Expose
    private String userType;
    @SerializedName("userPlan")
    @Expose
    private String userPlan;
    @SerializedName("settingReview")
    @Expose
    private String settingReview;
    @SerializedName("settingShare")
    @Expose
    private String settingShare;
    @SerializedName("settingProfileShow")
    @Expose
    private String settingProfileShow;
    @SerializedName("settingGuaranteeShow")
    @Expose
    private String settingGuaranteeShow;
    @SerializedName("settingUserStatus")
    @Expose
    private String settingUserStatus;
    @SerializedName("settingListingShow")
    @Expose
    private String settingListingShow;
    @SerializedName("settingJobShow")
    @Expose
    private String settingJobShow;
    @SerializedName("settingExpertShow")
    @Expose
    private String settingExpertShow;
    @SerializedName("settingProductShow")
    @Expose
    private String settingProductShow;
    @SerializedName("settingBlogShow")
    @Expose
    private String settingBlogShow;
    @SerializedName("settingEventShow")
    @Expose
    private String settingEventShow;
    @SerializedName("settingCouponShow")
    @Expose
    private String settingCouponShow;
    @SerializedName("associationCode")
    @Expose
    private String associationCode;
    @SerializedName("userStatus")
    @Expose
    private String userStatus;
    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("userFollowers")
    @Expose
    private String userFollowers;
    @SerializedName("userSlug")
    @Expose
    private String userSlug;
    @SerializedName("userPoints")
    @Expose
    private String userPoints;
    @SerializedName("verificationCode")
    @Expose
    private String verificationCode;
    @SerializedName("verificationLink")
    @Expose
    private String verificationLink;
    @SerializedName("verificationStatus")
    @Expose
    private String verificationStatus;
    @SerializedName("userClearNotificationCdt")
    @Expose
    private String userClearNotificationCdt;
    @SerializedName("userCdt")
    @Expose
    private String userCdt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;


    public GetLoginDetails(String userId, String userCode, String firstName, String lastName, String emailId, String mobileNumber, String userAddress, String userCity, String userCountry, String userState, String userZipCode, String userContactName, String userContactEmail, String userContactMobile, String password, String dateOfBirth, String profileImage, String coverImage, String profileIdProof, String paypalEmailId, String userFacebook, String userTwitter, String userYoutube, String userWebsite, String profileHelp, String registerMode, String userType, String userPlan, String settingReview, String settingShare, String settingProfileShow, String settingGuaranteeShow, String settingUserStatus, String settingListingShow, String settingJobShow, String settingExpertShow, String settingProductShow, String settingBlogShow, String settingEventShow, String settingCouponShow, String associationCode, String userStatus, String paymentStatus, String userFollowers, String userSlug, String userPoints, String verificationCode, String verificationLink, String verificationStatus, String userClearNotificationCdt, String userCdt, String updatedAt, String createdAt) {
        super();
        this.userId = userId;
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userCountry = userCountry;
        this.userState = userState;
        this.userZipCode = userZipCode;
        this.userContactName = userContactName;
        this.userContactEmail = userContactEmail;
        this.userContactMobile = userContactMobile;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.profileImage = profileImage;
        this.coverImage = coverImage;
        this.profileIdProof = profileIdProof;
        this.paypalEmailId = paypalEmailId;
        this.userFacebook = userFacebook;
        this.userTwitter = userTwitter;
        this.userYoutube = userYoutube;
        this.userWebsite = userWebsite;
        this.profileHelp = profileHelp;
        this.registerMode = registerMode;
        this.userType = userType;
        this.userPlan = userPlan;
        this.settingReview = settingReview;
        this.settingShare = settingShare;
        this.settingProfileShow = settingProfileShow;
        this.settingGuaranteeShow = settingGuaranteeShow;
        this.settingUserStatus = settingUserStatus;
        this.settingListingShow = settingListingShow;
        this.settingJobShow = settingJobShow;
        this.settingExpertShow = settingExpertShow;
        this.settingProductShow = settingProductShow;
        this.settingBlogShow = settingBlogShow;
        this.settingEventShow = settingEventShow;
        this.settingCouponShow = settingCouponShow;
        this.associationCode = associationCode;
        this.userStatus = userStatus;
        this.paymentStatus = paymentStatus;
        this.userFollowers = userFollowers;
        this.userSlug = userSlug;
        this.userPoints = userPoints;
        this.verificationCode = verificationCode;
        this.verificationLink = verificationLink;
        this.verificationStatus = verificationStatus;
        this.userClearNotificationCdt = userClearNotificationCdt;
        this.userCdt = userCdt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserZipCode() {
        return userZipCode;
    }

    public void setUserZipCode(String userZipCode) {
        this.userZipCode = userZipCode;
    }

    public String getUserContactName() {
        return userContactName;
    }

    public void setUserContactName(String userContactName) {
        this.userContactName = userContactName;
    }

    public String getUserContactEmail() {
        return userContactEmail;
    }

    public void setUserContactEmail(String userContactEmail) {
        this.userContactEmail = userContactEmail;
    }

    public String getUserContactMobile() {
        return userContactMobile;
    }

    public void setUserContactMobile(String userContactMobile) {
        this.userContactMobile = userContactMobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getProfileIdProof() {
        return profileIdProof;
    }

    public void setProfileIdProof(String profileIdProof) {
        this.profileIdProof = profileIdProof;
    }

    public String getPaypalEmailId() {
        return paypalEmailId;
    }

    public void setPaypalEmailId(String paypalEmailId) {
        this.paypalEmailId = paypalEmailId;
    }

    public String getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(String userFacebook) {
        this.userFacebook = userFacebook;
    }

    public String getUserTwitter() {
        return userTwitter;
    }

    public void setUserTwitter(String userTwitter) {
        this.userTwitter = userTwitter;
    }

    public String getUserYoutube() {
        return userYoutube;
    }

    public void setUserYoutube(String userYoutube) {
        this.userYoutube = userYoutube;
    }

    public String getUserWebsite() {
        return userWebsite;
    }

    public void setUserWebsite(String userWebsite) {
        this.userWebsite = userWebsite;
    }

    public String getProfileHelp() {
        return profileHelp;
    }

    public void setProfileHelp(String profileHelp) {
        this.profileHelp = profileHelp;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPlan() {
        return userPlan;
    }

    public void setUserPlan(String userPlan) {
        this.userPlan = userPlan;
    }

    public String getSettingReview() {
        return settingReview;
    }

    public void setSettingReview(String settingReview) {
        this.settingReview = settingReview;
    }

    public String getSettingShare() {
        return settingShare;
    }

    public void setSettingShare(String settingShare) {
        this.settingShare = settingShare;
    }

    public String getSettingProfileShow() {
        return settingProfileShow;
    }

    public void setSettingProfileShow(String settingProfileShow) {
        this.settingProfileShow = settingProfileShow;
    }

    public String getSettingGuaranteeShow() {
        return settingGuaranteeShow;
    }

    public void setSettingGuaranteeShow(String settingGuaranteeShow) {
        this.settingGuaranteeShow = settingGuaranteeShow;
    }

    public String getSettingUserStatus() {
        return settingUserStatus;
    }

    public void setSettingUserStatus(String settingUserStatus) {
        this.settingUserStatus = settingUserStatus;
    }

    public String getSettingListingShow() {
        return settingListingShow;
    }

    public void setSettingListingShow(String settingListingShow) {
        this.settingListingShow = settingListingShow;
    }

    public String getSettingJobShow() {
        return settingJobShow;
    }

    public void setSettingJobShow(String settingJobShow) {
        this.settingJobShow = settingJobShow;
    }

    public String getSettingExpertShow() {
        return settingExpertShow;
    }

    public void setSettingExpertShow(String settingExpertShow) {
        this.settingExpertShow = settingExpertShow;
    }

    public String getSettingProductShow() {
        return settingProductShow;
    }

    public void setSettingProductShow(String settingProductShow) {
        this.settingProductShow = settingProductShow;
    }

    public String getSettingBlogShow() {
        return settingBlogShow;
    }

    public void setSettingBlogShow(String settingBlogShow) {
        this.settingBlogShow = settingBlogShow;
    }

    public String getSettingEventShow() {
        return settingEventShow;
    }

    public void setSettingEventShow(String settingEventShow) {
        this.settingEventShow = settingEventShow;
    }

    public String getSettingCouponShow() {
        return settingCouponShow;
    }

    public void setSettingCouponShow(String settingCouponShow) {
        this.settingCouponShow = settingCouponShow;
    }

    public String getAssociationCode() {
        return associationCode;
    }

    public void setAssociationCode(String associationCode) {
        this.associationCode = associationCode;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(String userFollowers) {
        this.userFollowers = userFollowers;
    }

    public String getUserSlug() {
        return userSlug;
    }

    public void setUserSlug(String userSlug) {
        this.userSlug = userSlug;
    }

    public String getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(String userPoints) {
        this.userPoints = userPoints;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationLink() {
        return verificationLink;
    }

    public void setVerificationLink(String verificationLink) {
        this.verificationLink = verificationLink;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getUserClearNotificationCdt() {
        return userClearNotificationCdt;
    }

    public void setUserClearNotificationCdt(String userClearNotificationCdt) {
        this.userClearNotificationCdt = userClearNotificationCdt;
    }

    public String getUserCdt() {
        return userCdt;
    }

    public void setUserCdt(String userCdt) {
        this.userCdt = userCdt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /* public GetLoginDetails(String userId, String firstName, String lastName, String email, String phoneno, String roleid, String facilityId*//*, String mobileNo*//*) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneno = phoneno;
        this.roleid = roleid;
        this.facilityId = facilityId;
        //this.mobileNo = mobileNo;
    }*/



    /*public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }*/

   /* public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }*/

}
