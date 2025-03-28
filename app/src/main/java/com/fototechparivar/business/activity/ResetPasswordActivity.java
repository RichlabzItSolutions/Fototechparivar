package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.databinding.ActivityResetPasswordBinding;
import com.fototechparivar.business.model.ResetPassword.ResetPasswordJson;
import com.fototechparivar.business.model.ResetPassword.ResetPasswordResponse;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ResetPasswordActivity extends AppCompatActivity {

    ActivityResetPasswordBinding binding;
    String strMobile,  NewPassword, ConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = ResetPasswordActivity.this.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);

        // objLogin = this;
        getSupportActionBar().hide();

        Intent intent4 = getIntent();

        strMobile = intent4.getStringExtra("strMobile");

        binding.backId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        binding.ivShowPasswordNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                togglePasswordNewVisibility();
            }
        });

        binding.ivShowPasswordConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                togglePasswordConfirmVisibility();

            }
        });

        binding.idSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewPassword = binding.edtNewPassword.getText().toString().trim();
                ConfirmPassword = binding.edtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(NewPassword)) {

                    Toast.makeText(ResetPasswordActivity.this, R.string.please_enter_your_new_password, Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(ConfirmPassword)) {

                    Toast.makeText(ResetPasswordActivity.this, R.string.please_enter_your_confirm_password, Toast.LENGTH_SHORT).show();

                }  else if (!TextUtils.equals(NewPassword, ConfirmPassword)) {

                    Toast.makeText(ResetPasswordActivity.this, R.string.password_not_match, Toast.LENGTH_SHORT).show();

                }
                else {

                    resetPassword();

                }
            }
        });

    }

    private void resetPassword() {

        if (Uttils.getInternetConnection(ResetPasswordActivity.this)) {

            Uttils.showProgressDialoug(ResetPasswordActivity.this);

            Log.d("nm", strMobile);

            ApiHandler.getApiService().getResetPassword(new ResetPasswordJson(strMobile, NewPassword, ConfirmPassword))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<ResetPasswordResponse>() {
                        @Override
                        public void onNext(ResetPasswordResponse resetPasswordResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!resetPasswordResponse.getMessage().equals("Password reset successfully")) {

                                    Toast.makeText(ResetPasswordActivity.this, resetPasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (resetPasswordResponse.getMessage().equals("Password reset successfully")) {

                                    Toast.makeText(ResetPasswordActivity.this, resetPasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(ResetPasswordActivity.this, LoginActivity.class));
                                    finish();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(ResetPasswordActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }


                        }

                        @Override
                        public void onError(@NotNull Throwable e) {
                            Uttils.dismissDialoug();
                            Toast.makeText(ResetPasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                            Uttils.dismissDialoug();
                        }
                    });

        }

    }

    private void togglePasswordNewVisibility() {
        if (binding.edtNewPassword.getTransformationMethod() == null) {
            binding.edtNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.ivShowPasswordNew.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_off, null));
        } else {
            binding.edtNewPassword.setTransformationMethod(null);
            binding.ivShowPasswordNew.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_open, null));
        }

        // Move cursor to the end of the text
        binding.edtNewPassword.setSelection(binding.edtNewPassword.getText().length());
    }

    private void togglePasswordConfirmVisibility() {
        if (binding.edtConfirmPassword.getTransformationMethod() == null) {
            binding.edtConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.ivShowPasswordConfirm.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_off, null));
        } else {
            binding.edtConfirmPassword.setTransformationMethod(null);
            binding.ivShowPasswordConfirm.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_open, null));
        }
        // Move cursor to the end of the text
        binding.edtConfirmPassword.setSelection(binding.edtConfirmPassword.getText().length());
    }

}