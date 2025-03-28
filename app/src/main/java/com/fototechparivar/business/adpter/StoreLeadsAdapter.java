package com.fototechparivar.business.adpter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.activity.ServiceExportLeadsActivity;
import com.fototechparivar.business.activity.StoreLeadsActivity;
import com.fototechparivar.business.databinding.LeadsLayoutBinding;
import com.fototechparivar.business.databinding.StoreLeadsLayoutBinding;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCompleteJson;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCompleteResponse;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeadDeleteJson;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeadDeleteResponse;
import com.fototechparivar.business.model.Leads.StoreLead.StoreLeads;
import com.fototechparivar.business.model.Uttils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class StoreLeadsAdapter extends RecyclerView.Adapter<StoreLeadsAdapter.MyViewHolder> /*implements View.OnClickListener*/ {

    Context context;
    ArrayList<StoreLeads> data = new ArrayList<>();;
    Integer i= 0;
    String token, c;

    public StoreLeadsAdapter(Context context, ArrayList<StoreLeads> getStoreLeadsListDetailsArrayList ) {
        this.context = context;
        data = getStoreLeadsListDetailsArrayList;
    }

    @NonNull
    @Override
    public StoreLeadsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        StoreLeadsLayoutBinding binding = StoreLeadsLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull StoreLeadsAdapter.MyViewHolder holder, int position ) {

        Integer i = 1;
        StoreLeads storeLeads = data.get(position);

        SharedPreferences sh = context.getSharedPreferences("MySharedPref",context.MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("xcm", c);

        holder.binding.idOderNo.setText(storeLeads.getEnquiryId());
        holder.binding.idMessage.setText(storeLeads.getEnquiryMessage());
        holder.binding.emailID.setText(storeLeads.getEnquiryEmail());
        holder.binding.idPhone.setText(storeLeads.getEnquiryMobile());
        holder.binding.idName.setText(storeLeads.getEnquiryName());
        holder.binding.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        holder.binding.btnDeleteID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Uttils.getInternetConnection(context)) {

                    Uttils.showProgressDialoug(context);

                    ApiHandler.getApiService().getStoreLeadDelete(c, new StoreLeadDeleteJson( storeLeads.getEnquiryId()))
                            .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new DisposableObserver<StoreLeadDeleteResponse>() {
                                @Override
                                public void onNext(StoreLeadDeleteResponse storeLeadDeleteResponse) {
                                    Uttils.dismissDialoug();

                                    try {

                                        if (!storeLeadDeleteResponse.getMessage().equals("Enquiry Deleted Successfully!")) {

                                            Toast.makeText(context, storeLeadDeleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                        } else if (storeLeadDeleteResponse.getMessage().equals("Enquiry Deleted Successfully!")) {

                                            Toast.makeText(context, storeLeadDeleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            removeAtPosition(position);

                                            Intent refreshDelete = new Intent(context, StoreLeadsActivity.class);
                                            context.startActivity(refreshDelete);
                                            // context.finish();

                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        Log.e("Login", "Exception: " + e.getMessage());
                                        Toast.makeText(context, "Exception occurred", Toast.LENGTH_SHORT).show();

                                    }

                                }

                                @Override
                                public void onError(@NotNull Throwable e) {

                                    Uttils.dismissDialoug();
                                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

                                    e.printStackTrace();

                                }

                                @Override
                                public void onComplete() {
                                    Uttils.dismissDialoug();
                                }
                            });
                }


            }
        });

    }


    @Override
    public int getItemCount() {

        Log.d("sdf", String.valueOf(data.size()));

        return data.size();

    }

    @Override
    public long getItemId(int position) {
        return data.size();
    }

    public void removeAtPosition(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    // Initializing the Views
    public class MyViewHolder extends RecyclerView.ViewHolder {

        StoreLeadsLayoutBinding binding;

        public MyViewHolder(StoreLeadsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
