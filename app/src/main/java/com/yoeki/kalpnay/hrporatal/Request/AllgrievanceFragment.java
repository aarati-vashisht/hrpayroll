package com.yoeki.kalpnay.hrporatal.Request;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import java.util.List;

public class AllgrievanceFragment extends Fragment {
    private RecyclerView ryc_circular;
    List<Allgrievancedatamodel.ListHRGreveance> arrayallgrievancelist;
    ApiInterface apiInterface;

    public static AllgrievanceFragment newInstance() {
        AllgrievanceFragment fragment = new AllgrievanceFragment();

        return fragment;
    }
}
