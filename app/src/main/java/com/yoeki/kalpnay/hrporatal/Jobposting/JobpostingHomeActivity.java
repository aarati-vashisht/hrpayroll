package com.yoeki.kalpnay.hrporatal.Jobposting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.shiftchangemanager.AllrequestAdapter;

import java.util.ArrayList;

public class JobpostingHomeActivity extends AppCompatActivity implements View.OnClickListener {

     private ImageView img_jobpostback;
     private RecyclerView rcy_jobposting;
     private ArrayList<Jobpostingmodel> jobarraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobposting_home);

        jobarraylist=new ArrayList<>();

        initialize();

        getjoblist();

        img_jobpostback.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.img_jobpostback:
                finish();
                break;

        }
    }
    public void initialize(){
        img_jobpostback=findViewById(R.id.img_jobpostback);
        rcy_jobposting=findViewById(R.id.rcy_jobposting);
    }

    public void getjoblist(){

        Jobpostingmodel data=new Jobpostingmodel();
        data.setNocadicdates("3");
        data.setOpening(".Net Developer");
        data.setHiringlead("Ankush Tomar");
        data.setCreatedon("12/12/2018");
        data.setStatus("Open");
        jobarraylist.add(data);

        Jobpostingmodel data1=new Jobpostingmodel();
        data1.setNocadicdates("5");
        data1.setOpening(".Net Developer(MVC)");
        data1.setHiringlead("Ankush Tomar");
        data1.setCreatedon("15/12/2018");
        data1.setStatus("Open");
        jobarraylist.add(data1);

        Jobpostingmodel data2=new Jobpostingmodel();
        data2.setNocadicdates("2");
        data2.setOpening("Android Developer");
        data2.setHiringlead("Aarti Sharma");
        data2.setCreatedon("12/12/2018");
        data2.setStatus("Close");
        jobarraylist.add(data2);

        Jobpostingmodel data3=new Jobpostingmodel();
        data3.setNocadicdates("7");
        data3.setOpening("UI Developer");
        data3.setHiringlead("Saloni Mittal");
        data3.setCreatedon("16/12/2018");
        data3.setStatus("Open");
        jobarraylist.add(data3);

        Jobpostingmodel data4=new Jobpostingmodel();
        data4.setNocadicdates("2");
        data4.setOpening("HR");
        data4.setHiringlead("Vikash Kumar");
        data4.setCreatedon("11/11/2018");
        data4.setStatus("Open");
        jobarraylist.add(data4);

        Jobpostingmodel data5=new Jobpostingmodel();
        data5.setNocadicdates("6");
        data5.setOpening("Graphic Designer");
        data5.setHiringlead("Mandvi Tiwari");
        data5.setCreatedon("09/12/2018");
        data5.setStatus("Close");
        jobarraylist.add(data5);


        JobPostingAdapter adapter = new JobPostingAdapter(JobpostingHomeActivity.this, jobarraylist);
        rcy_jobposting.setLayoutManager(new LinearLayoutManager(JobpostingHomeActivity.this, LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_jobposting.setItemAnimator(new DefaultItemAnimator());
        rcy_jobposting.setAdapter(adapter);
    }
}
