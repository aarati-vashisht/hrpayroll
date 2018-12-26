package com.yoeki.kalpnay.hrporatal.Payroll;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;

import java.util.List;

public class PayStuctureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Paystructuremodel> salleryList;
    private Activity activity;

    public PayStuctureAdapter(Activity activity, List<Paystructuremodel> strings) {
        this.activity = activity;
        this.salleryList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_paystucture, parent, false);
        return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.textViewAmount.setText(salleryList.get(position).getAmount());
        itemViewHolder.textViewDate.setText(salleryList.get(position).getDate());
        itemViewHolder.textViewPayElement.setText(salleryList.get(position).getPayElement());
        itemViewHolder.textViewPeriod.setText(salleryList.get(position).getPeriod());

    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getItemCount() {
        return salleryList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPeriod, textViewAmount, textViewPayElement, textViewDate;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            textViewPeriod = itemView.findViewById(R.id.textViewPeriod);
            textViewPayElement = itemView.findViewById(R.id.textViewPayElement);
            textViewDate = itemView.findViewById(R.id.textViewDate);

        }
    }

}
