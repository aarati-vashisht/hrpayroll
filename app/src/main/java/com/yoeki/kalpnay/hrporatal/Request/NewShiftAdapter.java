package com.yoeki.kalpnay.hrporatal.Request;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import com.yoeki.kalpnay.hrporatal.HomeMenu.Menuitemmodel;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.setting.preferance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewShiftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    TextView tv_shiftchangetodep,tv_shiftchangecurrentshift,tv_shiftchangedate;
    EditText edt_shiftchangereason;
    private ArrayList<Shiftmodel> stringArrayList;
    private Activity activity;
    NewShiftFragment fragment;
    private int mYear, mMonth, mDay;
    public NewShiftAdapter(Activity activity, ArrayList<Shiftmodel> strings,NewShiftFragment fragment) {

        this.activity = activity;
        this.stringArrayList = strings;
        this.fragment=fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //Inflating recycle view item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_newshiftheader, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == TYPE_FOOTER) {
            //Inflating footer view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_newshiftfooter, parent, false);
            return new FooterViewHolder(itemView);
        } else return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
           // footerHolder.tv_shiftchangecurrentshift=
            // footerHolder.footerimage.setImageResource(R.drawable.plusicon_new);
           /* footerHolder.footerText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "You clicked at Footer View", Toast.LENGTH_SHORT).show();
                }
            });*/
        } else if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.tv_date.setText(stringArrayList.get(position).getDatee());
            itemViewHolder.tv_currentshift.setText(stringArrayList.get(position).getCurrentshit());
            itemViewHolder.tv_changeshift.setText(stringArrayList.get(position).getChangeshift());
            itemViewHolder.tv_reason.setText(stringArrayList.get(position).getReason());

           /* itemViewHolder.imageViewIcon.setImageBitmap(stringArrayList.get(position).getImageid());
            itemViewHolder.img_mainmenucross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    stringArrayList.remove(position);
                    // Toast.makeText(context, String.valueOf(listPosition), Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });*/
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == stringArrayList.size()) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size() + 1;
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {
        ImageView footerimage;
         Button  btn_shiftchangesubmit;
        public FooterViewHolder(View view) {
            super(view);

            btn_shiftchangesubmit=view.findViewById(R.id.btn_shiftchangesubmit);
            tv_shiftchangetodep=view.findViewById(R.id.tv_shiftchangetodep);
            tv_shiftchangecurrentshift=view.findViewById(R.id.tv_shiftchangecurrentshift);
            tv_shiftchangedate=view.findViewById(R.id.tv_shiftchangedate);
            edt_shiftchangereason=view.findViewById(R.id.edt_shiftchangereason);


            tv_shiftchangedate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shiftdate();
                }
            });

            btn_shiftchangesubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     String date=tv_shiftchangedate.getText().toString();
                     String current=tv_shiftchangecurrentshift.getText().toString();
                     String tochange=tv_shiftchangetodep.getText().toString();
                     String reason=edt_shiftchangereason.getText().toString();

                    fragment.addmore(date,current,tochange,reason);

                    notifyDataSetChanged();
                }
            });
            tv_shiftchangetodep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tochangedepartmentdialog();
                }
            });

            tv_shiftchangecurrentshift.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    fromchangedepartmentdialog();

                }
            });

            /*footerimage = (ImageView) view.findViewById(R.id.img_footer);

            footerimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(activity instanceof LeaveRequest){

                        ((LeaveRequest)activity).uploadattachmentdialog();

                    }else if (activity instanceof ClaimActivity){

                        ((ClaimActivity)activity).uploadattachmentdialog();

                    }

                }
            });*/
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_reason,tv_changeshift,tv_currentshift,tv_date;

        ImageView imageViewIcon, img_mainmenucross;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tv_reason=itemView.findViewById(R.id.tv_reason);
            tv_changeshift=itemView.findViewById(R.id.tv_changeshift);
            tv_currentshift=itemView.findViewById(R.id.tv_currentshift);
            tv_date=itemView.findViewById(R.id.tv_date);

        }
    }


    public void fromchangedepartmentdialog() {

        // final List<GetMasterInfo.ListShiftMaster> listshift= preferance.getInstance(activity).getshiftmaster("shiftmaster");

        final ArrayList<String>listshift=new ArrayList<>();
        listshift.add("8:00 AM");
        listshift.add("8:30 AM");
        listshift.add("9:00 AM");
        listshift.add("9:30 AM");
        listshift.add("10:00 AM");
        listshift.add("11:00 AM");
        listshift.add("2:00 PM");

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.tochangeshitdialog);

        ListView listsponser = dialog.findViewById(R.id.li_tochangelist);

        if (listshift.size()>0){

            final ShiftAdapter adapter = new ShiftAdapter(activity, listshift);
            listsponser.setAdapter(adapter);

        }

        listsponser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                tv_shiftchangecurrentshift.setText(listshift.get(i));
                dialog.dismiss();

            }
        });

        dialog.show();
    }



    public void tochangedepartmentdialog() {

       // final List<GetMasterInfo.ListShiftMaster> listshift= preferance.getInstance(activity).getshiftmaster("shiftmaster");

        final ArrayList<String>listshift=new ArrayList<>();
        listshift.add("8:00 AM");
        listshift.add("8:30 AM");
        listshift.add("9:00 AM");
        listshift.add("9:30 AM");
        listshift.add("10:00 AM");
        listshift.add("11:00 AM");
        listshift.add("2:00 PM");

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.tochangeshitdialog);

        ListView listsponser = dialog.findViewById(R.id.li_tochangelist);

        if (listshift.size()>0){

            final ShiftAdapter adapter = new ShiftAdapter(activity, listshift);
            listsponser.setAdapter(adapter);

        }

        listsponser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                tv_shiftchangetodep.setText(listshift.get(i));
                dialog.dismiss();

            }
        });

        dialog.show();
    }

    public void shiftdate() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        Calendar cc = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final String getCurrentDateTime = sdf.format(cc.getTime());

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        tv_shiftchangedate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);

                        String strtodate = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;

                        Date date2 = null;
                        Date date1 = null;
                        try {
                            date1 = sdf.parse(getCurrentDateTime);
                            date2 = sdf.parse(strtodate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date1.compareTo(date2) < 0) {
                            tv_shiftchangedate.setText(strtodate);
                        } else {
                            tv_shiftchangedate.setText(getCurrentDateTime);
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }



}

