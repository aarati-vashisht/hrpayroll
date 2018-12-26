package com.yoeki.kalpnay.hrporatal.Interview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.Notification.EventAdapter;
import com.yoeki.kalpnay.hrporatal.Notification.EventDetails;
import com.yoeki.kalpnay.hrporatal.Notification.NotificationEventModel;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.List;

public class InterviewhomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 2;

    private List<INterViewHomeModel> stringArrayList;
    private Activity activity;

    public InterviewhomeAdapter(Activity activity,List<INterViewHomeModel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_interviewhome, parent, false);
        return new ItemViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_candidatename.setText(stringArrayList.get(position).getName());
        itemViewHolder.tv_candidatedesignation.setText(stringArrayList.get(position).getDesignation());
        itemViewHolder.tv_candidatedate.setText(stringArrayList.get(position).getDate());

        itemViewHolder.card_interviewhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity,InterviewScheduleActivity.class);
                intent.putExtra("name",stringArrayList.get(position).getName());
                intent.putExtra("deg",stringArrayList.get(position).getDesignation());
                activity.startActivity(intent);

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

        TextView tv_candidatename, tv_candidatedesignation, tv_candidatedate;
        CardView card_interviewhome;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tv_candidatename = itemView.findViewById(R.id.tv_candidatename);
            tv_candidatedesignation = itemView.findViewById(R.id.tv_candidatedesignation);
            tv_candidatedate = itemView.findViewById(R.id.tv_candidatedate);
            card_interviewhome=itemView.findViewById(R.id.card_interviewhome);

        }
    }
}
