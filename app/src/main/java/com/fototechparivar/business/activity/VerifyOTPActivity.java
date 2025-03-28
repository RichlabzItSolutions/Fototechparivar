package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.databinding.ActivityVerifyOtpactivityBinding;
import com.fototechparivar.business.model.ChangePassword.ChangePasswordResponse;
import com.fototechparivar.business.model.ChangePassword.VerifyOtpJson;
import com.fototechparivar.business.model.Uttils;
import com.mukesh.OnOtpCompletionListener;
import org.jetbrains.annotations.NotNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class VerifyOTPActivity extends AppCompatActivity {

    String strOTP, strMobile;
    ActivityVerifyOtpactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVerifyOtpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = VerifyOTPActivity.this.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);

        // objLogin = this;
        getSupportActionBar().hide();

        binding.backId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent3 = getIntent();

        strMobile = intent3.getStringExtra("strMobile");


        binding.priViewMobileID.setText(R.string.verify_otp_desc + strMobile );

        binding.otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {

                Log.d("onOtpCompleted=>", otp);

                binding.idVerifyOtp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        strOTP = binding.otpView.getText().toString().trim();

                        if (TextUtils.isEmpty(strOTP)) {
                            Toast.makeText(VerifyOTPActivity.this, R.string.please_enter_your_otp, Toast.LENGTH_SHORT).show();
                        } else if (!TextUtils.equals(strOTP, otp)) {
                            Toast.makeText(VerifyOTPActivity.this, R.string.wrong_otp, Toast.LENGTH_SHORT).show();
                        } else {
                            OtpVerify();
                        }

                    }
                });

            }
        });

    }

    private void OtpVerify() {

        if (Uttils.getInternetConnection(VerifyOTPActivity.this)) {

            Uttils.showProgressDialoug(VerifyOTPActivity.this);

            ApiHandler.getApiService().getVerifyOtp(new VerifyOtpJson(strMobile, strOTP))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<ChangePasswordResponse>() {
                        @Override
                        public void onNext(ChangePasswordResponse changePasswordResponse) {
                            Uttils.dismissDialoug();


                            try {

                                if (!changePasswordResponse.getStatusCode().equals("200")) {

                                    Toast.makeText(VerifyOTPActivity.this, changePasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (changePasswordResponse.getStatusCode().equals("200")) {

                                    Toast.makeText(VerifyOTPActivity.this, changePasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(VerifyOTPActivity.this, ResetPasswordActivity.class);

                                    intent.putExtra("strMobile", strMobile);

                                    startActivity(intent);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(VerifyOTPActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(VerifyOTPActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                            Uttils.dismissDialoug();
                        }
                    });

        }

    }
}