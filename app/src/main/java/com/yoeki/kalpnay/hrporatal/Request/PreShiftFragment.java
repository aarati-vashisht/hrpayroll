package com.yoeki.kalpnay.hrporatal.Request;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD

import com.yoeki.kalpnay.hrporatal.Notification.EventFragment;
import com.yoeki.kalpnay.hrporatal.R;

=======
import com.yoeki.kalpnay.hrporatal.R;
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
import java.util.ArrayList;

public class PreShiftFragment extends Fragment {

    RecyclerView rcy_preshift;
    ArrayList<Shiftmodel> arrayreqattachlist;

    public static PreShiftFragment newInstance() {
<<<<<<< HEAD
=======

>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
        PreShiftFragment fragment = new PreShiftFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_priviousshift, container, false);

        arrayreqattachlist=new ArrayList<>();
        rcy_preshift=view.findViewById(R.id.rcy_preshift);

        addmore();

        return view;
    }

    public void addmore(){

        Shiftmodel data=new Shiftmodel();
        data.setDatee("16/12/2018");
        data.setCurrentshit("8:00 AM");
        data.setChangeshift("9:00 AM");
<<<<<<< HEAD
        data.setReason("Timimg");
=======
        data.setReason("Accepted");
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
        arrayreqattachlist.add(data);

        Shiftmodel data2=new Shiftmodel();
        data2.setDatee("16/12/2018");
        data2.setCurrentshit("10:00 AM");
        data2.setChangeshift("6:00 PM");
<<<<<<< HEAD
        data2.setReason("Timimg");
=======
        data2.setReason("Accepted");
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
        arrayreqattachlist.add(data2);

        Shiftmodel data3=new Shiftmodel();
        data3.setDatee("17/12/2018");
        data3.setCurrentshit("8:00 AM");
        data3.setChangeshift("5:00 PM");
<<<<<<< HEAD
        data3.setReason("Timimg");
=======
        data3.setReason("Pendding");
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
        arrayreqattachlist.add(data3);

        Shiftmodel data4=new Shiftmodel();
        data4.setDatee("17/12/2018");
        data4.setCurrentshit("6:00 AM");
        data4.setChangeshift("2:00 PM");
<<<<<<< HEAD
        data4.setReason("Timimg");
=======
        data4.setReason("Accepted");
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
        arrayreqattachlist.add(data4);

        Shiftmodel data5=new Shiftmodel();
        data5.setDatee("18/12/2018");
        data5.setCurrentshit("6:00 AM");
        data5.setChangeshift("2:00 PM");
<<<<<<< HEAD
        data5.setReason("Timimg");
=======
        data5.setReason("Rejected");
>>>>>>> 97810a8fed45ceb07d3fceb585c36b7874331e05
        arrayreqattachlist.add(data5);

        PreshiftAdapter   adapter=new PreshiftAdapter(getActivity(),arrayreqattachlist);
        rcy_preshift.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_preshift.setItemAnimator(new DefaultItemAnimator());
        rcy_preshift.setAdapter(adapter);

    }
}
