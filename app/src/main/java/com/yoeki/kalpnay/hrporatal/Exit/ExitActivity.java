package com.yoeki.kalpnay.hrporatal.Exit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yoeki.kalpnay.hrporatal.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExitActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView img_backexit,img_exitcalendar;
    private EditText edt_spicyfyreason;
    private TextView tv_proabledate,tv_reason,tv_exitcancel,tv_exitsubmit;
    private LinearLayout ly_resigreason;
    private int mYear, mMonth, mDay,mHour,mMinute;
    String str="temp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
              initialize();

        img_backexit.setOnClickListener(this);
        img_exitcalendar.setOnClickListener(this);
        ly_resigreason.setOnClickListener(this);
        tv_exitcancel.setOnClickListener(this);
        tv_exitsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){

             case R.id.img_backexit:
                 finish();
                 break;

             case R.id.img_exitcalendar:
                 probdate();
                 break;

             case R.id.ly_resigreason:
                 reasondialog();
                 break;
             case R.id.tv_exitcancel:
                 Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.tv_exitsubmit:
                 Toast.makeText(this, "Submitted Successfuly!", Toast.LENGTH_SHORT).show();
                 break;

         }
    }

    public void initialize(){

        img_backexit=findViewById(R.id.img_backexit);
        tv_proabledate=findViewById(R.id.tv_proabledate);
        img_exitcalendar=findViewById(R.id.img_exitcalendar);

        edt_spicyfyreason=findViewById(R.id.edt_spicyfyreason);

        ly_resigreason=findViewById(R.id.ly_resigreason);
        tv_reason=findViewById(R.id.tv_reason);
        tv_exitcancel=findViewById(R.id.tv_exitcancel);
        tv_exitsubmit=findViewById(R.id.tv_exitsubmit);
    }

    public  void probdate(){

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        Calendar cc = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final String getCurrentDateTime = sdf.format(cc.getTime());

        DatePickerDialog datePickerDialog = new DatePickerDialog(ExitActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        tv_proabledate.setText(year + "/" + (monthOfYear + 1) +"/"+dayOfMonth );
                        String strtodate=year + "/" + (monthOfYear + 1) +"/"+dayOfMonth;

                        Date date2 = null;
                        Date date1=null;

                        try {
                            date1 = sdf.parse(getCurrentDateTime);
                            date2 = sdf.parse(strtodate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date1.compareTo(date2) < 0)
                        {
                            tv_proabledate.setText(strtodate );
                            // Log.d("Return","getMyTime smaller than getCurrentDateTime ");
                        }
                        else {
                            tv_proabledate.setText(getCurrentDateTime );
                            // tv_leavereqtodate.setError("select correct date");
                        }
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void reasondialog(){
        final RadioGroup radioGroup_leavetype;
        TextView tv_leavereqsubmit;
        final Dialog dialog = new Dialog(ExitActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_reason);

        radioGroup_leavetype=dialog.findViewById(R.id.radioGroup_exitreason);

        radioGroup_leavetype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Button btn=radioGroup_leavetype.findViewById(i);

                str=btn.getText().toString();
                tv_reason.setText(btn.getText().toString());

            }
        });
        tv_leavereqsubmit=dialog.findViewById(R.id.tv_exitreasonsubmit);
        tv_leavereqsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.equals("temp")){
                    Toast.makeText(ExitActivity.this, "Please Select", Toast.LENGTH_SHORT).show();
                }else if (str.equals("Other")) {
                 edt_spicyfyreason.setVisibility(View.VISIBLE);
                    dialog.dismiss();
                }else {
                    dialog.dismiss();
                    edt_spicyfyreason.setVisibility(View.GONE);
                }
            }
        });

        dialog.show();
    }

}
