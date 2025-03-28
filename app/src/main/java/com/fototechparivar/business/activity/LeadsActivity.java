package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.adpter.LeadsAdpter;
import com.fototechparivar.business.databinding.ActivityLeadsBinding;
import com.fototechparivar.business.model.LeadsModel;

import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;

import java.util.ArrayList;
import java.util.List;

public class LeadsActivity extends AppCompatActivity {

    private LeadsAdpter leadsAdpter;
    private List<LeadsModel> leadsModelList = new ArrayList<>();
    String token, userId, c;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    ActivityLeadsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLeadsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        c = b + token;

        Log.d("zxp", c);

        leadsModelList.add(new LeadsModel("Album Leads", R.drawable.albam_lead));
        leadsModelList.add(new LeadsModel("Store Leads", R.drawable.store_lead));
        leadsModelList.add(new LeadsModel("Expert Leads", R.drawable.expert_lead));
        leadsModelList.add(new LeadsModel("Location Leads", R.drawable.location_lead));

        GridLayoutManager layoutManager = new GridLayoutManager(LeadsActivity.this, 2);
        binding.recyclerView.setLayoutManager(layoutManager);
        leadsAdpter = new LeadsAdpter(LeadsActivity.this, leadsModelList);
        binding.recyclerView.setAdapter(leadsAdpter);

        //getLeads();
    }

}


