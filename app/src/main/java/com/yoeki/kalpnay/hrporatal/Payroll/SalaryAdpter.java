package com.yoeki.kalpnay.hrporatal.Payroll;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;

import java.util.ArrayList;

public class SalaryAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 2;

    private ArrayList<SalleryModel> salleryList;
    private Activity activity;

    public SalaryAdpter(Activity activity, ArrayList<SalleryModel> strings) {
        this.activity = activity;
        this.salleryList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.payrollhome_adapter, parent, false);
        return new ItemViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.textViewMonth.setText(salleryList.get(position).getMonthname());
        itemViewHolder.textViewNetPayable.setText(salleryList.get(position).getSalaryamount());

        itemViewHolder.salay_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(activity,PayrollHomeActivity.class);
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
        return salleryList.size() ;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMonth,textViewNetPayable;
        CardView salay_card;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewMonth = itemView.findViewById(R.id.textViewMonth);
            textViewNetPayable = itemView.findViewById(R.id.textViewNetPayable);
            salay_card = itemView.findViewById(R.id.salay_card);

        }
    }

}
