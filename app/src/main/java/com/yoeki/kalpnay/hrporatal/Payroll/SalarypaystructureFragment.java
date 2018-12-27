package com.yoeki.kalpnay.hrporatal.Payroll;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.HomeMenu.EmployeeDetailActivity;
import com.yoeki.kalpnay.hrporatal.Login.Api;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.setting.preferance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalarypaystructureFragment extends Fragment {


    private RecyclerView ryc_earning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_salarypaystructure, container, false);

        ryc_earning = view.findViewById(R.id.ryc_earning);
        if (paystructuremodelList.size() == 0)
            paytructure();
        return view;
    }

    List<Paystructuremodel> paystructuremodelList = new ArrayList<>();

    public void paytructure() {
        Paystructuremodel paystructuremodel = new Paystructuremodel();
        paystructuremodel.setAmount("₹10000");
        paystructuremodel.setPayElement("Basic");
        paystructuremodel.setDate("18-Dec-2018");
        paystructuremodel.setPeriod("dsd");
        paystructuremodelList.add(paystructuremodel);

        Paystructuremodel paystructuremodel2 = new Paystructuremodel();
        paystructuremodel2.setAmount("₹20000");
        paystructuremodel2.setPayElement("Basic");
        paystructuremodel2.setDate("17-Dec-2018");
        paystructuremodel2.setPeriod("dsd");
        paystructuremodelList.add(paystructuremodel2);

        PayStuctureAdapter payStuctureAdapter = new PayStuctureAdapter(getActivity(), paystructuremodelList);
        ryc_earning.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ryc_earning.setItemAnimator(new DefaultItemAnimator());
        ryc_earning.setAdapter(payStuctureAdapter);


    }

    public void faillerdiaolog(String msg) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.failuremsg);

        TextView tv_failmsg = dialog.findViewById(R.id.tv_failmsg);
        tv_failmsg.setText(msg);

        TextView tv_cancelmsg = dialog.findViewById(R.id.tv_cancelmsg);
        tv_cancelmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });
        dialog.show();
    }
}
