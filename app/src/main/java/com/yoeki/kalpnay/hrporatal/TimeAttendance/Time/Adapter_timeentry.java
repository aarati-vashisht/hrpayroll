package com.yoeki.kalpnay.hrporatal.TimeAttendance.Time;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.Request.NewShiftFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Adapter_timeentry  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    EditText Stat_fromdate,from_time_edittext,to_time_edittext,wrked_time,wrked_asigned,time_desc;
    EditText edt_shiftchangereason;
    Button btn_timeentryadd;
    private ArrayList<TimeentryModel> stringArrayList;
    private Activity activity;
    NewShiftFragment fragment;
    String Com_fromTime, Com_toTime,strtimestart,strtimeends;
    int mHour, mMinute, whichtime=0, mYear, mMonth, mDay;
    int days;

    public Adapter_timeentry(Activity activity, ArrayList<TimeentryModel> strings) {

        this.activity = activity;
        this.stringArrayList = strings;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //Inflating recycle view item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_timeentryheader, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == TYPE_FOOTER) {
            //Inflating footer view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_timeentryfooter, parent, false);
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

        } else if (holder instanceof ItemViewHolder){

            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            itemViewHolder.tv_date.setText(stringArrayList.get(position).getDate());
            itemViewHolder.tv_tefrometime.setText(stringArrayList.get(position).getFromtime());
            itemViewHolder.tv_tmtotime.setText(stringArrayList.get(position).getTotime());
            itemViewHolder.tv_tmnoofhours.setText(stringArrayList.get(position).getTotalhours());
             itemViewHolder.tv_tmasignedby.setText(stringArrayList.get(position).getAsigndby());
            itemViewHolder.tv_tmtaskdiscr.setText(stringArrayList.get(position).getTskdescription());

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
        Button btn_shiftchangesubmit;
        public FooterViewHolder(View view) {
            super(view);

            Stat_fromdate=view.findViewById(R.id.Stat_fromdate);
            from_time_edittext=view.findViewById(R.id.from_time_edittext);
            to_time_edittext=view.findViewById(R.id.to_time_edittext);
            wrked_time=view.findViewById(R.id.wrked_time);
            wrked_asigned=view.findViewById(R.id.wrked_asigned);
            time_desc=view.findViewById(R.id.time_desc);
            btn_timeentryadd=view.findViewById(R.id.btn_timeentryadd);

            Button HolidayFrom_date=view.findViewById(R.id.HolidayFrom_date);

            Button time_from=view.findViewById(R.id.time_from);
            Button time_to=view.findViewById(R.id.time_to);

            HolidayFrom_date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    datePicker();

                }
            });


            time_from.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tiemPicker();
                }
            });

            time_to.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tiemPicker();
                    whichtime =1;
                }
            });

            btn_timeentryadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String date=Stat_fromdate.getText().toString();
                    String from_time=from_time_edittext.getText().toString();
                    String to_time=to_time_edittext.getText().toString();
                    String wrkedtime=wrked_time.getText().toString();
                    String wrkedasigned=wrked_asigned.getText().toString();
                    String timedesc=time_desc.getText().toString();

                    ((TimeEntry)activity).addmore(date,from_time,to_time,wrkedtime,wrkedasigned,timedesc);

                    notifyDataSetChanged();
                }
            });


        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tefrometime,tv_tmtotime,tv_tmnoofhours,tv_date,tv_tmasignedby,tv_tmtaskdiscr;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tv_tefrometime=itemView.findViewById(R.id.tv_tefrometime);
            tv_tmtotime=itemView.findViewById(R.id.tv_tmtotime);
            tv_tmnoofhours=itemView.findViewById(R.id.tv_tmnoofhours);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_tmasignedby=itemView.findViewById(R.id.tv_tmasignedby);
            tv_tmtaskdiscr=itemView.findViewById(R.id.tv_tmtaskdiscr);

        }
    }
    private void datePicker(){
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date_time = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
                        //*************Call Time Picker Here ********************
                        Stat_fromdate.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    private void tiemPicker(){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mHour = hourOfDay;
                        mMinute = minute;

                        if (whichtime == 1) {
                            to_time_edittext.setText(String.format("%02d:%02d", hourOfDay, minute));
                            try {
                                SimpleDateFormat format = new SimpleDateFormat("hh:mm");
                                Date date1 = null, date2 = null;
                                try {
                                    date1 = format.parse(to_time_edittext.getText().toString());
                                    date2 = format.parse(from_time_edittext.getText().toString());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                long mills = date1.getTime() - date2.getTime();
                                int hours = (int) (mills / (1000 * 60 * 60));
                                int mins = (int) ((mills / (1000 * 60)) % 60);

                               // int time=Integer.parseInt(String.format("%02d:%02d", hours, mins));
                                if (hours>=0&&mins>=0){
                                    wrked_time.setText(String.format("%02d:%02d", hours, mins));
                                }else {
                                    timewraning();
                                }


                                String strtime=String.format("%02d:%02d", hours, mins);

                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                                date1 = simpleDateFormat.parse(strtime);
                                date2 = simpleDateFormat.parse("04:00 PM");

                                long difference = date2.getTime() - date1.getTime();
                                days = (int) (difference / (1000*60*60*24));
                                hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
                                // min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
                                hours = (hours < 0 ? -hours : hours);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            whichtime=0;
                        }else{
                            Com_fromTime = hourOfDay + ":" + minute;
                            from_time_edittext.setText(String.format("%02d:%02d", hourOfDay, minute));
                            try {
                                SimpleDateFormat format = new SimpleDateFormat("hh:mm");
                                Date date1 = null, date2 = null;
                                try {
                                    date1 = format.parse(to_time_edittext.getText().toString());
                                    date2 = format.parse(from_time_edittext.getText().toString());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                long mills = date1.getTime() - date2.getTime();
                                int hours = (int) (mills / (1000 * 60 * 60));
                                int mins = (int) ((mills / (1000 * 60)) % 60);
                                // Toast.makeText(TimeEntry.this, String.format("%02d:%02d", hours, mins), Toast.LENGTH_SHORT).show();
                                // int time=Integer.parseInt(String.format("%02d:%02d", hours, mins));
                               if (hours>=0&&mins>=0){
                                   wrked_time.setText(String.format("%02d:%02d", hours, mins));

                               }else{
                                   timewraning();
                               }

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            whichtime=0;
                        }
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

    public  void timewraning(){
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Opps!")
                .setContentText("You Select Wrong Time")
                .setConfirmText("Ok")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();

                    //    Toast.makeText(activity, "Apply Successfully!", Toast.LENGTH_SHORT).show();

                    }
                })
                .show();

    }
}

