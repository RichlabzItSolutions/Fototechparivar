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
import com.fototechparivar.business.adpter.AlbumLeadsAdapter;
import com.fototechparivar.business.databinding.ActivityAlbumLeadBinding;
import com.fototechparivar.business.model.Leads.Album.AlbumLeads;
import com.fototechparivar.business.model.Leads.Album.AlbumLeadsResponse;
import com.fototechparivar.business.model.Leads.LeadsJson;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Uttils;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AlbumLeadActivity extends AppCompatActivity {

    String token, userId, c;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    AlbumLeadsAdapter albumLeadsAdapter;
    ArrayList<AlbumLeads> albumLeadsArrayList;
    ActivityAlbumLeadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlbumLeadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // setContentView(R.layout.activity_album_lead);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getSupportActionBar().hide();

        userLocalStore = new UserLocalStore(this);
        user = userLocalStore.getLoggedInUser();

        userId = user.getUserId();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("zxp", userId);

        getLeads();


        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.refreshLayout.setRefreshing(false);
                //  patientList.clear();
                getLeads();
                // patientList.clear();
                // patientListAdapter.notifyDataSetChanged();

            }
        });
    }

    private void getLeads(){

        if (Uttils.getInternetConnection(AlbumLeadActivity.this)) {

            Uttils.showProgressDialoug(AlbumLeadActivity.this);

            ApiHandler.getApiService().getAlbumLeads(c, new LeadsJson(userId, "1"))
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<AlbumLeadsResponse>() {
                        @Override
                        public void onNext(AlbumLeadsResponse albumLeadsResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (albumLeadsResponse.getMessage().equals("No Album Leads Found")) {

                                    binding.dataNotCome.setVisibility(View.VISIBLE);

                                }

                                if (!albumLeadsResponse.getMessage().equals("Album Leads data retrieved successfully.")) {

                                    Toast.makeText(AlbumLeadActivity.this, albumLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else if (albumLeadsResponse.getMessage().equals("Album Leads data retrieved successfully.")) {

                                    Toast.makeText(AlbumLeadActivity.this, albumLeadsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    albumLeadsArrayList = new ArrayList<>();

                                    albumLeadsArrayList.addAll(albumLeadsResponse.getAlbum_leads());

                                    LinearLayoutManager layoutManager = new LinearLayoutManager(AlbumLeadActivity.this);
                                    binding.AlbumRecyclerView.setLayoutManager(layoutManager);

                                    albumLeadsAdapter = new AlbumLeadsAdapter(AlbumLeadActivity.this, albumLeadsArrayList);
                                    albumLeadsAdapter.notifyDataSetChanged();

                                    binding.AlbumRecyclerView.setAdapter(albumLeadsAdapter);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(AlbumLeadActivity.this, "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(AlbumLeadActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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