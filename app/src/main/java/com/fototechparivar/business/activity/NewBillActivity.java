package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.adpter.SelectCountryAdapter;
import com.fototechparivar.business.adpter.SelectCouponAdapter;
import com.fototechparivar.business.databinding.ActivityNewBillBinding;
import com.fototechparivar.business.model.Login.GetLoginDetails;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Uttils;
import com.fototechparivar.business.model.invoice.GenerateInvoiceNumberResponse;
import com.fototechparivar.business.model.invoice.GenerateNewBillJson;
import com.fototechparivar.business.model.invoice.GenerateNewBillResponse;
import com.fototechparivar.business.model.invoice.GetAllUserResponse;
import com.fototechparivar.business.model.invoice.GetCouponCodeJson;
import com.fototechparivar.business.model.invoice.GetCouponCodeListDetails;
import com.fototechparivar.business.model.invoice.GetCouponCodeResponse;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewBillActivity extends AppCompatActivity {

    String  mobile_number, invoice_no, store_bill_number, Cupan_code, sale_service_details, bill_amount, selectedUserId, selectedCouponCodeId,  token, userId, c;
    Dialog dialog_GetCountryList;
    Dialog dialog_GetCountryList1;
    ArrayList<GetLoginDetails> provinceList;
    ArrayList<GetCouponCodeListDetails> provinceList1;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    NewBillActivity newBillActivity;
    ActivityNewBillBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewBillBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        newBillActivity = this;

        provinceList = new ArrayList<>();

        provinceList1 = new ArrayList<>();

        userLocalStore = new UserLocalStore(this);
        user = userLocalStore.getLoggedInUser();

        userId = user.getUserId();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
         token = sh.getString("token", "");

         String b = "Bearer ";
        Log.d("zxc", token);

         c = b+token;

        Log.d("zxp", c);

        binding.etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getProvinceList();

            }
        });



        ApiHandler.getApiService().getGetInvoiceNumber(c)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<GenerateInvoiceNumberResponse>() {
                    @Override
                    public void onNext(GenerateInvoiceNumberResponse getProvinceResponse) {
                        //Uttils.dismissDialoug();


                        try {
                            if (getProvinceResponse.getStatusCode().equals("200")) {

                                //Log.d("rtg", getProvinceResponse.getData());
                                binding.etInvoice.setText(getProvinceResponse.getData());

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("Login", "Exception: " + e.getMessage());
                            Toast.makeText(NewBillActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        // Uttils.dismissDialoug();
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        //Uttils.dismissDialoug();
                    }
                });




        binding.etCouponCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCouponList();
                /*try {
                    if (selectedUserId.isEmpty() ) {
                        Toast.makeText(newBillActivity, R.string.please_select_first_user, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        getCouponList();
                    }

                }
                catch (Exception e){
                    Toast.makeText(newBillActivity, R.string.please_select_first_user, Toast.LENGTH_SHORT).show();
                }*/
            }
        });





        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // refreshActivity();
                invoice_no = binding.etInvoice.getText().toString().trim();
                mobile_number = binding.etUserName.getText().toString().trim();
                store_bill_number = binding.etStoreBill.getText().toString().trim();
                selectedCouponCodeId = binding.etCouponCode.getText().toString().trim();
                sale_service_details = binding.etSalesDetails.getText().toString().trim();
                bill_amount = binding.etBillAmount.getText().toString().trim();

                //Log.d("bnm", selectedUserId);

             /*   binding.etCouponCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (selectedUserId.isEmpty() ) {


                            Toast.makeText(newBillActivity, R.string.please_select_first_user, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            getCouponList();

                        }

                    }
                });*/

               if (TextUtils.isEmpty(mobile_number)) {

                    Toast.makeText(newBillActivity, R.string.please_select_user, Toast.LENGTH_SHORT).show();

                }
            /*   else if (TextUtils.isEmpty(store_bill_number)) {

                   Toast.makeText(newBillActivity, "Please Enter Store Bill Number", Toast.LENGTH_SHORT).show();

               }
               else if (TextUtils.isEmpty(Cupan_code)) {

                    Toast.makeText(newBillActivity, "Please Enter Coupan code", Toast.LENGTH_SHORT).show();

                }*/


            /*   else  if (selectedUserId.isEmpty()) {

                   Toast.makeText(newBillActivity, R.string.please_enter_sale_service_details, Toast.LENGTH_SHORT).show();

               }*/
                else  if (TextUtils.isEmpty(sale_service_details)) {

                    Toast.makeText(newBillActivity, R.string.please_enter_sale_service_details, Toast.LENGTH_SHORT).show();

                }

               else  if (TextUtils.isEmpty(bill_amount)) {

                   Toast.makeText(newBillActivity, R.string.please_enter_bill_amount, Toast.LENGTH_SHORT).show();

               }
              else {
                  getGenrateNewBills();

                }

            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    private void refreshActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void getProvinceList() {

        if (Uttils.getInternetConnection(newBillActivity)) {

            Uttils.showProgressDialoug(newBillActivity);
            Log.d("nikunj", c);

            ApiHandler.getApiService().getGetAllUsers(c)
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<GetAllUserResponse>() {
                        @Override
                        public void onNext(GetAllUserResponse getProvinceResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!getProvinceResponse.getMessage().equals("Users data retrieved successfully")) {

                                    Toast.makeText(newBillActivity, getProvinceResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (getProvinceResponse.getMessage().equals("Users data retrieved successfully")) {

                                    //Log.d("tgh", String.valueOf(getProvinceResponse));
                                    provinceList = getProvinceResponse.getData();

                                    openCountryDialog("All User");

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(NewBillActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                             Uttils.dismissDialoug();
                            Toast.makeText(newBillActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                            Uttils.dismissDialoug();
                        }
                    });

        }
    }

    private void openCountryDialog(String from) {

        dialog_GetCountryList = new Dialog(newBillActivity);
        dialog_GetCountryList.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_GetCountryList.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_GetCountryList.getWindow().setGravity(Gravity.CENTER);

        dialog_GetCountryList.setCanceledOnTouchOutside(true);

        //setting custom layout to dialog_car_variant
        dialog_GetCountryList.setContentView(R.layout.diloug_select_country);

        ListView lv_Country = dialog_GetCountryList.findViewById(R.id.lv_Country);
        EditText edt_SearchCountry = dialog_GetCountryList.findViewById(R.id.edt_Search);
        ImageView cancel_button = dialog_GetCountryList.findViewById(R.id.cancel_button);

        SelectCountryAdapter adapterSelectCountry;

        adapterSelectCountry = new SelectCountryAdapter(newBillActivity, provinceList);
        lv_Country.setAdapter(adapterSelectCountry);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog_GetCountryList.dismiss();

            }
        });

        edt_SearchCountry.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                adapterSelectCountry.filter(cs.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {


            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });

        lv_Country.setOnItemClickListener((parent, view, position, id) -> {

            String str_CountryName = provinceList.get(position).getFirstName();
            String str_Mobile = provinceList.get(position).getMobileNumber();
            //et_user_name.setText(str_CountryName +" - "+ str_Mobile);
            binding.etUserName.setText(str_Mobile);

            selectedUserId = provinceList.get(position).getUserId();

            dialog_GetCountryList.dismiss();
        });


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int height = displaymetrics.heightPixels / 2;
        int width = displaymetrics.widthPixels - 100;

        dialog_GetCountryList.getWindow().setLayout(width, height);

        dialog_GetCountryList.show();

    }





    private void getCouponList() {

        if (Uttils.getInternetConnection(newBillActivity)) {

            Uttils.showProgressDialoug(newBillActivity);
            Log.d("nikunj", c);

            ApiHandler.getApiService().getCouponCode(c, userId)
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<GetCouponCodeResponse>() {
                        @Override
                        public void onNext(GetCouponCodeResponse getCouponCodeResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (getCouponCodeResponse.getMessage().equals("Data Not Avalible")){


                                }

                                if (!getCouponCodeResponse.getMessage().equals("codes fetched Successfully!")) {

                                    Toast.makeText(newBillActivity, getCouponCodeResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (getCouponCodeResponse.getMessage().equals("codes fetched Successfully!")) {



                                    //Log.d("tgh", String.valueOf(getProvinceResponse));
                                    provinceList1 = getCouponCodeResponse.getData();

                                    openCountryDialog1("CouponCode");

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(NewBillActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(newBillActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                            Uttils.dismissDialoug();
                        }
                    });

        }
    }

    private void openCountryDialog1(String from) {

        dialog_GetCountryList1 = new Dialog(newBillActivity);
        dialog_GetCountryList1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_GetCountryList1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_GetCountryList1.getWindow().setGravity(Gravity.CENTER);

        dialog_GetCountryList1.setCanceledOnTouchOutside(true);

        //setting custom layout to dialog_car_variant
        dialog_GetCountryList1.setContentView(R.layout.diloug_select_country);

        ListView lv_Country1 = dialog_GetCountryList1.findViewById(R.id.lv_Country);
        EditText edt_SearchCountry = dialog_GetCountryList1.findViewById(R.id.edt_Search);
        ImageView cancel_button = dialog_GetCountryList1.findViewById(R.id.cancel_button);

        SelectCouponAdapter selectCouponAdapter;

        selectCouponAdapter = new SelectCouponAdapter(newBillActivity, provinceList1);
        lv_Country1.setAdapter(selectCouponAdapter);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog_GetCountryList1.dismiss();

            }
        });

        edt_SearchCountry.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                selectCouponAdapter.filter(cs.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {


            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });

        lv_Country1.setOnItemClickListener((parent, view, position, id) -> {

            String code = provinceList1.get(position).getCode();
            //String str_Mobile = provinceList1.get(position).getMobileNumber();
            //et_user_name.setText(str_CountryName +" - "+ str_Mobile);
            binding.etCouponCode.setText(code);

            selectedCouponCodeId = provinceList1.get(position).getId();

            dialog_GetCountryList1.dismiss();
        });


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int height = displaymetrics.heightPixels / 2;
        int width = displaymetrics.widthPixels - 100;

        dialog_GetCountryList1.getWindow().setLayout(width, height);

        dialog_GetCountryList1.show();

    }


    private void getGenrateNewBills(){

        if (Uttils.getInternetConnection(NewBillActivity.this)) {

            Uttils.showProgressDialoug(NewBillActivity.this);

            ApiHandler.getApiService().getGetNewBill(c, new GenerateNewBillJson(userId, mobile_number, invoice_no, store_bill_number, selectedCouponCodeId, sale_service_details, bill_amount))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<GenerateNewBillResponse>() {
                        @Override
                        public void onNext(GenerateNewBillResponse generateNewBillResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!generateNewBillResponse.getMessage().equals("New Bill Created Successfully")) {

                                    Toast.makeText(newBillActivity, generateNewBillResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (generateNewBillResponse.getMessage().equals("New Bill Created Successfully")) {

                                    Toast.makeText(newBillActivity, generateNewBillResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    //finish();
                                    refreshActivity();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("New Bill", "Exception: " + e.getMessage());
                                Toast.makeText(NewBillActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(newBillActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                            Uttils.dismissDialoug();
                        }
                    });
        }

    } /*else {

        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}