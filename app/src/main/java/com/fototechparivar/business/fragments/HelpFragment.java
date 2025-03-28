package com.fototechparivar.business.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fototechparivar.business.R;
import com.fototechparivar.business.databinding.FragmentAlertsBinding;
import com.fototechparivar.business.databinding.FragmentHelpBinding;

public class HelpFragment extends Fragment {

    FragmentHelpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        binding = FragmentHelpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        // return inflater.inflate(R.layout.fragment_help, container, false);

        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}