package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.databinding.ActivityLoginBinding;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Login.GetLoginResponse;
import com.fototechparivar.business.model.Login.LoginJson;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    String strEmail;
    String strPassword;
    Boolean doubleBackToExitPressedOnce = false;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = LoginActivity.this.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);

       // objLogin = this;
        getSupportActionBar().hide();

        binding.idForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
               // finish();

            }
        });

        binding.idRequestForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, RequestFormActivity.class));
                //finish();
            }
        });

        binding.ivShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                togglePasswordVisibility();
            }
        });

        binding.idLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strEmail = binding.edtUsername.getText().toString().trim();
                strPassword = binding.edtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(strEmail)) {

                    Toast.makeText(LoginActivity.this, R.string.please_enter_your_mobile_number, Toast.LENGTH_SHORT).show();

                } else if (strEmail.length() < 10) {

                    Toast.makeText(LoginActivity.this, R.string.please_enter_your_valid_mobile_number, Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(strPassword)) {

                    Toast.makeText(LoginActivity.this, R.string.please_enter_your_password, Toast.LENGTH_SHORT).show();

                } else {

                    login();

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.press_again_to_exit), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1500);
    }

    private void login() {

        if (Uttils.getInternetConnection(LoginActivity.this)) {

            Uttils.showProgressDialoug(LoginActivity.this);

            ApiHandler.getApiService().getLoginResponse(new LoginJson(strEmail, strPassword))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<GetLoginResponse>() {
                        @Override
                        public void onNext(GetLoginResponse getLoginResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!getLoginResponse.getMessage().equals("User Logged in Successful")) {

                                    Toast.makeText(LoginActivity.this, getLoginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (getLoginResponse.getMessage().equals("User Logged in Successful")) {

                                    Toast.makeText(LoginActivity.this, getLoginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    String token = getLoginResponse.getToken();
                                    String newBillCheckStatus = getLoginResponse.getNewBillCheckStatus();

                                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                                    // write all the data entered by the user in SharedPreference and apply
                                    myEdit.putString("token", token);
                                    myEdit.putString("newBillCheckStatus", newBillCheckStatus);

                                    myEdit.apply();



                                    String userId = getLoginResponse.getUserData().getUserId();
                                    String firstName = getLoginResponse.getUserData().getFirstName();
                                    String lastName = getLoginResponse.getUserData().getLastName();
                                    String emailId = getLoginResponse.getUserData().getEmailId();
                                    String mobileNumber = getLoginResponse.getUserData().getMobileNumber();
                                    String profileImage = getLoginResponse.getUserData().getProfileImage();

                                    GetLoginDetailsLocalStore cUser = new GetLoginDetailsLocalStore(userId, firstName, lastName, emailId, mobileNumber, profileImage);
                                    final UserLocalStore userLocalStore = new UserLocalStore(getApplicationContext());
                                    userLocalStore.storeUserData(cUser);


                                    Intent i_Home = new Intent(LoginActivity.this, HomeActivity.class);
                                    i_Home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                    startActivity(i_Home);
                                    finish();

                                } else {

                                    Toast.makeText(LoginActivity.this, getLoginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(LoginActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                              Uttils.dismissDialoug();
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                             Uttils.dismissDialoug();
                        }
                    });

        } else {

            Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
        }

    }

    private void togglePasswordVisibility() {
        if (binding.edtPassword.getTransformationMethod() == null) {
            binding.edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.ivShowPassword.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_off, null));
        } else {
            binding.edtPassword.setTransformationMethod(null);
            binding.ivShowPassword.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_open, null));
        }

        // Move cursor to the end of the text
        binding.edtPassword.setSelection(binding.edtPassword.getText().length());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}