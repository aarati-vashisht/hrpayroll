package com.yoeki.kalpnay.hrporatal.EventAndTraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.yoeki.kalpnay.hrporatal.R;
import java.util.ArrayList;

public class EventTrainingHome extends AppCompatActivity implements View.OnClickListener{

    RecyclerView rcy_eventandtraining;
    ImageView img_eventtraingback;
    ArrayList<EventModel>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_training_home);
        arrayList=new ArrayList<>();

        initialize();

        adddata();
        img_eventtraingback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_eventtraingback:
                finish();
                break;
        }
    }

    public void initialize(){
        rcy_eventandtraining=findViewById(R.id.rcy_eventandtraining);
        img_eventtraingback=findViewById(R.id.img_eventtraingback);
    }

    public void adddata(){
        EventModel data=new EventModel();
        data.setTitle("Holi Event");
        data.setDiscription("Dipawali event  ");
        data.setLocation("Noida");
        data.setVendor("Genger Hotel");
        data.setFromdate("04/04/2019");
        data.setTodate("06/04/2019");
        data.setFromtime("10:00 AM");
        data.setTotime("4:00 PM");
        data.setDuration("6 hrs");
        arrayList.add(data);

        EventModel data1=new EventModel();
        data1.setTitle("Dot Net Training");
        data1.setDiscription("Dot net training .");
        data1.setLocation("Noida");
        data1.setVendor("AMY Softtech");
        data1.setFromdate("04/04/2019");
        data1.setTodate("06/04/2019");
        data1.setFromtime("10:00 AM");
        data1.setTotime("4:00 PM");
        data1.setDuration("6 hrs");
        arrayList.add(data1);

        EventModel data2=new EventModel();
        data2.setTitle("Holi Event");
        data2.setDiscription("Dipawali event  ");
        data2.setLocation("Noida");
        data2.setVendor("Genger Hotel");
        data2.setFromdate("04/04/2019");
        data2.setTodate("06/04/2019");
        data2.setFromtime("10:00 AM");
        data2.setTotime("4:00 PM");
        data2.setDuration("6 hrs");
        arrayList.add(data2);

        EventModel data3=new EventModel();
        data3.setTitle("Dot Net Training");
        data3.setDiscription("Dot net training .");
        data3.setLocation("Noida");
        data3.setVendor("AMY Softtech");
        data3.setFromdate("04/04/2019");
        data3.setTodate("06/04/2019");
        data3.setFromtime("10:00 AM");
        data3.setTotime("4:00 PM");
        data3.setDuration("6 hrs");
        arrayList.add(data3);

        EventAdapter adapter = new EventAdapter(EventTrainingHome.this, arrayList);
        rcy_eventandtraining.setLayoutManager(new LinearLayoutManager(EventTrainingHome.this, LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_eventandtraining.setItemAnimator(new DefaultItemAnimator());
        rcy_eventandtraining.setAdapter(adapter);

    }
}
