package com.yoeki.kalpnay.hrporatal.all_employee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.Payroll.PayStuctureAdapter;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;
import java.util.List;

public class AllEmployeeActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton buttonBack;
    RecyclerView recyclerViewAllEmployee;
    TextView textViewDesignation, textViewNAme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_employee);
        initialize();
        getAllEmployees();
    }

    List<AllEmployee_Model> AllEmployeeList = new ArrayList<>();
    private void getAllEmployees() {
        AllEmployee_Model allEmployee_model = new AllEmployee_Model();
        allEmployee_model.setName("Ankush Tomar");
        allEmployee_model.setDesignation("Manager");
        allEmployee_model.setEmail("ankush@yoeki.com");
        allEmployee_model.setImage("");
        allEmployee_model.setPhoneNumber("9876543210");
        AllEmployeeList.add(allEmployee_model);
        setAdapter(AllEmployeeList);
    }

    private void setAdapter(List<AllEmployee_Model> allEmployeeList) {

        AllEmployeeAdapter allEmployeeAdapter = new AllEmployeeAdapter(this, allEmployeeList);
        recyclerViewAllEmployee.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewAllEmployee.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAllEmployee.setAdapter(allEmployeeAdapter);

    }

    public void initialize() {
        buttonBack = findViewById(R.id.buttonBack);
        recyclerViewAllEmployee = findViewById(R.id.recyclerViewAllEmployee);
        textViewNAme = findViewById(R.id.textViewNAme);
        textViewDesignation = findViewById(R.id.textViewDesignation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBack: {
                finish();
                break;
            }
        }


    }
}
