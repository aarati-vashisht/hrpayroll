package com.yoeki.kalpnay.hrporatal.Payroll;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yoeki.kalpnay.hrporatal.R;

import java.util.List;

public class AdvanceSalaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Advance_Salary_model> salleryList;
    private Activity activity;

    public AdvanceSalaryAdapter(Activity activity, List<Advance_Salary_model> strings) {
        this.activity = activity;
        this.salleryList = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating recycle view item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_advance_salary, parent, false);
        return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.textViewAmount.setText(salleryList.get(position).getAmount());
        itemViewHolder.textViewDate.setText(salleryList.get(position).getStartedOn());
        itemViewHolder.textViewPayBackAmount.setText(salleryList.get(position).getPayBackAmount());
        itemViewHolder.textViewLastPayBack.setText(salleryList.get(position).getLastPayBackDate());

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
        TextView textViewPayBackAmount, textViewAmount, textViewDate, textViewLastPayBack;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewPayBackAmount = itemView.findViewById(R.id.textViewPayBackAmount);
            textViewLastPayBack = itemView.findViewById(R.id.textViewLastPayBack);

        }
    }

}
