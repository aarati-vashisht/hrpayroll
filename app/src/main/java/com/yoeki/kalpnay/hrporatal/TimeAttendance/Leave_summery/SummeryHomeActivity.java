package com.yoeki.kalpnay.hrporatal.TimeAttendance.Leave_summery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.yoeki.kalpnay.hrporatal.Jobposting.JobPostingAdapter;
import com.yoeki.kalpnay.hrporatal.Jobposting.JobpostingHomeActivity;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;

public class SummeryHomeActivity extends AppCompatActivity implements View.OnClickListener {
     private ImageView img_leavesummeryback;
     private RecyclerView rcy_leavesummery;
     ArrayList<LeaveSummeryModel> arraysummery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summery_home);

        initialize();

        arraysummery=new ArrayList<>();

        img_leavesummeryback.setOnClickListener(this);

        adddata();
    }
    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.img_leavesummeryback:
                 finish();
                 break;
         }
    }
    public void initialize(){

        img_leavesummeryback=findViewById(R.id.img_leavesummeryback);
        rcy_leavesummery=findViewById(R.id.rcy_leavesummery);

    }

    public void adddata(){

        LeaveSummeryModel data=new LeaveSummeryModel();
        data.setDate("11/12/2018");
        data.setFromdate("15/12/2018");
        data.setTodate("18/12/2018");
        data.setLeavetype("Casual");
        data.setLeavecount("3");
        arraysummery.add(data);

        LeaveSummeryModel data1=new LeaveSummeryModel();
        data1.setDate("18/12/2018");
        data1.setFromdate("25/12/2018");
        data1.setTodate("28/12/2018");
        data1.setLeavetype("Sick");
        data1.setLeavecount("5");
        arraysummery.add(data1);

        LeaveSummeryModel data2=new LeaveSummeryModel();
        data2.setDate("18/12/2018");
        data2.setFromdate("25/12/2018");
        data2.setTodate("28/12/2018");
        data2.setLeavetype("Casual");
        data2.setLeavecount("4");
        arraysummery.add(data2);

        LeaveSummeryModel data3=new LeaveSummeryModel();
        data3.setDate("24/12/2018");
        data3.setFromdate("25/12/2018");
        data3.setTodate("28/12/2018");
        data3.setLeavetype("Sick");
        data3.setLeavecount("4");
        arraysummery.add(data3);

        LeaveSummeryModel data4=new LeaveSummeryModel();
        data4.setDate("24/12/2018");
        data4.setFromdate("25/12/2018");
        data4.setTodate("28/12/2018");
        data4.setLeavetype("Casual");
        data4.setLeavecount("4");
        arraysummery.add(data4);

        LeaveSummeryAdapter adapter = new LeaveSummeryAdapter(SummeryHomeActivity.this, arraysummery);
        rcy_leavesummery.setLayoutManager(new LinearLayoutManager(SummeryHomeActivity.this, LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_leavesummery.setItemAnimator(new DefaultItemAnimator());
        rcy_leavesummery.setAdapter(adapter);
    }
}
