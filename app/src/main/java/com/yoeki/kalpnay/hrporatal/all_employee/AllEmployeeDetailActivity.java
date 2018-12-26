package com.yoeki.kalpnay.hrporatal.all_employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllEmployeeDetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 1f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer, linearLayoutDirectReports, linearLayoutContainer, linearLayoutManager, linearLayoutText, linearLayoutDirectReportsTop;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    TextView textViewDesignation, textViewNAme, textViewPhone, textViewEmail, textViewNAmeManager, textViewDesignationManager, textViewOrgranizationChart;
    private CollapsingToolbarLayout main_collapsing;
    private View viewContainer;
    private AppCompatButton buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_employee_detail);
        bindActivity();
        mAppBarLayout.addOnOffsetChangedListener(this);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        getIntentData();
    }

    List<AllEmployee_Model> DirectReportsList = new ArrayList<>();
    List<AllEmployee_Model> AllEmployeeList = new ArrayList<>();

    private void getIntentData() {
        String DETAIL = getIntent().getStringExtra("DETAIL");
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

        mTitle.setText(AllEmployeeList.get(0).getName());
        textViewNAme.setText(AllEmployeeList.get(0).getName());
        textViewDesignation.setText(AllEmployeeList.get(0).getDesignation());
        textViewPhone.setText(AllEmployeeList.get(0).getPhoneNumber());
        textViewEmail.setText(AllEmployeeList.get(0).getEmail());
        textViewNAmeManager.setText(AllEmployeeList.get(0).getManager());
        textViewDesignationManager.setText(AllEmployeeList.get(0).getManagerDesignation());
        if (AllEmployeeList.get(0).getManager().length() == 0) {
            linearLayoutManager.setVisibility(View.GONE);
        } else {
            linearLayoutManager.setVisibility(View.VISIBLE);
        }
        if (AllEmployeeList.get(0).getDirectReportList() == null) {
            linearLayoutDirectReportsTop.setVisibility(View.GONE);
        } else if (AllEmployeeList.get(0).getDirectReportList().size() == 0) {
            linearLayoutDirectReportsTop.setVisibility(View.GONE);
        } else {
            linearLayoutDirectReportsTop.setVisibility(View.VISIBLE);
            for (int i = 0; i < AllEmployeeList.get(0).getDirectReportList().size(); i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.direct_reports_layout, null);
                TextView textViewNAme = view.findViewById(R.id.textViewNAme);
                TextView textViewDesignation = view.findViewById(R.id.textViewDesignation);
                linearLayoutContainer = view.findViewById(R.id.linearLayoutContainer);
                linearLayoutText = view.findViewById(R.id.linearLayoutText);
                linearLayoutContainer.setGravity(Gravity.LEFT);
                linearLayoutText.setGravity(Gravity.LEFT);
                view.setTag(AllEmployeeList.get(0).getDirectReportList().get(i).getName());
                textViewNAme.setText(AllEmployeeList.get(0).getDirectReportList().get(i).getName());
                textViewDesignation.setText(AllEmployeeList.get(0).getDirectReportList().get(i).getDesignation());
                linearLayoutDirectReports.addView(view);
                final int finalI = i;
                linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AllEmployeeDetailActivity.this, AllEmployeeDetailActivity.class);
                        intent.putExtra("DETAIL", AllEmployeeList.get(0).getDirectReportList().get(finalI).getName());
                        startActivity(intent);
                    }
                });
            }
        }

    }

    private void bindActivity() {
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mTitle = (TextView) findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.main_appbar);
        textViewNAme = findViewById(R.id.textViewNAme);
        textViewDesignation = findViewById(R.id.textViewDesignation);
        main_collapsing = findViewById(R.id.main_collapsing);
        viewContainer = findViewById(R.id.viewContainer);
        buttonBack = findViewById(R.id.buttonBackFull);
        textViewPhone = (TextView) findViewById(R.id.textViewPhone);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewNAmeManager = (TextView) findViewById(R.id.textViewNAmeManager);
        textViewDesignationManager = (TextView) findViewById(R.id.textViewDesignationManager);
        textViewOrgranizationChart = (TextView) findViewById(R.id.textViewOrgranizationChart);
        linearLayoutDirectReports = findViewById(R.id.linearLayoutDirectReports);
        linearLayoutManager = findViewById(R.id.linearLayoutManager);
        linearLayoutDirectReportsTop = findViewById(R.id.linearLayoutDirectReportsTop);
        onclickMethods();
    }

    private void onclickMethods() {
        linearLayoutManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllEmployeeDetailActivity.this, AllEmployeeDetailActivity.class);
                intent.putExtra("DETAIL", textViewNAmeManager.getText().toString());
                startActivity(intent);
            }
        });
        textViewOrgranizationChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllEmployeeDetailActivity.this, OrganizationChartActivity.class);
                startActivity(intent);
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;
        Log.d("percentage", percentage + " " + maxScroll);
        if (percentage >= 0.50) {
            viewContainer.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            viewContainer.setVisibility(View.VISIBLE);
        } else {
            viewContainer.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            viewContainer.setVisibility(View.GONE);
        }
        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;

            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;

            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}
