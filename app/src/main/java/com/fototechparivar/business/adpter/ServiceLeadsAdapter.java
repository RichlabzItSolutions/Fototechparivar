package com.fototechparivar.business.adpter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.fototechparivar.business.R;
import com.fototechparivar.business.Webservice.ApiHandler;
import com.fototechparivar.business.activity.AlbumLeadActivity;
import com.fototechparivar.business.activity.ServiceExportLeadsActivity;
import com.fototechparivar.business.databinding.ExpertLeadsLayoutBinding;
import com.fototechparivar.business.databinding.LeadsLayoutBinding;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptJson;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCancelResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteJson;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumRejectResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceAcceptJson;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceAcceptResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCancelResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCompleteJson;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceCompleteResponse;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceExpertLeads;
import com.fototechparivar.business.model.Leads.ServiceExpert.ServiceRejectResponse;
import com.fototechparivar.business.model.Uttils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ServiceLeadsAdapter extends RecyclerView.Adapter<ServiceLeadsAdapter.MyViewHolder> /*implements View.OnClickListener*/ {

    Context context;
    ArrayList<ServiceExpertLeads> data = new ArrayList<>();;
    Integer i= 0;
    String token, inVoiceNo, amount, c;

    EditText  etAmount;
    TextView SubmitId, serviceNoteId;

    ImageView closeMaId;



    public ServiceLeadsAdapter(Context context, ArrayList<ServiceExpertLeads> getServiceExpertLeadsListDetailsArrayList ) {
        this.context = context;
        data = getServiceExpertLeadsListDetailsArrayList;
    }

    @NonNull
    @Override
    public ServiceLeadsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ExpertLeadsLayoutBinding binding = ExpertLeadsLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ServiceLeadsAdapter.MyViewHolder holder, int position ) {

        Integer i = 1;
        ServiceExpertLeads serviceExpertLeads = data.get(position);

        SharedPreferences sh = context.getSharedPreferences("MySharedPref",context.MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Dialog dialog1 = new Dialog(context);


        if (serviceExpertLeads.getEnquiryStatus().equals("1")){

            holder.binding.idStatus.setText(R.string.New);

            holder.binding.idMessage.setText(serviceExpertLeads.getEnquiryMessage());

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_red));
            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_sky));

            holder.binding.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Uttils.getInternetConnection(context)) {

                        Uttils.showProgressDialoug(context);

                        ApiHandler.getApiService().getServiceAccept(c, new ServiceAcceptJson( serviceExpertLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<ServiceAcceptResponse>() {
                                    @Override
                                    public void onNext(ServiceAcceptResponse serviceAcceptResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!serviceAcceptResponse.getMessage().equals("Accepted successful!")) {

                                                Toast.makeText(context, serviceAcceptResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (serviceAcceptResponse.getMessage().equals("Accepted successful!")) {

                                                Toast.makeText(context, serviceAcceptResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshAcc = new Intent(context, ServiceExportLeadsActivity.class);
                                                context.startActivity(refreshAcc);

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


            holder.binding.btnReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Uttils.getInternetConnection(context)) {

                        Uttils.showProgressDialoug(context);

                        ApiHandler.getApiService().getServiceReject(c, new ServiceAcceptJson( serviceExpertLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<ServiceRejectResponse>() {
                                    @Override
                                    public void onNext(ServiceRejectResponse serviceRejectResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!serviceRejectResponse.getMessage().equals("Rejected successful!")) {

                                                Toast.makeText(context, serviceRejectResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (serviceRejectResponse.getMessage().equals("Rejected successful!")) {

                                                Toast.makeText(context, serviceRejectResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshRej = new Intent(context, ServiceExportLeadsActivity.class);
                                                context.startActivity(refreshRej);

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

        if (serviceExpertLeads.getEnquiryStatus().equals("2")){

            holder.binding.idStatus.setText(R.string.accepted);

            holder.binding.idMessage.setText(serviceExpertLeads.getEnquiryMessage());
            holder.binding.leadDetailsID.setText(serviceExpertLeads.getEnquiryName() +"\n" +serviceExpertLeads.getEnquiryCdt());
            holder.binding.idEnquiryDetails.setText(serviceExpertLeads.getEnquiryMobile() + "\n"+ serviceExpertLeads.getEnquiryEmail() + "\n" + serviceExpertLeads.getEnquiryLocation() + "\n" + serviceExpertLeads.getAppointmentDate() + "\n" + serviceExpertLeads.getAppointmentTime());

            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.green));

            holder.binding.btnAccept.setText(R.string.cancel);

            holder.binding.btnReject.setText(R.string.complete);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_green_gray));
            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));

            holder.binding.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Uttils.getInternetConnection(context)) {

                        Uttils.showProgressDialoug(context);

                        ApiHandler.getApiService().getServiceCancel(c, new ServiceAcceptJson( serviceExpertLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<ServiceCancelResponse>() {
                                    @Override
                                    public void onNext(ServiceCancelResponse serviceCancelResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!serviceCancelResponse.getMessage().equals("Canceled successful!")) {

                                                Toast.makeText(context, serviceCancelResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (serviceCancelResponse.getMessage().equals("Canceled successful!")) {

                                                Toast.makeText(context, serviceCancelResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshCan = new Intent(context, ServiceExportLeadsActivity.class);
                                                context.startActivity(refreshCan);

                                                //refreshActivity();

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


            holder.binding.btnReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog1.setContentView(R.layout.dilogbox_layout_service_lead_complete);

                    dialog1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog1.setCancelable(false);
                    dialog1.setCanceledOnTouchOutside(true);

                    etAmount = dialog1.findViewById(R.id.etAmountID);
                    closeMaId = dialog1.findViewById(R.id.closeId);
                    SubmitId = dialog1.findViewById(R.id.SubmitId);
                    serviceNoteId = dialog1.findViewById(R.id.serviceNoteId);


                    serviceNoteId.setText("Note: Verify details before saving. Entered bill amount affects cashback. Non-editable post submission." + "\n" + "Thanks for your attention.");

                    closeMaId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog1.dismiss();

                        }
                    });

                    SubmitId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            amount = etAmount.getText().toString();

                            if (amount.isEmpty()){
                                Toast.makeText(context, "Please Enter Amount", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                dialog1.dismiss();


                                if (Uttils.getInternetConnection(context)) {

                                    Uttils.showProgressDialoug(context);

                                    ApiHandler.getApiService().getServiceComplete(c, new ServiceCompleteJson( serviceExpertLeads.getEnquiryId(), amount))
                                            .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(new DisposableObserver<ServiceCompleteResponse>() {
                                                @Override
                                                public void onNext(ServiceCompleteResponse serviceCompleteResponse) {
                                                    Uttils.dismissDialoug();

                                                    try {

                                                        if (!serviceCompleteResponse.getStatusCode().equals("200")) {

                                                            Toast.makeText(context, serviceCompleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                        } else if (serviceCompleteResponse.getStatusCode().equals("200")) {

                                                            Toast.makeText(context, serviceCompleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                            Intent refreshCom = new Intent(context, ServiceExportLeadsActivity.class);
                                                            context.startActivity(refreshCom);//Start the same Activity
                                                            // context.finish(); //finish Activity.

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
                        }
                    });

                    dialog1.show();


                }
            });


        }

        if (serviceExpertLeads.getEnquiryStatus().equals("3")){

            holder.binding.idStatus.setText(R.string.rejected);

            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.red));

            holder.binding.btnReject.setText(R.string.rejected);

            holder.binding.btnAccept.setVisibility(View.GONE);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));

        }

        if (serviceExpertLeads.getEnquiryStatus().equals("4")){

            holder.binding.idStatus.setText(R.string.cancelled);

/*
            holder.binding.leadDetailsID.setText(serviceExpertLeads.getEnquiryName() +"\n" +serviceExpertLeads.getEnquiryCdt());
            holder.binding.idEnquiryDetails.setText(serviceExpertLeads.getEnquiryMobile() + "\n"+ serviceExpertLeads.getEnquiryEmail() + "\n" + serviceExpertLeads.getEnquiryLocation() + "\n" + serviceExpertLeads.getAppointmentDate() + "\n" + serviceExpertLeads.getAppointmentTime());
*/

            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.pink));

            holder.binding.btnAccept.setText(R.string.cancelled);
            holder.binding.btnReject.setVisibility(View.GONE);

            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));

        }

        if (serviceExpertLeads.getEnquiryStatus().equals("5")){


            holder.binding.idMessage.setText(serviceExpertLeads.getEnquiryMessage());

            holder.binding.leadDetailsID.setText(serviceExpertLeads.getEnquiryName() +"\n" +serviceExpertLeads.getEnquiryCdt());
            holder.binding.idEnquiryDetails.setText(serviceExpertLeads.getEnquiryMobile() + "\n"+ serviceExpertLeads.getEnquiryEmail() + "\n" + serviceExpertLeads.getEnquiryLocation() + "\n" + serviceExpertLeads.getAppointmentDate() + "\n" + serviceExpertLeads.getAppointmentTime());

            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.sky));

            holder.binding.idStatus.setText(R.string.completed);

            holder.binding.btnReject.setText(R.string.completed);

            holder.binding.btnAccept.setVisibility(View.GONE);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_green_gray));

        }

       // holder.binding.idMessage.setText(serviceExpertLeads.getEnquiryMessage());

        holder.binding.idRating.setText(serviceExpertLeads.getExpertRating());


        holder.binding.idOderNo.setText(serviceExpertLeads.getEnquiryId());


        //  holder.binding.leadDetailsID.setText(serviceExpertLeads.getEnquiryName());

       // holder.binding.idEnquiryDetails.setText(serviceExpertLeads.getEnquirySource());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    // Initializing the Views
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ExpertLeadsLayoutBinding binding;

        public MyViewHolder(ExpertLeadsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
