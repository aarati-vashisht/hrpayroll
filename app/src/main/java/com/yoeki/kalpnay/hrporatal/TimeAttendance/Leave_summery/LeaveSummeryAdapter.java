package com.yoeki.kalpnay.hrporatal.TimeAttendance.Leave_summery;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yoeki.kalpnay.hrporatal.R;
import java.util.List;


public class LeaveSummeryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 2;

    private List<LeaveSummeryModel> stringArrayList;
    private Activity activity;
    String strtemp;

    public LeaveSummeryAdapter(Activity activity, List<LeaveSummeryModel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_leavesummery, parent, false);
        return new ItemViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_lsdate.setText(stringArrayList.get(position).getDate());
        itemViewHolder.tv_lsfromdate.setText(stringArrayList.get(position).getFromdate());
        itemViewHolder.tv_lstodate.setText(stringArrayList.get(position).getTodate());
        itemViewHolder.tv_lsleavetype.setText(stringArrayList.get(position).getLeavetype());
        itemViewHolder.tv_lscount.setText(stringArrayList.get(position).getLeavecount());
        // itemViewHolder.tv_reason.setText(stringArrayList.get(position).getReason());
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

        TextView tv_lsdate, tv_lsfromdate, tv_lstodate, tv_lsleavetype,tv_lscount,btn_apply;
        CardView card_notification;
        LinearLayout ly_allrequestmanin;
        //  Button btn_apply;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //  tv_reason = itemView.findViewById(R.id.tv_reason);
            tv_lsdate = itemView.findViewById(R.id.tv_lsdate);
            tv_lsfromdate = itemView.findViewById(R.id.tv_lsfromdate);
            tv_lstodate = itemView.findViewById(R.id.tv_lstodate);
            tv_lsleavetype=itemView.findViewById(R.id.tv_lsleavetype);
            tv_lscount=itemView.findViewById(R.id.tv_lscount);
          //  btn_apply=itemView.findViewById(R.id.btn_apply);

        }
    }
}
