package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.fototechparivar.business.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {


    ActivityNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

      //  setContentView(R.layout.activity_notification);
    }
}