package com.yoeki.kalpnay.hrporatal.all_employee;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.HomeMenu.EmployeeDetailActivity;
import com.yoeki.kalpnay.hrporatal.Payroll.Paystructuremodel;
import com.yoeki.kalpnay.hrporatal.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class AllEmployeeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AllEmployee_Model> allEmployeeList;
    private Activity activity;

    public AllEmployeeAdapter(Activity activity, List<AllEmployee_Model> allEmployeeList) {
        this.activity = activity;
        this.allEmployeeList = allEmployeeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_allemployee, parent, false);
        return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.textViewDesignation.setText(allEmployeeList.get(position).getDesignation());
        itemViewHolder.textViewNAme.setText(allEmployeeList.get(position).getName());
        itemViewHolder.linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, AllEmployeeDetailActivity.class);
                intent.putExtra("DETAIL",  allEmployeeList.get(position).getName());
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getItemCount() {
        return allEmployeeList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDesignation, textViewNAme;
        LinearLayout linearLayoutContainer;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewNAme = itemView.findViewById(R.id.textViewNAme);
            textViewDesignation = itemView.findViewById(R.id.textViewDesignation);
            linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);


        }
    }

}
