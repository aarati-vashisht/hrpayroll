package com.yoeki.kalpnay.hrporatal.Request;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.HomeMenu.EmployeeDetailActivity;
import com.yoeki.kalpnay.hrporatal.HomeMenu.SearchAdapter;
import com.yoeki.kalpnay.hrporatal.HomeMenu.SearchEmployeeModel;
import com.yoeki.kalpnay.hrporatal.R;

import java.lang.reflect.Array;
import java.util.List;

public class EmpgrievancelistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 2;
    private List<Employeegrievancelistmodel.ListGreveance> stringArrayList;
    private Activity activity;

    public EmpgrievancelistAdapter(Activity activity, List<Employeegrievancelistmodel.ListGreveance> strings) {
        this.activity = activity;
        this.stringArrayList = strings;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_emplistgrievance, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_empgrievtype.setText(stringArrayList.get(position).getGreveanceTypeId());

        final String[] dategrie=stringArrayList.get(position).getDateOfSubmission().split(" ");
        itemViewHolder.tv_empgrievdate.setText(dategrie[0]);

        if (stringArrayList.get(position).getStatus().equals("Draft"))
           {
            itemViewHolder.tv_empgrievstatus.setText("Save");
            }else {
            itemViewHolder.tv_empgrievstatus.setText(stringArrayList.get(position).getStatus());
            }

            itemViewHolder.crd_empgrievlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                if (stringArrayList.get(position).getStatus().equals("Draft"))  {

                    Intent intent=new Intent(activity,GreveanceActivity.class);

                    intent.putExtra("status",stringArrayList.get(position).getStatus());
                    intent.putExtra("createdBy",stringArrayList.get(position).getCreatedBy());
                    intent.putExtra("date",stringArrayList.get(position).getDate());
                    intent.putExtra("dateOfSubmission",dategrie[0]);
                    intent.putExtra("greveanceId",stringArrayList.get(position).getGreveanceId());
                    intent.putExtra("greveanceTypeId",stringArrayList.get(position).getGreveanceTypeId());
                    intent.putExtra("involvPerson",stringArrayList.get(position).getInvolvPerson());
                    intent.putExtra("managerName",stringArrayList.get(position).getManagerName());
                    intent.putExtra("proceduree",stringArrayList.get(position).getProceduree());
                    intent.putExtra("time",dategrie[1]);

                    activity.startActivity(intent);

                }
                }
            });
        }
     @Override
     public int getItemViewType(int position) {

        return TYPE_ITEM;
     }
     @Override
     public int getItemCount() {
        return stringArrayList.size();
     }

     private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_empgrievtype, tv_empgrievdate, tv_empgrievstatus;
        CardView crd_empgrievlist;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_empgrievtype = itemView.findViewById(R.id.tv_empgrievtype);
            tv_empgrievdate = itemView.findViewById(R.id.tv_empgrievdate);
            tv_empgrievstatus = itemView.findViewById(R.id.tv_empgrievstatus);
            crd_empgrievlist=itemView.findViewById(R.id.crd_empgrievlist);
        }
    }
}