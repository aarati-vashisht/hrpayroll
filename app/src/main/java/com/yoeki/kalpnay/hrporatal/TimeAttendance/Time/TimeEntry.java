package com.yoeki.kalpnay.hrporatal.TimeAttendance.Time;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.yoeki.kalpnay.hrporatal.Login.Api;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.TimeAttendance.Model.TimeAttendance_Info.TimeAttendance_Recieve;
import com.yoeki.kalpnay.hrporatal.TimeAttendance.Model.TimeAttendance_Info.TimeEntryData;
import com.yoeki.kalpnay.hrporatal.setting.Edittextclass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeEntry extends AppCompatActivity {

    private  static final String TAG = "CalendarActivity";
    AppCompatButton timeEnter_home,time_from,time_to,HolidayFrom_date,time_entrySubmit;
    Edittextclass from_time_edittext,to_time_edittext,Stat_fromdate,wrked_time,time_desc;
    private int mHour, mMinute, whichtime=0, mYear, mMonth, mDay;
    String Com_fromTime, Com_toTime,strtimestart,strtimeends;
    SwitchCompat switchCompatEntries;
    ApiInterface apiInterface;
    RecyclerView rcy_timentry;
    ArrayList<TimeentryModel>arraytimeentrylist;
    int days;
    Adapter_timeentry adapter;
    ImageView img_timeentryback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_entry);

        arraytimeentrylist=new ArrayList<>();

           // timeEnter_home = (AppCompatButton)findViewById(R.id.timeEnter_home);
          // HolidayFrom_date = (AppCompatButton)findViewById(R.id.HolidayFrom_date);
         // time_entrySubmit = (AppCompatButton)findViewById(R.id.time_entrySubmit);
        //switchCompatEntries=(SwitchCompat)findViewById(R.id.ShowEntries);

        img_timeentryback=findViewById(R.id.img_timeentryback);

        img_timeentryback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rcy_timentry=findViewById(R.id.rcy_timentry);

        uploaddata();

      /*  HolidayFrom_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });*/

       /* timeEnter_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),TimeAttendance_Menu.class);
                startActivity(intent);
                finish();
            }
        });*/

       /* switchCompatEntries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String stat = String.valueOf(isChecked);
                if(stat.equals("true")){
                    Intent intent0=new Intent(getApplicationContext(),TimeEntry_Week.class);
//                    Intent intent0=new Intent(getApplicationContext(),Requests.class);
                    startActivity(intent0);
                    finish();
                }else{
                    switchCompatEntries.setChecked(false);
                }
            }

        });*/

       /* time_entrySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serverCode();
            }
        });*/
    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),TimeAttendance_Menu.class);
        startActivity(intent);
        finish();
    }*/

    private void tiemPicker(){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
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
                                wrked_time.setText(String.format("%02d:%02d", hours, mins));

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

                                wrked_time.setText(String.format("%02d:%02d", hours, mins));
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            whichtime=0;
                        }
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

    private void datePicker(){
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
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

    public void serverCode(){
        String date = Stat_fromdate.getText().toString();
        String fromTime = from_time_edittext.getText().toString();
        String toTime = to_time_edittext.getText().toString();
        String description = time_desc.getText().toString();
        String workingHour = wrked_time.getText().toString();
        String id = "01";

        apiInterface = Api.getClient().create(ApiInterface.class);

        TimeEntryData time_userDetails = new TimeEntryData(date,fromTime,toTime,description,workingHour,id);
        Call<TimeAttendance_Recieve> call2 = apiInterface.date_Time(time_userDetails);

        call2.enqueue(new Callback<TimeAttendance_Recieve>() {
            @Override
            public void onResponse(Call<TimeAttendance_Recieve> call, Response<TimeAttendance_Recieve> response) {
                TimeAttendance_Recieve timeAttendance_recieve = response.body();
                try {
                    String status = timeAttendance_recieve.status;
                    String mess = timeAttendance_recieve.message;

                    Stat_fromdate.setText("");
                    from_time_edittext.setText("");
                    to_time_edittext.setText("");
                    time_desc.setText("");
                    wrked_time.setText("");
                    Toast.makeText(TimeEntry.this, mess, Toast.LENGTH_SHORT).show();
                }catch(Exception e){

                    e.printStackTrace();

                }
            }
            @Override
            public void onFailure(Call<TimeAttendance_Recieve> call, Throwable t) {

            }
        });
    }

    public void uploaddata(){

        adapter=new Adapter_timeentry(TimeEntry.this,arraytimeentrylist);
        rcy_timentry.setLayoutManager(new LinearLayoutManager(TimeEntry.this, LinearLayoutManager.VERTICAL, false));
        // rec_leavereqattachment.setLayoutManager(new Hori);
        rcy_timentry.setItemAnimator(new DefaultItemAnimator());
        rcy_timentry.setAdapter(adapter);

       }

    public void addmore(String date,String fromtime,String totime,String noofhours,String asignedby,String desc){

        TimeentryModel data=new TimeentryModel();

          data.setDate(date);
          data.setFromtime(fromtime);
          data.setTotime(totime);
          data.setTotalhours(noofhours);
          data.setAsigndby(asignedby);
          data.setTskdescription(desc);
          arraytimeentrylist.add(data);

          adapter.notifyDataSetChanged();
    }
}
