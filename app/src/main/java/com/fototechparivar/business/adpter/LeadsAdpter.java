package com.fototechparivar.business.adpter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fototechparivar.business.R;
import com.fototechparivar.business.activity.AlbumLeadActivity;
import com.fototechparivar.business.activity.PlaceBookingLeadsActivity;
import com.fototechparivar.business.activity.ServiceExportLeadsActivity;
import com.fototechparivar.business.activity.StoreLeadsActivity;
import com.fototechparivar.business.databinding.AlbumLeadLayoutBinding;
import com.fototechparivar.business.databinding.LeadsLayoutBinding;
import com.fototechparivar.business.model.LeadsModel;
import java.util.List;


public class LeadsAdpter extends  RecyclerView.Adapter<LeadsAdpter.ImageViewHolder>/*ArrayAdapter<InspiredModel>*/ {

    private List<LeadsModel> leadsModelList;
    private Context context;

    public LeadsAdpter(Context context, List<LeadsModel> leadsModelList) {

        this.leadsModelList = leadsModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public LeadsAdpter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LeadsLayoutBinding binding = LeadsLayoutBinding.inflate(inflater, parent, false);
        return new ImageViewHolder(binding);

        /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leads_layout, parent, false);
        return new LeadsAdpter.ImageViewHolder(view);*/
    }

    @Override
    public void onBindViewHolder(@NonNull LeadsAdpter.ImageViewHolder holder, int position) {
        LeadsModel leadsModel = leadsModelList.get(position);

        holder.binding.IdLeadImage.setImageResource(leadsModel.getImgId());
        holder.binding.IdLeadName.setText(leadsModel.getLeadsName());

        holder.binding.IdLeadLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (leadsModel.getLeadsName().equals("Album Leads")){

                    Intent intent = new Intent(context, AlbumLeadActivity.class);
                    context.startActivity(intent);

                }

                if (leadsModel.getLeadsName().equals("Location Leads")){

                    Intent intent = new Intent(context, PlaceBookingLeadsActivity.class);
                    context.startActivity(intent);

                }

                if (leadsModel.getLeadsName().equals("Expert Leads")){

                    Intent intent = new Intent(context, ServiceExportLeadsActivity.class);
                    context.startActivity(intent);

                }

                if (leadsModel.getLeadsName().equals("Store Leads")){

                    Intent intent = new Intent(context, StoreLeadsActivity.class);
                    context.startActivity(intent);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return leadsModelList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        /*private ImageView LeadImage;
        private TextView LeadName;
        private LinearLayout IdLeadLi;*/

        LeadsLayoutBinding binding;

        public ImageViewHolder(LeadsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            /*LeadImage = (ImageView) itemView.findViewById(R.id.IdLeadImage);
            IdLeadLi = (LinearLayout) itemView.findViewById(R.id.IdLeadLi);
            LeadName = (TextView) itemView.findViewById(R.id.IdLeadName);*/
          }
    }
}
