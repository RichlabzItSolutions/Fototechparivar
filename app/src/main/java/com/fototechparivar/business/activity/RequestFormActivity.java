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
import com.fototechparivar.business.databinding.ActivityRequestFormBinding;
import com.fototechparivar.business.model.RequestForm.RequestFormJson;
import com.fototechparivar.business.model.RequestForm.RequestFormResponse;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RequestFormActivity extends AppCompatActivity {

    String BusinessName, YourName, EmailId, MobileNumber, City;
    ActivityRequestFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRequestFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = RequestFormActivity.this.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);

        // objLogin = this;
        getSupportActionBar().hide();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.idSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MobileNumber = binding.edtMobileNumber.getText().toString().trim();
                BusinessName = binding.edtBusinessName.getText().toString().trim();
                EmailId = binding.edtEmailID.getText().toString().trim();
                City = binding.edtCity.getText().toString().trim();
                YourName = binding.edtYourName.getText().toString().trim();

                char first = MobileNumber.charAt(0);

                Integer marks = Integer.parseInt(String.valueOf(first));

                if (TextUtils.isEmpty(MobileNumber)) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_mobile_number, Toast.LENGTH_SHORT).show();

                } else if (MobileNumber.length() < 10) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_valid_mobile_number, Toast.LENGTH_SHORT).show();

                } else if (!(marks > 5)){

                    Toast.makeText(RequestFormActivity.this, R.string.not_valid_mobile_number, Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(City)) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_city, Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(YourName)) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_Name, Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(BusinessName)) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_Business_Name, Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(EmailId)) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_email_id, Toast.LENGTH_SHORT).show();

                }
                else if (!Uttils.isValidEmail(EmailId)) {

                    Toast.makeText(RequestFormActivity.this, R.string.please_enter_your_valid_email_address, Toast.LENGTH_SHORT).show();

                }

                else {

                    requestForm();

                }

            }
        });

    }

    private void requestForm() {

        if (Uttils.getInternetConnection(RequestFormActivity.this)) {

            Uttils.showProgressDialoug(RequestFormActivity.this);

            ApiHandler.getApiService().getRequestForm(new RequestFormJson(BusinessName, YourName, EmailId, MobileNumber, City))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<RequestFormResponse>() {
                        @Override
                        public void onNext(RequestFormResponse requestFormResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!requestFormResponse.getMessage().equals("Request Submit Successfully!")) {

                                    Toast.makeText(RequestFormActivity.this, requestFormResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (requestFormResponse.getMessage().equals("Request Submit Successfully!")) {

                                    Toast.makeText(RequestFormActivity.this, requestFormResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    // Intent intent = new Intent(RequestFormActivity.this, LoginActivity.class);

                                    Intent intent = new Intent(RequestFormActivity.this, LoginActivity.class);
                                    //intent.putExtra("strMobile", strMobile);

                                    startActivity(intent);
                                    finish();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(RequestFormActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(RequestFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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