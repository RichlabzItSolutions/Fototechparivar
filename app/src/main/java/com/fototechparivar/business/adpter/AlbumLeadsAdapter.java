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
import com.fototechparivar.business.activity.StoreLeadsActivity;
import com.fototechparivar.business.databinding.AlbumLeadLayoutBinding;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptJson;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCancelResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteJson;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumLeads;
import com.fototechparivar.business.model.Leads.Album.AlbumRejectResponse;
import com.fototechparivar.business.model.Uttils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AlbumLeadsAdapter extends RecyclerView.Adapter<AlbumLeadsAdapter.MyViewHolder> /*implements View.OnClickListener*/ {

    Context context;
    ArrayList<AlbumLeads> data =new ArrayList<>();;
    Integer i= 0;
    String token, inVoiceNo, amount, c;
    EditText etInvoiceNumberID, etAmountID;
    TextView  SubmitId, albumNoteId;
    ImageView closeId;

    public AlbumLeadsAdapter(Context context,  ArrayList<AlbumLeads> getAlbumLeadsListDetailsArrayList ) {
        this.context = context;
        data = getAlbumLeadsListDetailsArrayList;

    }

    @NonNull
    @Override
    public AlbumLeadsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AlbumLeadLayoutBinding binding = AlbumLeadLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
        //View v = LayoutInflater.from(context).inflate(R.layout.album_lead_layout, parent, false);
       // return new AlbumLeadsAdapter.MyViewHolder();

    }

    @Override
    public void onBindViewHolder(@NonNull AlbumLeadsAdapter.MyViewHolder holder, int position ) {

        Integer i = 1;
        AlbumLeads albumLeads = data.get(position);

        SharedPreferences sh = context.getSharedPreferences("MySharedPref",context.MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        if (albumLeads.getStatus().equals("1")){

            holder.binding.idStatus.setText(R.string.New);

            holder.binding.idMessage.setText(albumLeads.getEnquiryMessage());


            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_red));
            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_sky));

            holder.binding.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Uttils.getInternetConnection(context)) {

                        Uttils.showProgressDialoug(context);

                        ApiHandler.getApiService().getAlbumAccept(c, new AlbumAcceptJson( albumLeads.getId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<AlbumAcceptResponse>() {
                                    @Override
                                    public void onNext(AlbumAcceptResponse albumAcceptResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!albumAcceptResponse.getMessage().equals("Status Changed Successfully!")) {

                                                Toast.makeText(context, albumAcceptResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (albumAcceptResponse.getMessage().equals("Status Changed Successfully!")) {

                                                Toast.makeText(context, albumAcceptResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshAcc = new Intent(context, AlbumLeadActivity.class);
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

                        ApiHandler.getApiService().getAlbumReject(c, new AlbumAcceptJson( albumLeads.getId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<AlbumRejectResponse>() {
                                    @Override
                                    public void onNext(AlbumRejectResponse albumRejectResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!albumRejectResponse.getMessage().equals("Album Enquiry Rejected  successfully!")) {

                                                Toast.makeText(context, albumRejectResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (albumRejectResponse.getMessage().equals("Album Enquiry Rejected  successfully!")) {

                                                Toast.makeText(context, albumRejectResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshRej = new Intent(context, AlbumLeadActivity.class);
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

        if (albumLeads.getStatus().equals("2")){

            holder.binding.idStatus.setText(R.string.accepted);

            holder.binding.idMessage.setText(albumLeads.getEnquiryMessage());

            holder.binding.nameCustomer.setText(albumLeads.getEnquiryName() + "\n" + albumLeads.getEnquiryEmail() + "\n" + albumLeads.getEnquiryMobile());
            holder.binding.liUrl.setVisibility(View.VISIBLE);
            holder.binding.ivUrl.setText(albumLeads.getAlbumUrls());


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

                        ApiHandler.getApiService().getAlbumCancel(c, new AlbumAcceptJson( albumLeads.getId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<AlbumCancelResponse>() {
                                    @Override
                                    public void onNext(AlbumCancelResponse albumCancelResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!albumCancelResponse.getMessage().equals("Album Enquiry Canceled  successfully!")) {

                                                Toast.makeText(context, albumCancelResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (albumCancelResponse.getMessage().equals("Album Enquiry Canceled  successfully!")) {

                                                Toast.makeText(context, albumCancelResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshCan = new Intent(context, AlbumLeadActivity.class);
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

                    Dialog dialog3 = new Dialog(context);

                    dialog3.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog3.setCancelable(false);
                    Window window = dialog3.getWindow();
                    dialog3.setCanceledOnTouchOutside(true);

                    dialog3.setContentView(R.layout.dilogbox_layout_album_lead_complete);


                    etAmountID = dialog3.findViewById(R.id.etAmountID);
                    closeId = dialog3.findViewById(R.id.closeId);
                    etInvoiceNumberID = dialog3.findViewById(R.id.etInvoiceNumberID);
                    SubmitId = dialog3.findViewById(R.id.SubmitId);
                    albumNoteId = dialog3.findViewById(R.id.albumNoteId);

                    albumNoteId.setText("Note: Verify details before saving. Entered bill amount affects cashback. Non-editable post submission." + "\n" + "Thanks for your attention.");

                   // Note: Verify details before saving. Entered bill amount affects cashback. Non-editable post submission. Thanks for your attention.
                    closeId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog3.dismiss();
                        }
                    });

                    SubmitId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            inVoiceNo = etInvoiceNumberID.getText().toString();
                            amount = etAmountID.getText().toString();

                            if (inVoiceNo.isEmpty()) {
                                Toast.makeText(context, "Please Enter Invoice Number", Toast.LENGTH_SHORT).show();
                            } else if (amount.isEmpty()){
                                Toast.makeText(context, "Please Enter Amount", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                dialog3.dismiss();


                                if (Uttils.getInternetConnection(context)) {
                                    Uttils.showProgressDialoug(context);

                                    ApiHandler.getApiService().getAlbumComplete(c, new AlbumCompleteJson( albumLeads.getId(), inVoiceNo, amount))
                                            .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(new DisposableObserver<AlbumCompleteResponse>() {
                                                @Override
                                                public void onNext(AlbumCompleteResponse albumCompleteResponse) {
                                                    Uttils.dismissDialoug();

                                                    try {

                                                        if (!albumCompleteResponse.getMessage().equals("Album Enquiry Completed Successfully!")) {

                                                            Toast.makeText(context, albumCompleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                        } else if (albumCompleteResponse.getMessage().equals("Album Enquiry Completed Successfully!")) {

                                                            Toast.makeText(context, albumCompleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                            Intent refreshCom = new Intent(context, AlbumLeadActivity.class);
                                                            context.startActivity(refreshCom);

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

                    dialog3.show();

                }
            });

        }

        if (albumLeads.getStatus().equals("3")){

            holder.binding.idStatus.setText(R.string.rejected);
            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.red));

            holder.binding.btnReject.setText(R.string.rejected);

            holder.binding.btnAccept.setVisibility(View.GONE);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));

        }

        if (albumLeads.getStatus().equals("4")){

            holder.binding.idStatus.setText(R.string.cancelled);

            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.pink));

            holder.binding.btnAccept.setText(R.string.cancelled);
            holder.binding.btnReject.setVisibility(View.GONE);

            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));


        }

        if (albumLeads.getStatus().equals("5")){

            holder.binding.idStatus.setText(R.string.completed);

            holder.binding.idMessage.setText(albumLeads.getEnquiryMessage());

            holder.binding.nameCustomer.setText(albumLeads.getEnquiryName() + "\n" + albumLeads.getEnquiryEmail() + "\n" + albumLeads.getEnquiryMobile());
            holder.binding.liUrl.setVisibility(View.VISIBLE);
            holder.binding.ivUrl.setText(albumLeads.getAlbumUrls());


            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.sky));

            holder.binding.btnReject.setText(R.string.completed);

            holder.binding.btnAccept.setVisibility(View.GONE);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_green_gray));

        }

        holder.binding.idApproxSheet.setText(albumLeads.getAproxNoofSheets());


        holder.binding.idNofAlbum.setText(albumLeads.getNoOfAlbums());

        holder.binding.idMessage.setText(albumLeads.getEnquiryMessage());

        holder.binding.idOderNo.setText(albumLeads.getId());


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
        /*TextView idOderNo, idApproxSheet, nameCustomer, idNofAlbum, idStatus, idMessage ;
        AppCompatButton btnAccept,btnReject;*/
        AlbumLeadLayoutBinding binding;

        public MyViewHolder( AlbumLeadLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            //mobileNumberBillTxt = (TextView) view.findViewById(R.id.mobileNumberBillTxt);
        }
    }

}
