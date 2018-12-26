package com.yoeki.kalpnay.hrporatal.Jobposting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yoeki.kalpnay.hrporatal.HomeMenu.HomeActivity;
import com.yoeki.kalpnay.hrporatal.Login.LoginActivity;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.Shiftmodel;
import com.yoeki.kalpnay.hrporatal.Request.shiftchangemanager.AllrequestAdapter;
import com.yoeki.kalpnay.hrporatal.setting.preferance;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JobPostingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_ITEM = 2;

    private List<Jobpostingmodel> stringArrayList;
    private Activity activity;
    String strtemp;

    public JobPostingAdapter(Activity activity, List<Jobpostingmodel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_jobposting, parent, false);
        return new ItemViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_nocandidates.setText(stringArrayList.get(position).getNocadicdates());
        itemViewHolder.tv_jobopining.setText(stringArrayList.get(position).getOpening());
        itemViewHolder.tv_hirenglead.setText(stringArrayList.get(position).getHiringlead());
        itemViewHolder.tv_createdon.setText(stringArrayList.get(position).getCreatedon());
        itemViewHolder.tv_status.setText(stringArrayList.get(position).getStatus());

        itemViewHolder.btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!stringArrayList.get(position).getStatus().equals("Close")){

                    applyjob();

                }

            }
        });
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

        TextView tv_nocandidates, tv_jobopining, tv_hirenglead, tv_createdon,tv_status,btn_apply;
        CardView card_notification;
        LinearLayout ly_allrequestmanin;
      //  Button btn_apply;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //  tv_reason = itemView.findViewById(R.id.tv_reason);
            tv_nocandidates = itemView.findViewById(R.id.tv_nocandidates);
            tv_jobopining = itemView.findViewById(R.id.tv_jobopining);
            tv_hirenglead = itemView.findViewById(R.id.tv_hirenglead);
            tv_createdon=itemView.findViewById(R.id.tv_createdon);
            tv_status=itemView.findViewById(R.id.tv_status);
            btn_apply=itemView.findViewById(R.id.btn_apply);

        }
    }

    public  void applyjob(){
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be Apply!")
                .setConfirmText("Yes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();

                        Toast.makeText(activity, "Apply Successfully!", Toast.LENGTH_SHORT).show();

                    }
                })
                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })

                .show();

    }

}
