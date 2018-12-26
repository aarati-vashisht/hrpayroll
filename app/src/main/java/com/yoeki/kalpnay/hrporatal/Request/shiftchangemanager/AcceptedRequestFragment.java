package com.yoeki.kalpnay.hrporatal.Request.shiftchangemanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.PreShiftFragment;
import com.yoeki.kalpnay.hrporatal.Request.PreshiftAdapter;
import com.yoeki.kalpnay.hrporatal.Request.Shiftmodel;

import java.util.ArrayList;

public class AcceptedRequestFragment  extends Fragment {

    RecyclerView rcy_acceptedshift;
    ArrayList<Shiftmodel> arrayreqattachlist;

    public static AcceptedRequestFragment newInstance() {

        AcceptedRequestFragment fragment = new AcceptedRequestFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_accepteshift, container, false);

        arrayreqattachlist=new ArrayList<>();
        rcy_acceptedshift=view.findViewById(R.id.rcy_acceptedshift);

        addmore();
        return view;
    }

    public void addmore() {

        Shiftmodel data = new Shiftmodel();
        data.setDatee("16/12/2018");
        data.setCurrentshit("8:00 AM");
        data.setChangeshift("9:00 AM");
        data.setStatus("Accepted");
        data.setName("Mohit Kumar");
        arrayreqattachlist.add(data);

        Shiftmodel data2 = new Shiftmodel();
        data2.setDatee("16/12/2018");
        data2.setCurrentshit("10:00 AM");
        data2.setChangeshift("6:00 PM");
        data2.setStatus("Accepted");
        data2.setName("Aarti Sharma");
        arrayreqattachlist.add(data2);

        Shiftmodel data3 = new Shiftmodel();
        data3.setDatee("17/12/2018");
        data3.setCurrentshit("8:00 AM");
        data3.setChangeshift("5:00 PM");
        data3.setStatus("Accepted");
        data3.setName("Himanshu");
        arrayreqattachlist.add(data3);

        Shiftmodel data4 = new Shiftmodel();
        data4.setDatee("17/12/2018");
        data4.setCurrentshit("6:00 AM");
        data4.setChangeshift("2:00 PM");
        data4.setName("Mandvi Tiwari");
        data4.setStatus("Accepted");
        arrayreqattachlist.add(data4);

        Shiftmodel data5 = new Shiftmodel();
        data5.setDatee("18/12/2018");
        data5.setCurrentshit("6:00 AM");
        data5.setChangeshift("2:00 PM");
        data5.setName("Amarjeet Singh");
        data5.setStatus("Accepted");
        arrayreqattachlist.add(data5);

        AllrequestAdapter adapter = new AllrequestAdapter(getActivity(), arrayreqattachlist,"2");
        rcy_acceptedshift.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_acceptedshift.setItemAnimator(new DefaultItemAnimator());
        rcy_acceptedshift.setAdapter(adapter);

    }
    }