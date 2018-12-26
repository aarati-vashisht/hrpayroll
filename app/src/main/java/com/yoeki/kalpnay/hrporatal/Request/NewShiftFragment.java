package com.yoeki.kalpnay.hrporatal.Request;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoeki.kalpnay.hrporatal.Notification.EventFragment;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;

public class NewShiftFragment extends Fragment {

    ArrayList<Shiftmodel> arrayreqattachlist;
    RecyclerView rcy_shiftnew;
    private NewShiftAdapter adapter;

    public static NewShiftFragment newInstance() {
        NewShiftFragment fragment = new NewShiftFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_newshift, container, false);
        arrayreqattachlist=new ArrayList<>();

        rcy_shiftnew=view.findViewById(R.id.rcy_shiftnew);
          uploaddata();

        return view;
    }

    public void uploaddata(){

           /* Shiftmodel data=new Shiftmodel();
            data.setDatee(date);
            data.setCurrentshit(current);
            data.setChangeshift(tochange);
            data.setReason(reason);*/
           // arrayreqattachlist.add(data);
         adapter=new NewShiftAdapter(getActivity(),arrayreqattachlist,NewShiftFragment.this);
        rcy_shiftnew.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_shiftnew.setItemAnimator(new DefaultItemAnimator());
        rcy_shiftnew.setAdapter(adapter);
    }

    public void addmore(String date,String current,String tochange,String reason){

        Shiftmodel data=new Shiftmodel();
        data.setDatee(date);
        data.setCurrentshit(current);
        data.setChangeshift(tochange);
        data.setReason(reason);
        arrayreqattachlist.add(data);

        adapter.notifyDataSetChanged();
    }
}
