package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.databinding.ActivityChangePasswordBinding;
import com.fototechparivar.business.model.ChangePassword.ChangePasswordJson;
import com.fototechparivar.business.model.ChangePassword.ChangePasswordResponse;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ChangePasswordActivity extends AppCompatActivity {

    String oldPassword, newPassword, confirmPassword, token, c ;
    ActivityChangePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("zxp", c);

        binding.ivShowPasswordOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                togglePasswordOldVisibility();
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

                oldPassword = binding.edtOldPassword.getText().toString().trim();
                newPassword = binding.edtNewPassword.getText().toString().trim();
                confirmPassword = binding.edtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(oldPassword)) {
                    Toast.makeText(ChangePasswordActivity.this, R.string.please_enter_your_old_password, Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(newPassword)) {
                    Toast.makeText(ChangePasswordActivity.this, R.string.please_enter_your_new_password, Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(ChangePasswordActivity.this, R.string.please_enter_your_confirm_password, Toast.LENGTH_SHORT).show();
                }
                else if (!TextUtils.equals(newPassword, confirmPassword)) {
                    Toast.makeText(ChangePasswordActivity.this, R.string.password_not_match, Toast.LENGTH_SHORT).show();
                }
                else {
                    changePassword();
                }

            }
        });

    }

    private void changePassword() {

        if (Uttils.getInternetConnection(ChangePasswordActivity.this)) {

            Uttils.showProgressDialoug(ChangePasswordActivity.this);

            ApiHandler.getApiService().getChangePassword(c, new ChangePasswordJson(oldPassword, newPassword, confirmPassword))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<ChangePasswordResponse>() {
                        @Override
                        public void onNext(ChangePasswordResponse changePasswordResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!changePasswordResponse.getMessage().equals("Password changed successfully")) {

                                    Toast.makeText(ChangePasswordActivity.this, changePasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (changePasswordResponse.getMessage().equals("Password changed successfully")) {

                                    Toast.makeText(ChangePasswordActivity.this, changePasswordResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(ChangePasswordActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                              Uttils.dismissDialoug();
                            Toast.makeText(ChangePasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                             Uttils.dismissDialoug();
                        }
                    });

     }

    }

    private void togglePasswordOldVisibility() {
        if (binding.edtOldPassword.getTransformationMethod() == null) {
            binding.edtOldPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.ivShowPasswordOld.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_off, null));
        } else {
            binding.edtOldPassword.setTransformationMethod(null);
            binding.ivShowPasswordOld.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_password_open, null));
        }
        // Move cursor to the end of the text
        binding.edtOldPassword.setSelection(binding.edtOldPassword.getText().length());
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
