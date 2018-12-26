package com.yoeki.kalpnay.hrporatal.Payroll;

import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
=======
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoeki.kalpnay.hrporatal.R;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class SalaryEndsFragment extends Fragment {

    private RecyclerView ryc_AdvanceSalary;
=======
public class SalaryEndsFragment extends Fragment {

    public SalaryEndsFragment() {
        // Required empty public constructor
    }
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD

        View view = inflater.inflate(R.layout.fragment_salayend, container, false);

        ryc_AdvanceSalary = view.findViewById(R.id.ryc_AdvanceSalary);
        if (paystructuremodelList.size() == 0)
            paytructure();
        return view;
    }
    List<Advance_Salary_model> paystructuremodelList = new ArrayList<>();

    public void paytructure() {
        Advance_Salary_model paystructuremodel = new Advance_Salary_model();
        paystructuremodel.setAmount("₹5000");
        paystructuremodel.setLastPayBackDate("30-Nov-2018");
        paystructuremodel.setStartedOn("1-Nov-2018");
        paystructuremodel.setPayBackAmount("₹20000");
        paystructuremodelList.add(paystructuremodel);

        Advance_Salary_model paystructuremodel2 = new Advance_Salary_model();
        paystructuremodel2.setAmount("₹2500");
        paystructuremodel2.setLastPayBackDate("28-Nov-2018");
        paystructuremodel2.setStartedOn("1-Oct-2018");
        paystructuremodel2.setPayBackAmount("₹10000");
        paystructuremodelList.add(paystructuremodel2);


        AdvanceSalaryAdapter advanceSalaryAdapter = new AdvanceSalaryAdapter(getActivity(), paystructuremodelList);
        ryc_AdvanceSalary.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ryc_AdvanceSalary.setItemAnimator(new DefaultItemAnimator());
        ryc_AdvanceSalary.setAdapter(advanceSalaryAdapter);


    }

=======
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_salayend, container, false);

    }
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
}
