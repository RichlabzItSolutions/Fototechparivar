package com.fototechparivar.business.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.fototechparivar.business.databinding.ViewbillsLayoutBinding;
import com.fototechparivar.business.model.invoice.GetInvoiceBillListDetails;
import java.util.ArrayList;

public class ViewBillAdapter extends RecyclerView.Adapter<ViewBillAdapter.MyViewHolder> /*implements View.OnClickListener*/ {

    Context context;
    ArrayList<GetInvoiceBillListDetails> data =new ArrayList<>();;

    public ViewBillAdapter(Context context, /*ArrayList<GetInvoiceBillListDetails> list_country,*/ ArrayList<GetInvoiceBillListDetails> getInvoiceBillListDetailsArrayList ) {
        this.context = context;
        data = getInvoiceBillListDetailsArrayList;

    }

    @NonNull
    @Override
    public ViewBillAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewbillsLayoutBinding binding = ViewbillsLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewBillAdapter.MyViewHolder holder, int position ) {

        Integer i = 1;

        GetInvoiceBillListDetails getInvoiceBillListDetails = data.get(position);

        holder.binding.storeNumberBillTxt.setText(getInvoiceBillListDetails.getStore_bill_number());
        holder.binding.salesDetailsbillTxt.setText(getInvoiceBillListDetails.getSale_service_details());
        holder.binding.membershipDetailbillText.setText(getInvoiceBillListDetails.getMobile_number());
        holder.binding.couponCodeBillTxt.setText(getInvoiceBillListDetails.getEnter_code());
        holder.binding.amountBillTxt.setText(getInvoiceBillListDetails.getBill_amount());

        holder.binding.nameBill.setText(getInvoiceBillListDetails.getFirst_name());

        Log.d("uio", getInvoiceBillListDetails.getMobile_number());

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

        ViewbillsLayoutBinding binding;

        public MyViewHolder(ViewbillsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
