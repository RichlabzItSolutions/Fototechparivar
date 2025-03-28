package com.fototechparivar.business.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fototechparivar.business.R;
import com.fototechparivar.business.model.Login.GetLoginDetails;


import java.util.ArrayList;
import java.util.Locale;


public class SelectCountryAdapter extends BaseAdapter {

    Context context;
    ArrayList<GetLoginDetails> data;
    private ArrayList<GetLoginDetails> arraylist;

    public SelectCountryAdapter(Context context, ArrayList<GetLoginDetails> list_country) {
        this.context = context;
        data = list_country;
        this.arraylist = new ArrayList<GetLoginDetails>();
        this.arraylist.addAll(data);

    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final ViewHolder holder;

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.list_select_contry, null);


            holder.txt_CountryName = (TextView) convertView.findViewById(R.id.txt_CountryName);


            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();

        }

        holder.txt_CountryName.setText(data.get(position).getFirstName()+ " - " +data.get(position).getMobileNumber());
        String provinceid =  data.get(position).getUserId();


        return convertView;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(arraylist);
        } else {
            for (GetLoginDetails wp : arraylist) {

                if (wp.getMobileNumber().toLowerCase(Locale.getDefault()).contains(charText)) {
                    data.add(wp);
                }

            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder {

        TextView txt_CountryName;

    }
}
