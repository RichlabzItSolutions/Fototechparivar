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
import com.fototechparivar.business.databinding.ActivityForgotPasswordBinding;
import com.fototechparivar.business.model.ChangePassword.ChangePasswordResponse;
import com.fototechparivar.business.model.ChangePassword.SendOtpJson;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ForgotPasswordActivity extends AppCompatActivity {

    String strMobile;
    ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = ForgotPasswordActivity.this.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);

        getSupportActionBar().hide();

        binding.idSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strMobile = binding.edtMobileNumber.getText().toString().trim();

                char first = strMobile.charAt(0);

                Integer marks = Integer.parseInt(String.valueOf(first));

                Log.d("ty", String.valueOf(first));

                if (TextUtils.isEmpty(strMobile)) {
                    Toast.makeText(ForgotPasswordActivity.this, R.string.please_enter_your_mobile_number, Toast.LENGTH_SHORT).show();
                } else if (strMobile.length() < 10) {
                    Toast.makeText(ForgotPasswordActivity.this, R.string.please_enter_your_valid_mobile_number, Toast.LENGTH_SHORT).show();
                }
                else if (!(marks > 5)){
                    Toast.makeText(ForgotPasswordActivity.this, R.string.not_valid_mobile_number, Toast.LENGTH_SHORT).show();
                }
                else {
                    forGoutPassword();
                }

            }
        });
    }

    private void forGoutPassword() {

        if (Uttils.getInternetConnection(ForgotPasswordActivity.this)) {

            Uttils.showProgressDialoug(ForgotPasswordActivity.this);

            ApiHandler.getApiService().getSendOtp(new SendOtpJson(strMobile))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<ChangePasswordResponse>() {
                        @Override
                        public void onNext(ChangePasswordResponse changePasswordResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!changePasswordResponse.getStatusCode().equals("200")) {

                                    Toast.makeText(ForgotPasswordActivity.this, changePasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (changePasswordResponse.getStatusCode().equals("200")) {

                                    Toast.makeText(ForgotPasswordActivity.this, changePasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(ForgotPasswordActivity.this, VerifyOTPActivity.class);

                                    intent.putExtra("strMobile", strMobile);

                                    startActivity(intent);
                                    // finish();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(ForgotPasswordActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                              Uttils.dismissDialoug();
                            Toast.makeText(ForgotPasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                             Uttils.dismissDialoug();
                        }
                    });

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}