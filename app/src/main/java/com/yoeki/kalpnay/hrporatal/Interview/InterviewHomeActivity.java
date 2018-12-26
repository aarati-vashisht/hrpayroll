package com.yoeki.kalpnay.hrporatal.Interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.yoeki.kalpnay.hrporatal.Notification.EventAdapter;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;

public class InterviewHomeActivity extends AppCompatActivity implements View.OnClickListener {

     ImageView img_backinterviewhome;
     ArrayList<INterViewHomeModel>arraycandidate;
     RecyclerView ryc_candidatelist;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_interview_home);

         initialize();
         setarraylist();

         img_backinterviewhome.setOnClickListener(this);
     }

     @Override
     public void onClick(View v) {
         switch (v.getId()){
             case R.id.img_backinterviewhome:
                 finish();
                 break;
         }
     }

     public  void initialize(){

         img_backinterviewhome=findViewById(R.id.img_backinterviewhome);
         ryc_candidatelist=findViewById(R.id.ryc_candidatelist);

     }

     public void setarraylist(){

         arraycandidate=new ArrayList<>();
         INterViewHomeModel data=new INterViewHomeModel();
         data.setName("Mohit Kumar");
         data.setDesignation("Android Developer");
         data.setDate("16-12-2018");
         arraycandidate.add(data);

         INterViewHomeModel data2=new INterViewHomeModel();
         data2.setName("Amit Kumar");
         data2.setDesignation("DotNet");
         data2.setDate("16-12-2018");
         arraycandidate.add(data2);

         INterViewHomeModel data3=new INterViewHomeModel();
         data3.setName("AArti Sharma");
         data3.setDesignation("Android Developer");
         data3.setDate("18-12-2018");
         arraycandidate.add(data3);

         INterViewHomeModel data4=new INterViewHomeModel();
         data4.setName("Saloni Mittal");
         data4.setDesignation("UI Developer");
         data4.setDate("20-12-2018");
         arraycandidate.add(data4);

         INterViewHomeModel data5=new INterViewHomeModel();
         data5.setName("Abhishek");
         data5.setDesignation("UI Developer");
         data5.setDate("22-12-2018");
         arraycandidate.add(data5);

         INterViewHomeModel data6=new INterViewHomeModel();
         data6.setName("Fateh Singh Rana");
         data6.setDesignation("Dot Net");
         data6.setDate("25-12-2018");
         arraycandidate.add(data6);

         INterViewHomeModel data7=new INterViewHomeModel();
         data7.setName("Himanshu");
         data7.setDesignation("Android Developer");
         data7.setDate("23-12-2018");
         arraycandidate.add(data7);

         INterViewHomeModel data8=new INterViewHomeModel();
         data8.setName("Mandvi Tiwari");
         data8.setDesignation("UI Developer");
         data8.setDate("30-12-2018");
         arraycandidate.add(data8);

         INterViewHomeModel data9=new INterViewHomeModel();
         data9.setName("Archna Singh");
         data9.setDesignation("Dot NEt");
         data9.setDate("27-12-2018");
         arraycandidate.add(data9);
         ryc_candidatelist.setLayoutManager(new LinearLayoutManager(InterviewHomeActivity.this, LinearLayoutManager.VERTICAL, false));
         // rec_leavereqattachment.setLayoutManager(new Hori);
         ryc_candidatelist.setItemAnimator(new DefaultItemAnimator());

         InterviewhomeAdapter adapter=new InterviewhomeAdapter(InterviewHomeActivity.this,arraycandidate);
         ryc_candidatelist.setAdapter(adapter);

     }
 }
