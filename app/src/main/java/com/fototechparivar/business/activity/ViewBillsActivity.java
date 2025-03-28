package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.adpter.ViewBillAdapter;
import com.fototechparivar.business.databinding.ActivityViewBillsBinding;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Uttils;
import com.fototechparivar.business.model.invoice.GetInvoiceBillListDetails;
import com.fototechparivar.business.model.invoice.GetInvoiceBillListResponse;
import org.jetbrains.annotations.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ViewBillsActivity extends AppCompatActivity {

    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    ArrayList<GetInvoiceBillListDetails> invoiceList;
    String token, c, startDate, date;
    ViewBillAdapter viewBillAdapter;
    private int mYear, mMonth, mDay;
    ActivityViewBillsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewBillsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        userLocalStore = new UserLocalStore(ViewBillsActivity.this);
        user = userLocalStore.getLoggedInUser();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date dates = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        startDate = format.format(dates);

        binding.etFromDate.setText(startDate);

        binding.etFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == binding.etFromDate) {
                    final Calendar calendar = Calendar.getInstance();
                    mYear = calendar.get(Calendar.YEAR);
                    mMonth = calendar.get(Calendar.MONTH);
                    mDay = calendar.get(Calendar.DATE);

                    //show dialog
                    DatePickerDialog datePickerDialog = new DatePickerDialog(ViewBillsActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // fromdate.setText (dayOfMonth + "-" + (month + 1) + "-" + year );
                            binding.etFromDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                }
            }
        });


        binding.etToDate.setText(date);

        binding.etToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == binding.etToDate) {
                    final Calendar calendar = Calendar.getInstance();
                    mYear = calendar.get(Calendar.YEAR);
                    mMonth = calendar.get(Calendar.MONTH);
                    mDay = calendar.get(Calendar.DATE);

                    //show dialog
                    DatePickerDialog datePickerDialog = new DatePickerDialog(ViewBillsActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            binding.etToDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                }
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

        getBillList();


        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.refreshLayout.setRefreshing(false);
                //  patientList.clear();
                getBillList();
                // patientList.clear();
                // patientListAdapter.notifyDataSetChanged();

            }
        });


    }

    private void getBillList() {

        Log.d("nikunj", user.getUserId());

        if (Uttils.getInternetConnection(ViewBillsActivity.this)) {

            Uttils.showProgressDialoug(ViewBillsActivity.this);

            ApiHandler.getApiService().getGetViewBill(c, user.getUserId())
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<GetInvoiceBillListResponse>() {
                        @Override
                        public void onNext(GetInvoiceBillListResponse getInvoiceBillListResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!getInvoiceBillListResponse.getStatusCode().equals("200")) {

                                } else if (getInvoiceBillListResponse.getStatusCode().equals("200")) {

                                    //Log.d("tgh", String.valueOf(getProvinceResponse));

                                    //Log.d("sdv", getInvoiceBillListResponse.getAllBills().toString());
                                    invoiceList = new ArrayList<>();

                                    LinearLayoutManager layoutManager = new LinearLayoutManager(ViewBillsActivity.this);
                                    binding.viewBillrecylerview.setLayoutManager(layoutManager);

                                    invoiceList.addAll(getInvoiceBillListResponse.getAllBills());

                                    viewBillAdapter = new ViewBillAdapter(ViewBillsActivity.this, invoiceList);
                                    binding.viewBillrecylerview.setAdapter(viewBillAdapter);

                                } else {


                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(ViewBillsActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(ViewBillsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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