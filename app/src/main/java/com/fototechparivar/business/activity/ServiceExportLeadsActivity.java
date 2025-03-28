package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.adpter.ServiceLeadsAdapter;
import com.fototechparivar.business.databinding.ActivityServiceExportLeadsBinding;
import com.fototechparivar.business.model.Leads.LeadsJson;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceExpertLeads;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceLeadsResponse;

import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ServiceExportLeadsActivity extends AppCompatActivity {

    String token, userId, c;
    ActivityServiceExportLeadsBinding binding;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    ServiceLeadsAdapter serviceLeadsAdapter;
    ArrayList<ServiceExpertLeads> serviceExpertLeadsArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityServiceExportLeadsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        userLocalStore = new UserLocalStore(this);
        user = userLocalStore.getLoggedInUser();

        userId = user.getUserId();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("zxp", userId);

        getServiceLeads();


        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.refreshLayout.setRefreshing(false);
                //  patientList.clear();
                getServiceLeads();
                // patientList.clear();
                // patientListAdapter.notifyDataSetChanged();

            }
        });



    }

    private void getServiceLeads(){

        if (Uttils.getInternetConnection(ServiceExportLeadsActivity.this)) {

            Uttils.showProgressDialoug(ServiceExportLeadsActivity.this);

            ApiHandler.getApiService().getServiceLeads(c, new LeadsJson(userId, "3"))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<ServiceLeadsResponse>() {
                        @Override
                        public void onNext(ServiceLeadsResponse serviceLeadsResponse) {
                            Uttils.dismissDialoug();


                            try {

                                if (serviceLeadsResponse.getMessage().equals("No Service Expert Leads Found")) {

                                    binding.dataNotCome.setVisibility(View.VISIBLE);

                                }

                                if (!serviceLeadsResponse.getMessage().equals("Service Expert Leads data retrieved successfully.")) {

                                    Toast.makeText(ServiceExportLeadsActivity.this, serviceLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (serviceLeadsResponse.getMessage().equals("Service Expert Leads data retrieved successfully.")) {

                                    Toast.makeText(ServiceExportLeadsActivity.this, serviceLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    serviceExpertLeadsArrayList = new ArrayList<>();

                                    serviceExpertLeadsArrayList.addAll(serviceLeadsResponse.getExpert_leads());

                                    LinearLayoutManager layoutManager = new LinearLayoutManager(ServiceExportLeadsActivity.this);
                                    binding.ServiceLeadsRecyclerView.setLayoutManager(layoutManager);

                                    serviceLeadsAdapter = new ServiceLeadsAdapter(ServiceExportLeadsActivity.this, serviceExpertLeadsArrayList);
                                    binding.ServiceLeadsRecyclerView.setAdapter(serviceLeadsAdapter);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(ServiceExportLeadsActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(ServiceExportLeadsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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