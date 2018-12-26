package com.yoeki.kalpnay.hrporatal.Request.Leave;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoeki.kalpnay.hrporatal.Jobposting.JobPostingAdapter;
import com.yoeki.kalpnay.hrporatal.Jobposting.JobpostingHomeActivity;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;

public class LeavepreRecordFragment extends Fragment implements View.OnClickListener{

    View view;
    RecyclerView ryc_leaveprerecord;
    ArrayList<LeaveModel>arrayleavelist;

    public static LeavepreRecordFragment newInstance() {

        LeavepreRecordFragment fragment = new LeavepreRecordFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_leaveprerecord, container, false);
        arrayleavelist=new ArrayList<>();

        initialize();

        bindleavedata();

        return view;
    }
    @Override
    public void onClick(View v) {

    }
    public void initialize(){
        ryc_leaveprerecord=view.findViewById(R.id.ryc_leaveprerecord);
    }

    public void bindleavedata(){

           LeaveModel data=new LeaveModel();
           data.setTypae("Casual");
           data.setLeavecount("2");
           data.setFromdate("12/12/2018");
           data.setTodate("16/12/2018");
           arrayleavelist.add(data);

           LeaveModel data1=new LeaveModel();
              data1.setTypae("Sick");
              data1.setLeavecount("5");
              data1.setFromdate("18/12/2018");
              data1.setTodate("20/12/2018");
              arrayleavelist.add(data1);

            LeaveModel data2=new LeaveModel();
            data2.setTypae("Casual");
            data2.setLeavecount("6");
            data2.setFromdate("18/11/2018");
            data2.setTodate("20/11/2018");
             arrayleavelist.add(data2);

        LeaveModel data3=new LeaveModel();
        data3.setTypae("Sick");
        data3.setLeavecount("5");
        data3.setFromdate("18/12/2018");
        data3.setTodate("20/12/2018");
        arrayleavelist.add(data3);

        LeaverecordAdapter adapter = new LeaverecordAdapter(getActivity(), arrayleavelist);
        ryc_leaveprerecord.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        ryc_leaveprerecord.setItemAnimator(new DefaultItemAnimator());
        ryc_leaveprerecord.setAdapter(adapter);
    }
}
