package com.yoeki.kalpnay.hrporatal.Payroll;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;

public class ViewSalarystructureFragment extends Fragment implements View.OnClickListener {

    private RecyclerView ryc_payrollsalary;
    ArrayList<SalleryModel> salarylist;

    public ViewSalarystructureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_payroll_home, container, false);

        ryc_payrollsalary=view.findViewById(R.id.ryc_payrollsalary);

        salarylist=new ArrayList<>();

        SalleryModel data=new SalleryModel();
        data.setMonthname("November 2018");
        data.setMonthnamedetail("November");
        data.setSalaryamount("₹10000");

        salarylist.add(data);

        SalleryModel data2=new SalleryModel();
        data2.setMonthname("October 2018");
        data2.setMonthnamedetail("October");
        data2.setSalaryamount("₹10000");

        salarylist.add(data2);

        SalleryModel data3=new SalleryModel();
        data3.setMonthname("September 2018");
        data3.setMonthnamedetail("September");
        data3.setSalaryamount("₹10000");

        salarylist.add(data3);
        ryc_payrollsalary.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ryc_payrollsalary.setItemAnimator(new DefaultItemAnimator());
        SalaryAdpter adapter=new SalaryAdpter(getActivity(),salarylist);
        ryc_payrollsalary.setAdapter(adapter);

        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

        }

    }
}
