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
import com.fototechparivar.business.activity.AlbumLeadActivity;
import com.fototechparivar.business.activity.PlaceBookingLeadsActivity;
import com.fototechparivar.business.databinding.LeadsLayoutBinding;
import com.fototechparivar.business.databinding.PlaceBookingLeadsLayoutBinding;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptJson;
import com.fototechparivar.business.model.Leads.Album.AlbumAcceptResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCancelResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteJson;
import com.fototechparivar.business.model.Leads.Album.AlbumCompleteResponse;
import com.fototechparivar.business.model.Leads.Album.AlbumRejectResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceAcceptJson;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceAcceptResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceCancelResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceCompleteResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlaceRejectResponse;
import com.fototechparivar.business.model.Leads.PlaceLead.PlacesLeads;
import com.fototechparivar.business.model.Uttils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PlaceLeadsAdapter extends RecyclerView.Adapter<PlaceLeadsAdapter.MyViewHolder> /*implements View.OnClickListener*/ {

    Context context;
    ArrayList<PlacesLeads> data = new ArrayList<>();
    Integer i= 0;
    String token, userId;
    String c;

    public PlaceLeadsAdapter(Context context,  ArrayList<PlacesLeads> getInvoiceBillListDetailsArrayList ) {
        this.context = context;
        data = getInvoiceBillListDetailsArrayList;
    }

    @NonNull
    @Override
    public PlaceLeadsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PlaceBookingLeadsLayoutBinding binding = PlaceBookingLeadsLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull PlaceLeadsAdapter.MyViewHolder holder, int position ) {

        Integer i = 1;
        PlacesLeads placesLeads = data.get(position);

        SharedPreferences sh = context.getSharedPreferences("MySharedPref",context.MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        Log.d("xcm", c);


        if (placesLeads.getStatus().equals("1")){

            holder.binding.idStatus.setText(R.string.New);
            holder.binding.idMessage.setText(placesLeads.getEnquiryMessage());


            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_red));
            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_sky));

            holder.binding.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Uttils.getInternetConnection(context)) {

                        Uttils.showProgressDialoug(context);

                        ApiHandler.getApiService().getPlaceAccept(c, new PlaceAcceptJson( placesLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<PlaceAcceptResponse>() {
                                    @Override
                                    public void onNext(PlaceAcceptResponse placeAcceptResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!placeAcceptResponse.getMessage().equals("Accepted Successful ")) {

                                                Toast.makeText(context, placeAcceptResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (placeAcceptResponse.getMessage().equals("Accepted Successful ")) {

                                                Toast.makeText(context, placeAcceptResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshAcc = new Intent(context, PlaceBookingLeadsActivity.class);
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

                        ApiHandler.getApiService().getPlaceReject(c, new PlaceAcceptJson( placesLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<PlaceRejectResponse>() {
                                    @Override
                                    public void onNext(PlaceRejectResponse placeRejectResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!placeRejectResponse.getMessage().equals("Rejected Successful ")) {

                                                Toast.makeText(context, placeRejectResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (placeRejectResponse.getMessage().equals("Rejected Successful ")) {

                                                Toast.makeText(context, placeRejectResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshRej = new Intent(context, PlaceBookingLeadsActivity.class);
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

        if (placesLeads.getStatus().equals("2")){

            holder.binding.idStatus.setText(R.string.accepted);

            holder.binding.idMessage.setText(placesLeads.getEnquiryMessage());

            holder.binding.idClientDetails.setText(placesLeads.getClientName() + "\n"+ placesLeads.getClient_mobile());
            holder.binding.idEnquiryDetails.setText(placesLeads.getEnquiryMobile() + "\n"+ placesLeads.getEnquiryEmail() + "\n" + placesLeads.getEnquiryLocation() + "\n" + placesLeads.getAppointmentDate() + "\n" + placesLeads.getAppointmentTime());


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

                        ApiHandler.getApiService().getPlaceCancel(c, new PlaceAcceptJson( placesLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<PlaceCancelResponse>() {
                                    @Override
                                    public void onNext(PlaceCancelResponse placeCancelResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!placeCancelResponse.getMessage().equals("Canceled Successful ")) {

                                                Toast.makeText(context, placeCancelResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (placeCancelResponse.getMessage().equals("Canceled Successful ")) {

                                                Toast.makeText(context, placeCancelResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshCan = new Intent(context, PlaceBookingLeadsActivity.class);
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

                    if (Uttils.getInternetConnection(context)) {

                        Uttils.showProgressDialoug(context);

                        ApiHandler.getApiService().getPlaceComplete(c, new PlaceAcceptJson( placesLeads.getEnquiryId()))
                                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableObserver<PlaceCompleteResponse>() {
                                    @Override
                                    public void onNext(PlaceCompleteResponse placeCompleteResponse) {
                                        Uttils.dismissDialoug();

                                        try {

                                            if (!placeCompleteResponse.getMessage().equals("completed  Successful ")) {

                                                Toast.makeText(context, placeCompleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                            } else if (placeCompleteResponse.getMessage().equals("completed  Successful ")) {

                                                Toast.makeText(context, placeCompleteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                                Intent refreshCom = new Intent(context, PlaceBookingLeadsActivity.class);
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
            });


        }

        if (placesLeads.getStatus().equals("3")){

            holder.binding.idStatus.setText(R.string.rejected);

          //  holder.binding.idClientDetails.setText(placesLeads.getClientName() + "\n"+ placesLeads.getClient_mobile());
          //  holder.binding.idEnquiryDetails.setText(placesLeads.getEnquiryMobile() + "\n"+ placesLeads.getEnquiryEmail() + "\n" + placesLeads.getEnquiryLocation() + "\n" + placesLeads.getAppointmentDate() + "\n" + placesLeads.getAppointmentTime());



            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.red));

            holder.binding.btnReject.setText(R.string.rejected);

            holder.binding.btnAccept.setVisibility(View.GONE);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));

        }

        if (placesLeads.getStatus().equals("4")){

            holder.binding.idStatus.setText(R.string.cancelled);

            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.pink));

            holder.binding.btnAccept.setText(R.string.cancelled);
            holder.binding.btnReject.setVisibility(View.GONE);

            holder.binding.btnAccept.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_pink));


        }

        if (placesLeads.getStatus().equals("5")){

            holder.binding.idStatus.setText(R.string.completed);

            holder.binding.idMessage.setText(placesLeads.getEnquiryMessage());

            holder.binding.idClientDetails.setText(placesLeads.getClientName() + "\n"+ placesLeads.getClient_mobile());
            holder.binding.idEnquiryDetails.setText(placesLeads.getEnquiryMobile() + "\n"+ placesLeads.getEnquiryEmail() + "\n" + placesLeads.getEnquiryLocation() + "\n" + placesLeads.getAppointmentDate() + "\n" + placesLeads.getAppointmentTime());


            holder.binding.idStatus.setTextColor(context.getResources().getColor(R.color.sky));

            holder.binding.btnReject.setText(R.string.completed);

            holder.binding.btnAccept.setVisibility(View.GONE);

            holder.binding.btnReject.setBackground(context.getResources().getDrawable(R.drawable.boder_with_background_green_gray));


        }

       // holder.binding.idClientDetails.setText(placesLeads.getClientName());
      //  holder.binding.idEnquiryDetails.setText(placesLeads.getEnquirySource());
        holder.binding.leadDetailsID.setText(placesLeads.getEnquiryName() +"\n" +placesLeads.getEnquiryCdt());
        holder.binding.idOderNo.setText(placesLeads.getEnquiryId());

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

        PlaceBookingLeadsLayoutBinding binding;

        public MyViewHolder(PlaceBookingLeadsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


            //mobileNumberBillTxt = (TextView) view.findViewById(R.id.mobileNumberBillTxt);
        }
    }
}
