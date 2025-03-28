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
import com.fototechparivar.business.adpter.StoreLeadsAdapter;
import com.fototechparivar.business.databinding.ActivityStoreLeadsBinding;
import com.fototechparivar.business.model.Leads.LeadsJson;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeads;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeadsResponse;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class StoreLeadsActivity extends AppCompatActivity {

    String token, userId, c;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    StoreLeadsAdapter storeLeadsAdapter;
    ArrayList<StoreLeads> storeLeadsArrayList;
    ActivityStoreLeadsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStoreLeadsBinding.inflate(getLayoutInflater());
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

        getStoreLeads();

        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.refreshLayout.setRefreshing(false);
                //  patientList.clear();
                getStoreLeads();
                // patientList.clear();
                // patientListAdapter.notifyDataSetChanged();

            }
        });

    }

    private void getStoreLeads(){

        if (Uttils.getInternetConnection(StoreLeadsActivity.this)) {

            Uttils.showProgressDialoug(StoreLeadsActivity.this);

            ApiHandler.getApiService().getStoreLeads(c, new LeadsJson(userId, "4"))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<StoreLeadsResponse>() {
                        @Override
                        public void onNext(StoreLeadsResponse storeLeadsResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (storeLeadsResponse.getMessage().equals("No Store Leads Found")) {

                                    binding.dataNotCome.setVisibility(View.VISIBLE);
                                }

                                if (!storeLeadsResponse.getMessage().equals("Store Leads data retrieved successfully.")) {

                                    Toast.makeText(StoreLeadsActivity.this, storeLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (storeLeadsResponse.getMessage().equals("Store Leads data retrieved successfully.")) {

                                    Toast.makeText(StoreLeadsActivity.this, storeLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    storeLeadsArrayList = new ArrayList<>();

                                    storeLeadsArrayList.addAll(storeLeadsResponse.getStore_leads());

                                    LinearLayoutManager layoutManager = new LinearLayoutManager(StoreLeadsActivity.this);
                                    binding.StoreLeadsRecyclerView.setLayoutManager(layoutManager);

                                    storeLeadsAdapter = new StoreLeadsAdapter(StoreLeadsActivity.this, storeLeadsArrayList);
                                    binding.StoreLeadsRecyclerView.setAdapter(storeLeadsAdapter);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(StoreLeadsActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(StoreLeadsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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