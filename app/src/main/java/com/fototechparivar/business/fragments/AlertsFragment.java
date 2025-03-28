package com.fototechparivar.business.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fototechparivar.business.R;
import com.fototechparivar.business.databinding.ActivityViewBillsBinding;
import com.fototechparivar.business.databinding.FragmentAlertsBinding;


public class AlertsFragment extends Fragment {


   /* UserLocalStore userLocalStore;
    GetLoginDetails user;
    RecyclerView viewBillrecylerview;
    ImageView back;


    ArrayList<GetInvoiceBillListDetails> invoiceList;

    String token;

    String c;

    ViewBilladpter viewBilladpter;*/

    FragmentAlertsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // View view = inflater.inflate(R.layout.fragment_alerts, container, false);

        binding = FragmentAlertsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


     /*   viewBillrecylerview = (RecyclerView) view.findViewById(R.id.viewBillrecylerview);
        back = (ImageView) view.findViewById(R.id.back);


        userLocalStore = new UserLocalStore(getActivity());
        user = userLocalStore.getLoggedInUser();



        SharedPreferences sh = this.getActivity().getSharedPreferences("MySharedPref", getActivity().MODE_PRIVATE);
        token = sh.getString("token", "");

        String b = "Bearer ";
        Log.d("zxc", token);

        c = b+token;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //navigateToSecondFragment();

            }
        });

        getBillList();

*/
        return view;
    }


   /* private void getBillList() {


        Log.d("nikunj", user.getUserId());

        ApiHandler.getApiService().getGetViewBill(c, user.getUserId())
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<GetInvoiceBillListResponse>() {
                    @Override
                    public void onNext(GetInvoiceBillListResponse getInvoiceBillListResponse) {
                        // Uttils.dismissDialoug();

                        if (!getInvoiceBillListResponse.getStatusCode().equals("200")) {



                        } else if (getInvoiceBillListResponse.getStatusCode().equals("200")) {

                            //Log.d("tgh", String.valueOf(getProvinceResponse));

                            //Log.d("sdv", getInvoiceBillListResponse.getAllBills().toString());

                            invoiceList = new ArrayList<>();
                           // invoiceList = getInvoiceBillListResponse.getAllBills();


                            *//*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            viewBillrecylerview.setLayoutManager(linearLayoutManager);*//*


                            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                            viewBillrecylerview.setLayoutManager(layoutManager);

                            invoiceList.addAll(getInvoiceBillListResponse.getAllBills());


                            viewBilladpter = new ViewBilladpter(getActivity(), invoiceList);
                            viewBillrecylerview.setAdapter(viewBilladpter);



                            //openCountryDialog("All User");

                        }
                        else{


                        }
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {

                        // Uttils.dismissDialoug();
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {
                        //Uttils.dismissDialoug();
                    }
                });

    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}