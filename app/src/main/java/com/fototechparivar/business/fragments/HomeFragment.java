package com.fototechparivar.business.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.activity.LeadsActivity;
import com.fototechparivar.business.activity.NewBillActivity;
import com.fototechparivar.business.activity.ReportsActivity;
import com.fototechparivar.business.activity.ViewBillsActivity;
import com.fototechparivar.business.databinding.FragmentHomeBinding;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;


public class HomeFragment extends Fragment {

    String token, newBillCheckStatus, c;
    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;
    SharedPreferences sh;
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        userLocalStore = new UserLocalStore(getActivity());
        user = userLocalStore.getLoggedInUser();

       String profile =  user.getProfileImage();

        Glide.with(getActivity())
                .load(user.getProfileImage())
                .placeholder(R.drawable.ic_home_screen_logo)
                .into(binding.logoId);

        binding.idFirstName.setText(user.getFirstName());

         sh = getActivity().getSharedPreferences("MySharedPref", getActivity().MODE_PRIVATE);
        token = sh.getString("token", "");
        newBillCheckStatus = sh.getString("newBillCheckStatus", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("zxp", c);

        Log.d("ftg", newBillCheckStatus);
        Log.d("jkl", token);

        binding.idViewBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ViewBillsActivity.class);

                startActivity(intent);

            }
        });

        binding.IdReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ReportsActivity.class);

                startActivity(intent);

            }
        });

        binding.IdNewBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newBillCheckStatus.equals("false")){

                }
                else{

                    Intent intent = new Intent(getActivity(), NewBillActivity.class);
                    startActivity(intent);

                }
            }
        });

        binding.IdLead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), LeadsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }



}