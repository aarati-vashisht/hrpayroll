package com.yoeki.kalpnay.hrporatal.Request;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.Notification.EventAdapter;
import com.yoeki.kalpnay.hrporatal.Notification.EventDetails;
import com.yoeki.kalpnay.hrporatal.Notification.NotificationEventModel;
import com.yoeki.kalpnay.hrporatal.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PreshiftAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 2;

    private List<Shiftmodel> stringArrayList;
    private Activity activity;

    public PreshiftAdapter(Activity activity,List<Shiftmodel> strings) {
        this.activity = activity;
        this.stringArrayList = strings;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_newshiftheader, parent, false);
        return new ItemViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tv_date.setText(stringArrayList.get(position).getDatee());
        itemViewHolder.tv_currentshift.setText(stringArrayList.get(position).getCurrentshit());
        itemViewHolder.tv_changeshift.setText(stringArrayList.get(position).getChangeshift());
        itemViewHolder.tv_reason.setText(stringArrayList.get(position).getReason());
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
        TextView tv_reason,tv_changeshift,tv_currentshift,tv_date;
        CardView card_notification;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_reason=itemView.findViewById(R.id.tv_reason);
            tv_changeshift=itemView.findViewById(R.id.tv_changeshift);
            tv_currentshift=itemView.findViewById(R.id.tv_currentshift);
            tv_date=itemView.findViewById(R.id.tv_date);
        }
    }
}
