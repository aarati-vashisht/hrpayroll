package com.yoeki.kalpnay.hrporatal.Request.Leave;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yoeki.kalpnay.hrporatal.Jobposting.JobPostingAdapter;
import com.yoeki.kalpnay.hrporatal.Jobposting.Jobpostingmodel;
import com.yoeki.kalpnay.hrporatal.R;
import java.util.List;

public class LeaverecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_ITEM = 2;

    private List<LeaveModel> stringArrayList;
    private Activity activity;
    String strtemp;

    public LeaverecordAdapter(Activity activity, List<LeaveModel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_leaverecord, parent, false);
        return new ItemViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_leavetype.setText(stringArrayList.get(position).getTypae());
        itemViewHolder.tv_leaveblance.setText(stringArrayList.get(position).getLeavecount());
        itemViewHolder.tv_fromdate.setText(stringArrayList.get(position).getFromdate());
        itemViewHolder.tv_todate.setText(stringArrayList.get(position).getTodate());
        //itemViewHolder.tv_status.setText(stringArrayList.get(position).getStatus());

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

        TextView tv_leavetype, tv_leaveblance, tv_fromdate, tv_todate,tv_status,btn_apply;
        CardView card_notification;
        LinearLayout ly_allrequestmanin;
        //  Button btn_apply;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //  tv_reason = itemView.findViewById(R.id.tv_reason);
            tv_leavetype = itemView.findViewById(R.id.tv_leavetype);
            tv_leaveblance = itemView.findViewById(R.id.tv_leaveblance);
            tv_fromdate = itemView.findViewById(R.id.tv_fromdate);
            tv_todate=itemView.findViewById(R.id.tv_todate);
        }
    }
}

