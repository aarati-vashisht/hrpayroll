package com.yoeki.kalpnay.hrporatal.Request.Claim;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.Leave.LeaveModel;
import com.yoeki.kalpnay.hrporatal.Request.Leave.LeaverecordAdapter;

import java.util.List;

public class ClaimAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_ITEM = 2;

    private List<Claimlistmodel> stringArrayList;
    private Activity activity;
    String strtemp;

    public ClaimAdapter(Activity activity, List<Claimlistmodel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_claimrecord, parent, false);
        return new ItemViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_status.setText(stringArrayList.get(position).getStatus());
        itemViewHolder.tv_amount.setText(stringArrayList.get(position).getAmount());
        itemViewHolder.tv_recieptno.setText(stringArrayList.get(position).getRecieptno());
        itemViewHolder.tv_claimdate.setText(stringArrayList.get(position).getDate());
        itemViewHolder.tv_claimtype.setText(stringArrayList.get(position).getType());
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

        TextView tv_status, tv_amount, tv_recieptno, tv_claimdate,tv_claimtype,btn_apply;
        CardView card_notification;
        LinearLayout ly_allrequestmanin;
        //  Button btn_apply;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //  tv_reason = itemView.findViewById(R.id.tv_reason);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_recieptno = itemView.findViewById(R.id.tv_recieptno);
            tv_claimdate=itemView.findViewById(R.id.tv_claimdate);
            tv_claimtype=itemView.findViewById(R.id.tv_claimtype);
        }
    }
}


