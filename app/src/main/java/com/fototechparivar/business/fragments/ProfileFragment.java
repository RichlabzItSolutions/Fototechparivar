package com.fototechparivar.business.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.Webservice.UserLocalStore;
import com.fototechparivar.business.activity.ChangePasswordActivity;
import com.fototechparivar.business.activity.HomeActivity;
import com.fototechparivar.business.activity.LoginActivity;
import com.fototechparivar.business.activity.ResetPasswordActivity;
import com.fototechparivar.business.databinding.FragmentProfileBinding;
import com.fototechparivar.business.model.Login.GetLoginDetailsLocalStore;
import com.fototechparivar.business.model.Logout.LogoutResponse;
import com.fototechparivar.business.model.Uttils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class ProfileFragment extends Fragment {

    String token, c, newBillCheckStatus;

    UserLocalStore userLocalStore;
    GetLoginDetailsLocalStore user;

    SharedPreferences sh;

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(getLayoutInflater());

        BottomNavigationView botnav=((HomeActivity)getContext()).findViewById(R.id.bottomNavigationView);
        botnav.getMenu().getItem(3).setChecked(true);
       // View view = binding.getRoot();


/*        logoId = (ImageView) view.findViewById(R.id.logoId);
        logoutId = (LinearLayout) view.findViewById(R.id.idLogout);
        idChangePassword = (LinearLayout) view.findViewById(R.id.idChangePassword);
        idFirstName = (TextView)view.findViewById(R.id.idFirstName);
        idPhone = (TextView)view.findViewById(R.id.idPhone);
        back = (ImageView)view.findViewById(R.id.back);*/


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requireActivity().getOnBackPressedDispatcher().onBackPressed();

            }
        });

        binding.idChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);

                startActivity(intent);

            }
        });

        userLocalStore = new UserLocalStore(getActivity());
        user = userLocalStore.getLoggedInUser();

        String profile =  user.getProfileImage();

        Glide.with(getActivity())
                .load(user.getProfileImage())
                .placeholder(R.drawable.ic_home_screen_logo)
                .into(binding.logoId);

        binding.idFirstName.setText(user.getFirstName());

        binding.idPhone.setText(user.getMobileNumber());

        sh = getActivity().getSharedPreferences("MySharedPref", getActivity().MODE_PRIVATE);
        token = sh.getString("token", "");
       // newBillCheckStatus = sh.getString("newBillCheckStatus", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("zxp", c);


        binding.idLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final UserLocalStore userLocalStore = new UserLocalStore(getActivity());
                userLocalStore.clearUserData();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref",getActivity(). MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.clear();

                myEdit.apply();


                startActivity(new Intent(getActivity(), LoginActivity.class));
                ((Activity)getActivity()).finish();
                //Logout();
            }
        });

        return binding.getRoot();

    }



    /*private void Logout() {

        Log.d("wse", c);

        if (Uttils.getInternetConnection(getActivity())) {

            Uttils.showProgressDialoug(getActivity());

            ApiHandler.getApiService().getLogout(c)
                    .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<LogoutResponse>() {
                        @Override
                        public void onNext(LogoutResponse logutResponse) {
                            Uttils.dismissDialoug();

                            try {

                                if (!logutResponse.getMessage().equals("Successfully logged out")) {

                                    Toast.makeText(getActivity(), logutResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                } else {

                                    Toast.makeText(getActivity(), logutResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    final UserLocalStore userLocalStore = new UserLocalStore(getActivity());
                                    userLocalStore.clearUserData();

                                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref",getActivity(). MODE_PRIVATE);
                                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                                    myEdit.clear();

                                    myEdit.apply();

                                    Log.d("nml", token);
                                    Log.d("nml", user.getUserId());

                                    startActivity(new Intent(getActivity(), LoginActivity.class));
                                    ((Activity)getActivity()).finish();


                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Login", "Exception: " + e.getMessage());
                                Toast.makeText(getActivity(), "Exception occurred", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                            Uttils.dismissDialoug();
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

                            e.printStackTrace();

                        }

                        @Override
                        public void onComplete() {
                            Uttils.dismissDialoug();
                        }
                    });

        }

    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}