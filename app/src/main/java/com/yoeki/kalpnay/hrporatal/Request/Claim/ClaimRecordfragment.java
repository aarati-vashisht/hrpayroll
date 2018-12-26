package com.yoeki.kalpnay.hrporatal.Request.Claim;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yoeki.kalpnay.hrporatal.R;
import java.util.ArrayList;

public class ClaimRecordfragment  extends Fragment implements View.OnClickListener{

    View view;
    RecyclerView ryc_claimprerecord;
    ArrayList<Claimlistmodel> arrayleavelist;

    public static ClaimRecordfragment newInstance() {

        ClaimRecordfragment fragment = new ClaimRecordfragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recordclaim, container, false);
        arrayleavelist=new ArrayList<>();

        initialize();

        bindleavedata();

        return view;
    }
    @Override
    public void onClick(View v) {

    }
    public void initialize(){
        ryc_claimprerecord=view.findViewById(R.id.ryc_claimprerecord);
    }

    public void bindleavedata(){

        Claimlistmodel data=new Claimlistmodel();
        data.setType("Hotel");
        data.setDate("24/12/2018");
        data.setRecieptno("156569594255");
        data.setAmount("10000");
        data.setStatus("pending");
        arrayleavelist.add(data);

        Claimlistmodel data1=new Claimlistmodel();
        data1.setType("Travel");
        data1.setDate("20/12/2018");
        data1.setRecieptno("156569594255");
        data1.setAmount("10000");
        data1.setStatus("Acepted");
        arrayleavelist.add(data1);

        Claimlistmodel data2=new Claimlistmodel();
        data2.setType("Hotel");
        data2.setDate("24/12/2018");
        data2.setRecieptno("156569594255");
        data2.setAmount("10000");
        data2.setStatus("pending");
        arrayleavelist.add(data2);

        Claimlistmodel data3=new Claimlistmodel();
        data3.setType("Travel");
        data3.setDate("10/12/2018");
        data3.setRecieptno("156564545455");
        data3.setAmount("10000");
        data3.setStatus("Acepted");
        arrayleavelist.add(data3);

        ClaimAdapter adapter = new ClaimAdapter(getActivity(), arrayleavelist);
        ryc_claimprerecord.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        ryc_claimprerecord.setItemAnimator(new DefaultItemAnimator());
        ryc_claimprerecord.setAdapter(adapter);
    }
}
