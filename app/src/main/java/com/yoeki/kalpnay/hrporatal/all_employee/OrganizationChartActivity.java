package com.yoeki.kalpnay.hrporatal.all_employee;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;
import java.util.List;

public class OrganizationChartActivity extends AppCompatActivity {
    TextView textViewDesignation, textViewNAme, textViewField, textViewLocation, textViewDirectReports;
    private LinearLayout linearLayoutDirectReports, linearLayoutContainer;
    private ImageView imageViewManager;
    private String DETAIL = "Ankush Tomar";
    private AppCompatButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_chart);
        bindActivity();
        setData();
    }

    List<AllEmployee_Model> DirectReportsList = new ArrayList<>();
    List<AllEmployee_Model> AllEmployeeList = new ArrayList<>();

    private void setData() {
        DETAIL = getIntent().getStringExtra("DETAIL");
        if (DETAIL == null) {
            DETAIL = "Ankush Tomar";
        }
        if (DETAIL.equals("Ankush Tomar")) {
            AllEmployee_Model allEmployee_model = new AllEmployee_Model();
            allEmployee_model.setName("Ankush Tomar");
            allEmployee_model.setDesignation("Manager");
            allEmployee_model.setEmail("ankush@yoeki.com");
            allEmployee_model.setImage("");
            allEmployee_model.setManager("Varun Barman");
            allEmployee_model.setManagerDesignation("CEO");
            allEmployee_model.setPhoneNumber("9876543210");

            AllEmployee_Model allEmployee_model2 = new AllEmployee_Model();
            allEmployee_model2.setName("Aarati");
            allEmployee_model2.setDesignation("Android Developer");
            allEmployee_model2.setEmail("aarati@yoeki.com");
            allEmployee_model2.setImage("");
            allEmployee_model2.setManager("Ankush Tomar");
            allEmployee_model2.setManagerDesignation("Team Lead");
            allEmployee_model2.setPhoneNumber("9012345678");

            DirectReportsList.add(allEmployee_model2);

            AllEmployee_Model allEmployee_model3 = new AllEmployee_Model();
            allEmployee_model3.setName("Himanshu");
            allEmployee_model3.setDesignation("Android Developer");
            allEmployee_model3.setEmail("humanshu@yoeki.com");
            allEmployee_model3.setImage("");
            allEmployee_model3.setManager("Ankush Tomar");
            allEmployee_model3.setManagerDesignation("Team Lead");
            allEmployee_model3.setPhoneNumber("9087654321");
            DirectReportsList.add(allEmployee_model3);
            allEmployee_model.setDirectReportList(DirectReportsList);

            AllEmployeeList.add(allEmployee_model);
        } else if (DETAIL.equals("Varun Barman")) {
            AllEmployee_Model allEmployee_model = new AllEmployee_Model();
            allEmployee_model.setName("Varun Barman");
            allEmployee_model.setDesignation("CEO");
            allEmployee_model.setEmail("varunBarman@yoeki.com");
            allEmployee_model.setImage("");
            allEmployee_model.setManager("");
            allEmployee_model.setManagerDesignation("");
            allEmployee_model.setPhoneNumber("9876543210");

            AllEmployee_Model allEmployee_model2 = new AllEmployee_Model();
            allEmployee_model2.setName("Ankush Tomar");
            allEmployee_model2.setDesignation("Team Lead");
            allEmployee_model2.setEmail("ankush@yoeki.com");
            allEmployee_model2.setImage("");
            allEmployee_model2.setManager("");
            allEmployee_model2.setManagerDesignation("");
            allEmployee_model2.setPhoneNumber("9012345678");

            DirectReportsList.add(allEmployee_model2);

            allEmployee_model.setDirectReportList(DirectReportsList);

            AllEmployeeList.add(allEmployee_model);
        } else if (DETAIL.equals("Aarati")) {
            AllEmployee_Model allEmployee_model = new AllEmployee_Model();
            allEmployee_model.setName("Aarati");
            allEmployee_model.setDesignation("Android Developer");
            allEmployee_model.setEmail("aarati@yoeki.com");
            allEmployee_model.setImage("");
            allEmployee_model.setManager("Ankush Tomar");
            allEmployee_model.setManagerDesignation("Team Lead");
            allEmployee_model.setPhoneNumber("9876543210");

            AllEmployee_Model allEmployee_model2 = new AllEmployee_Model();
            allEmployee_model2.setName("Himanshu");
            allEmployee_model2.setDesignation("Android Developer");
            allEmployee_model2.setEmail("Himanshu@yoeki.com");
            allEmployee_model2.setImage("");
            allEmployee_model2.setManager("");
            allEmployee_model2.setManagerDesignation("");
            allEmployee_model2.setPhoneNumber("9012345678");

            DirectReportsList.add(allEmployee_model2);

            AllEmployee_Model allEmployee_model3 = new AllEmployee_Model();
            allEmployee_model3.setName("Mohit");
            allEmployee_model3.setDesignation("Android Developer");
            allEmployee_model3.setEmail("Mohit@yoeki.com");
            allEmployee_model3.setImage("");
            allEmployee_model3.setManager("");
            allEmployee_model3.setManagerDesignation("");
            allEmployee_model3.setPhoneNumber("9087654321");
            DirectReportsList.add(allEmployee_model3);
            allEmployee_model.setDirectReportList(DirectReportsList);

            AllEmployeeList.add(allEmployee_model);
        } else if (DETAIL.equals("Himanshu")) {
            AllEmployee_Model allEmployee_model = new AllEmployee_Model();
            allEmployee_model.setName("Himanshu");
            allEmployee_model.setDesignation("Android Developer");
            allEmployee_model.setEmail("Himanshu@yoeki.com");
            allEmployee_model.setImage("");
            allEmployee_model.setManager("Ankush Tomar");
            allEmployee_model.setManagerDesignation("Team Lead");
            allEmployee_model.setPhoneNumber("9876543210");

            AllEmployeeList.add(allEmployee_model);
        } else if (DETAIL.equals("Mohit")) {
            AllEmployee_Model allEmployee_model = new AllEmployee_Model();
            allEmployee_model.setName("Mohit");
            allEmployee_model.setDesignation("Android Developer");
            allEmployee_model.setEmail("Mohit@yoeki.com");
            allEmployee_model.setImage("");
            allEmployee_model.setManager("Ankush Tomar");
            allEmployee_model.setManagerDesignation("Team Lead");
            allEmployee_model.setPhoneNumber("9876543210");

            AllEmployeeList.add(allEmployee_model);
        }
        textViewNAme.setText(AllEmployeeList.get(0).getName());
        textViewDesignation.setText(AllEmployeeList.get(0).getDesignation());
        textViewField.setText(AllEmployeeList.get(0).getPhoneNumber());
        textViewLocation.setText(AllEmployeeList.get(0).getEmail());
        if (AllEmployeeList.get(0).getManager().length() == 0) {
            imageViewManager.setVisibility(View.GONE);
        } else {
            imageViewManager.setVisibility(View.VISIBLE);
        }
        if (AllEmployeeList.get(0).getDirectReportList() == null) {
            textViewDirectReports.setVisibility(View.GONE);
            linearLayoutDirectReports.setVisibility(View.GONE);
        } else if (AllEmployeeList.get(0).getDirectReportList().size() == 0) {
            textViewDirectReports.setVisibility(View.GONE);
            linearLayoutDirectReports.setVisibility(View.GONE);
        } else {
            textViewDirectReports.setVisibility(View.VISIBLE);
            linearLayoutDirectReports.setVisibility(View.VISIBLE);
            textViewDirectReports.setText(AllEmployeeList.get(0).getDirectReportList().size() + " Direct Reports");
            for (int i = 0; i < AllEmployeeList.get(0).getDirectReportList().size(); i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.direct_reports_layout, null);
                TextView textViewNAme = view.findViewById(R.id.textViewNAme);
                TextView textViewDesignation = view.findViewById(R.id.textViewDesignation);
                linearLayoutContainer = view.findViewById(R.id.linearLayoutContainer);
                linearLayoutContainer.setOrientation(LinearLayout.VERTICAL);
                linearLayoutContainer.setGravity(Gravity.CENTER);
                view.setTag(AllEmployeeList.get(0).getDirectReportList().get(i).getName());
                textViewNAme.setText(AllEmployeeList.get(0).getDirectReportList().get(i).getName());
                textViewDesignation.setText(AllEmployeeList.get(0).getDirectReportList().get(i).getDesignation());
                linearLayoutDirectReports.addView(view);
                final int finalI = i;
                linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OrganizationChartActivity.this, OrganizationChartActivity.class);
                        intent.putExtra("DETAIL", AllEmployeeList.get(0).getDirectReportList().get(finalI).getName());
                        startActivity(intent);
                    }
                });
            }
        }
        imageViewManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrganizationChartActivity.this, OrganizationChartActivity.class);
                intent.putExtra("DETAIL", AllEmployeeList.get(0).getManager().toString());
                startActivity(intent);
            }
        });

    }

    private void bindActivity() {
        textViewNAme = findViewById(R.id.textViewNAme);
        textViewDesignation = findViewById(R.id.textViewDesignation);
        textViewField = findViewById(R.id.textViewField);
        textViewLocation = findViewById(R.id.textViewLocation);
        textViewDirectReports = findViewById(R.id.textViewDirectReports);
        linearLayoutDirectReports = findViewById(R.id.linearLayoutDirectReports);
        imageViewManager = findViewById(R.id.imageViewManager);
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
