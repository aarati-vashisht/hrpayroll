package com.yoeki.kalpnay.hrporatal.Request.shiftchangemanager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.Plane.PlanformActivity;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.Shiftmodel;
import com.yoeki.kalpnay.hrporatal.setting.preferance;

import java.util.List;

public class AllrequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 2;

    private List<Shiftmodel> stringArrayList;
    private Activity activity;
    String strtemp;

    public AllrequestAdapter(Activity activity, List<Shiftmodel> strings,String strtemp) {
        this.activity = activity;
        this.stringArrayList = strings;
        this.strtemp=strtemp;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_allrequest, parent, false);
        return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_date.setText(stringArrayList.get(position).getDatee());
        itemViewHolder.tv_currentshift.setText(stringArrayList.get(position).getCurrentshit());
        itemViewHolder.tv_changeshift.setText(stringArrayList.get(position).getChangeshift());
        itemViewHolder.tv_name.setText(stringArrayList.get(position).getName());
        itemViewHolder.tv_status.setText(stringArrayList.get(position).getStatus());

        itemViewHolder.ly_allrequestmanin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strtemp.equals("1")){
                    accepteddialog();
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
        TextView tv_reason, tv_changeshift, tv_currentshift, tv_date,tv_status,tv_name;
        CardView card_notification;
        LinearLayout ly_allrequestmanin;

        public ItemViewHolder(View itemView) {
            super(itemView);
          //  tv_reason = itemView.findViewById(R.id.tv_reason);
            tv_changeshift = itemView.findViewById(R.id.tv_changeshift);
            tv_currentshift = itemView.findViewById(R.id.tv_currentshift);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_status=itemView.findViewById(R.id.tv_status);
            tv_name=itemView.findViewById(R.id.tv_name);
            ly_allrequestmanin=itemView.findViewById(R.id.ly_allrequestmanin);
        }
    }


    public void accepteddialog(){
        final RadioGroup radioGroup_locationtype;
        TextView tv_changerequstmsg,tv_empname,tv_empwhere,tv_emplocation,tv_emppurpose;
        CardView card_approved,card_changerequest;
        final Dialog dialog = new Dialog(activity);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_manageraccept);

       // LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        card_approved=dialog.findViewById(R.id.card_approved);
        card_changerequest=dialog.findViewById(R.id.card_changerequest);

        card_approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   approverequest(user_id,"A",empid);
                dialog.dismiss();

            }
        });

        card_changerequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });


        dialog.show();

    }

}
