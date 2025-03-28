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
import com.fototechparivar.business.adpter.PlaceLeadsAdapter;
import com.fototechparivar.business.databinding.ActivityPlacebookingLeadsBinding;
import com.fototechparivar.business.model.Leads.LeadsJson;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceLeadsResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlacesLeads;

import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PlaceBookingLeadsActivity extends AppCompatActivity {

    String token, userId, c;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    PlaceLeadsAdapter placeLeadsAdapter;
    ArrayList<PlacesLeads> placesLeadsArrayList;
    ActivityPlacebookingLeadsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlacebookingLeadsBinding.inflate(getLayoutInflater());
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

        getPlaceLeads();


        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.refreshLayout.setRefreshing(false);
                //  patientList.clear();
                getPlaceLeads();
                // patientList.clear();
                // patientListAdapter.notifyDataSetChanged();

            }
        });

    }

    private void getPlaceLeads(){

        if (Uttils.getInternetConnection(PlaceBookingLeadsActivity.this)) {

            Uttils.showProgressDialoug(PlaceBookingLeadsActivity.this);

            ApiHandler.getApiService().getPlaceLeads(c, new LeadsJson(userId, "2"))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<PlaceLeadsResponse>() {
                        @Override
                        public void onNext(PlaceLeadsResponse placeLeadsResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (placeLeadsResponse.getMessage().equals("No Place Leads Found")) {

                                    binding.dataNotCome.setVisibility(View.VISIBLE);

                                }
                                if (!placeLeadsResponse.getMessage().equals("Place Leads data retrieved successfully.")) {

                                    Toast.makeText(PlaceBookingLeadsActivity.this, placeLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (placeLeadsResponse.getMessage().equals("Place Leads data retrieved successfully.")) {

                                    Toast.makeText(PlaceBookingLeadsActivity.this, placeLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    placesLeadsArrayList = new ArrayList<>();

                                    placesLeadsArrayList.addAll(placeLeadsResponse.getPlace_leads());

                                    LinearLayoutManager layoutManager = new LinearLayoutManager(PlaceBookingLeadsActivity.this);
                                    binding.PlaceLeadsRecyclerView.setLayoutManager(layoutManager);

                                    placeLeadsAdapter = new PlaceLeadsAdapter(PlaceBookingLeadsActivity.this, placesLeadsArrayList);
                                    binding.PlaceLeadsRecyclerView.setAdapter(placeLeadsAdapter);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(PlaceBookingLeadsActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(PlaceBookingLeadsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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