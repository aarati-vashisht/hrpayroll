package com.yoeki.kalpnay.hrporatal.EventAndTraining;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.Jobposting.JobPostingAdapter;
import com.yoeki.kalpnay.hrporatal.Jobposting.Jobpostingmodel;
import com.yoeki.kalpnay.hrporatal.Notification.EventDetails;
import com.yoeki.kalpnay.hrporatal.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_ITEM = 2;

    private List<EventModel> stringArrayList;
    private Activity activity;
    String strtemp;

    public EventAdapter(Activity activity, List<EventModel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_eventandtraining, parent, false);
        return new ItemViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_ettitle.setText(stringArrayList.get(position).getTitle());
        itemViewHolder.tv_etdescription.setText(stringArrayList.get(position).getDiscription());
        itemViewHolder.tv_etlocation.setText(stringArrayList.get(position).getLocation());
       // itemViewHolder.tv_etfromedate.setText(stringArrayList.get(position).getFromdate());
        itemViewHolder.tv_etvendor.setText(stringArrayList.get(position).getVendor());
       // itemViewHolder.tv_ettodate.setText(stringArrayList.get(position).getTodate());
        //itemViewHolder.tv_etfromtime.setText(stringArrayList.get(position).getFromtime());
        //itemViewHolder.tv_ettotime.setText(stringArrayList.get(position).getTotime());
        //itemViewHolder.tv_etduration.setText(stringArrayList.get(position).getDuration());

        itemViewHolder.ly_allrequestmanin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity, EventDetailsActivity.class);
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

        TextView tv_ettitle, tv_etdescription, tv_etlocation, tv_etfromedate,tv_etvendor,tv_ettodate
                ,tv_etfromtime,tv_ettotime,tv_etduration;
        CardView card_notification;
        LinearLayout ly_allrequestmanin;
        //  Button btn_apply;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tv_ettitle = itemView.findViewById(R.id.tv_ettitle);
            tv_etdescription = itemView.findViewById(R.id.tv_etdescription);
            tv_etlocation = itemView.findViewById(R.id.tv_etlocation);
            ly_allrequestmanin=itemView.findViewById(R.id.ly_allrequestmanin);
            //tv_etfromedate=itemView.findViewById(R.id.tv_etfromedate);
            tv_etvendor=itemView.findViewById(R.id.tv_etvendor);
            //tv_etfromtime=itemView.findViewById(R.id.tv_etfromtime);
            //tv_ettotime=itemView.findViewById(R.id.tv_ettotime);
            //tv_etduration=itemView.findViewById(R.id.tv_etduration);
           // tv_ettodate=itemView.findViewById(R.id.tv_ettodate);
        }
    }
}
