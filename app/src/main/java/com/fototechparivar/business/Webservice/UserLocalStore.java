package com.fototechparivar.business.Webservice;

import android.content.Context;
import android.content.SharedPreferences;

import com.fototechparivar.business.model.Login.GetLoginDetails;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Login.StoreValueToken;


public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }


    public void storeUserToken(StoreValueToken cUserToken){
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("token", cUserToken.getToken());
        userLocalDatabaseEditor.putString("newBillCheckStatus", cUserToken.getNewBillCheckStatus());
        userLocalDatabaseEditor.putString("message", cUserToken.getMessage());
        userLocalDatabaseEditor.putString("statusCode", cUserToken.getStatusCode());

        userLocalDatabaseEditor.apply();

    }


    public StoreValueToken  getLoggedInUserToken() {
        String token = userLocalDatabase.getString("token", "");
        String newBillCheckStatus = userLocalDatabase.getString("newBillCheckStatus", "");
        String message = userLocalDatabase.getString("message", "");
        String statusCode = userLocalDatabase.getString("statusCode", "");

        StoreValueToken cUserToken = new StoreValueToken(token, newBillCheckStatus, message, statusCode );

        return cUserToken;
    }


    public void storeUserData(GetLoginDetailsLocalStore cUser ) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("userId", cUser.getUserId());
        userLocalDatabaseEditor.putString("firstName", cUser.getFirstName());
        userLocalDatabaseEditor.putString("lastName", cUser.getLastName());
        userLocalDatabaseEditor.putString("emailId", cUser.getEmailId());
        userLocalDatabaseEditor.putString("mobileNumber", cUser.getMobileNumber());
        userLocalDatabaseEditor.putString("profileImage", cUser.getProfileImage());

        userLocalDatabaseEditor.apply();
    }

    public GetLoginDetailsLocalStore getLoggedInUser() {
        String userId = userLocalDatabase.getString("userId", "");
        String firstName = userLocalDatabase.getString("firstName", "");
        String lastName = userLocalDatabase.getString("lastName", "");
        String emailId = userLocalDatabase.getString("emailId", "");
        String mobileNumber = userLocalDatabase.getString("mobileNumber", "");
        String profileImage = userLocalDatabase.getString("profileImage", "");


        GetLoginDetailsLocalStore cUser = new GetLoginDetailsLocalStore(userId, firstName, lastName, emailId,mobileNumber, profileImage);
        return cUser;
    }


    public void clearUserData() {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.clear();
        userLocalDatabaseEditor.apply();
    }

}
