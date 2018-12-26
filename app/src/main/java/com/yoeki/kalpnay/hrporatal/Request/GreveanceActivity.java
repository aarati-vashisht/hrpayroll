package com.yoeki.kalpnay.hrporatal.Request;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.yoeki.kalpnay.hrporatal.Login.Api;
import com.yoeki.kalpnay.hrporatal.Login.ApiInterface;
import com.yoeki.kalpnay.hrporatal.R;
import com.yoeki.kalpnay.hrporatal.setting.preferance;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GreveanceActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton img_backrequestgreveance,btn_greveancesubmit,btn_grievancesave,btn_grievanceresolve;
    private TextView tv_greveancedate,edt_greveancepersonname,tv_grievancetime,tv_grievancetype;
    private int mYear, mMonth, mDay,mHour,mMinute;
    String strempid,grievancetypeId,GreveanceId="0";
    ApiInterface apiInterface;
    EditText edt_greveancemanagername,edt_greveancepolicy,edt_greveancesolution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greveance);
             initialize();
        img_backrequestgreveance.setOnClickListener(this);
        tv_greveancedate.setOnClickListener(this);
        edt_greveancepersonname.setOnClickListener(this);
        btn_greveancesubmit.setOnClickListener(this);
        tv_grievancetime.setOnClickListener(this);
        tv_grievancetype.setOnClickListener(this);
        btn_grievancesave.setOnClickListener(this);
        btn_grievanceresolve.setOnClickListener(this);
       // GreveanceId=getIntent().getStringExtra("greveanceId");
      //  if (!GreveanceId.equals("0")){
            setandgetintentvalue();
      //  }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_backrequestgreveance:
                Intent intent0=new Intent(getApplicationContext(),GrievanceListActivity.class);
//              Intent intent0=new Intent(getApplicationContext(),Requests.class);
                startActivity(intent0);
                finish();
                break;
            case R.id.tv_greveancedate:
                greveancedate();
                break;
            case R.id.edt_greveancepersonname:
                involvedpersondialog();
                break;
            case R.id.btn_greveancesubmit:
                String  user_id=null;
                user_id = preferance.getInstance(getApplicationContext()).getUserId();
                String strdate=tv_greveancedate.getText().toString();
                String strmanagername=edt_greveancemanagername.getText().toString();
                String strproce=edt_greveancepolicy.getText().toString();
                String strtime=tv_grievancetime.getText().toString();
                saveGreavance(user_id,strdate,strmanagername,strempid,strproce,"",GreveanceId,grievancetypeId,"S",strtime);
                break;
            case R.id.btn_grievancesave:
                String  user_ids=null;
                user_ids = preferance.getInstance(getApplicationContext()).getUserId();
                String strdates=tv_greveancedate.getText().toString();
                String strmanagernames=edt_greveancemanagername.getText().toString();
                String strproces=edt_greveancepolicy.getText().toString();
                String strtimes=tv_grievancetime.getText().toString();
                saveGreavance(user_ids,strdates,strmanagernames,strempid,strproces,"",GreveanceId,grievancetypeId,"D",strtimes);
                break;

            case R.id.btn_grievanceresolve:

                String  user_idc=null;
                user_idc = preferance.getInstance(getApplicationContext()).getUserId();
                String strdatec=tv_greveancedate.getText().toString();
                String strmanagernamec=edt_greveancemanagername.getText().toString();
                String strprocec=edt_greveancepolicy.getText().toString();
                String strtimec=tv_grievancetime.getText().toString();

                saveGreavance(user_idc,strdatec,strmanagernamec,strempid,strprocec,"",GreveanceId,grievancetypeId,"C",strtimec);

                break;
            case  R.id.tv_grievancetime:
                timepickerdialog();
                  break;
            case R.id.tv_grievancetype:
                trainingtypedialog();
                break;
        }
    }

    public void initialize(){

        img_backrequestgreveance=findViewById(R.id.img_backrequestgreveance);
        tv_greveancedate=findViewById(R.id.tv_greveancedate);
        edt_greveancepersonname=findViewById(R.id.edt_greveancepersonname);
        btn_greveancesubmit=findViewById(R.id.btn_greveancesubmit);
        edt_greveancepolicy=findViewById(R.id.edt_greveancepolicy);
       // edt_greveancesolution=findViewById(R.id.edt_greveancesolution);
        edt_greveancemanagername=findViewById(R.id.edt_greveancemanagername);
        tv_grievancetime=findViewById(R.id.tv_grievancetime);
        tv_grievancetype=findViewById(R.id.tv_grievancetype);
        btn_grievancesave=findViewById(R.id.btn_grievancesave);
        btn_grievanceresolve=findViewById(R.id.btn_grievanceresolve);
    }

    public void setandgetintentvalue(){

        GreveanceId=getIntent().getStringExtra("greveanceId");
        String  createdBy=getIntent().getStringExtra("createdBy");
        String   date=getIntent().getStringExtra("date");
        String   dateOfSubmission=getIntent().getStringExtra("dateOfSubmission");
        String greveanceTypeId=getIntent().getStringExtra("greveanceTypeId");
        String  involvPerson=getIntent().getStringExtra("involvPerson");
        String  managerName=getIntent().getStringExtra("managerName");
        String proceduree=getIntent().getStringExtra("proceduree");
        String time=getIntent().getStringExtra("time");

        tv_grievancetime.setText(time);
        edt_greveancepersonname.setText(involvPerson);
        tv_grievancetype.setText(greveanceTypeId);
        tv_greveancedate.setText(dateOfSubmission);
        edt_greveancemanagername.setText(managerName);
        edt_greveancepolicy.setText(proceduree);

        btn_grievanceresolve.setVisibility(View.VISIBLE);
    }

    public  void greveancedate(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        Calendar cc = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        final String getCurrentDateTime = sdf.format(cc.getTime());

        DatePickerDialog datePickerDialog = new DatePickerDialog(GreveanceActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        tv_greveancedate.setText(year + "/" + (monthOfYear + 1) +"/"+dayOfMonth);

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
                            tv_greveancedate.setText(strtodate);
                            // Log.d("Return","getMyTime smaller than getCurrentDateTime ");
                        }
                        else {
                            tv_greveancedate.setText(getCurrentDateTime );
                            // tv_leavereqtodate.setError("select correct date");
                        }
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void involvedpersondialog() {
        final List<GetMasterInfo.ListEmployee> listemployee= preferance.getInstance(GreveanceActivity.this).getemployelist("employee");
        final EmployeeAdapter adapter = new EmployeeAdapter(GreveanceActivity.this, listemployee);
        final Dialog dialog = new Dialog(GreveanceActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.involvedperson_dialog);

        ListView listsponser = dialog.findViewById(R.id.li_involvedlist);
        listsponser.setAdapter(adapter);
        listsponser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_greveancepersonname.setText(listemployee.get(i).getName());
                strempid=listemployee.get(i).getEmpId();

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void saveGreavance(String UserId, String Datee, String ManagerName,String InvolvedEmpId,String Proceduree,String ProperSolution,
                              String grievanceid,String grievancetypeid,String Status,String time){

        final ProgressDialog progressDialog = new ProgressDialog(GreveanceActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialogTitle
        apiInterface= Api.getClient().create(ApiInterface.class);
        SaveGreavenceModel user = new SaveGreavenceModel(UserId,Datee,ManagerName,InvolvedEmpId,Proceduree,ProperSolution,grievanceid,
                grievancetypeid,Status,time);

        Call<SaveGreavenceModel> call1 = apiInterface.savegreavancerequest(user);
        call1.enqueue(new Callback<SaveGreavenceModel>() {
            @Override
            public void onResponse(Call<SaveGreavenceModel> call, Response<SaveGreavenceModel> response) {

                SaveGreavenceModel user1 = response.body();
                progressDialog.dismiss();
                String str=user1.getMessage();
                String status=user1.getStatus();
                Toast.makeText(GreveanceActivity.this, str,Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<SaveGreavenceModel> call, Throwable t) {
                call.cancel();
                String str= call.toString();
                faillerdiaolog(str);
                //Toast.makeText(LoginActivity.this, "somthing went wrong", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    public  void faillerdiaolog(String msg){

        final Dialog dialog = new Dialog(GreveanceActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.failuremsg);

        TextView tv_failmsg=dialog.findViewById(R.id.tv_failmsg);
        tv_failmsg.setText(msg);

        TextView tv_cancelmsg=dialog.findViewById(R.id.tv_cancelmsg);
        tv_cancelmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });
        dialog.show();
    }

    public void timepickerdialog(){
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        tv_grievancetime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();

    }

    public void trainingtypedialog(){

        ListView li_trainigcourselist;
        TextView tv_leavereqsubmit,claimtype;
        final Dialog dialog = new Dialog(GreveanceActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.trainingtype_dialog);

        final List<GetMasterInfo.ListGreveanceType>listtraining= preferance.getInstance(GreveanceActivity.this).getgrievancetype("grievancetype");

        final GrievanceAdapter adapter = new GrievanceAdapter(GreveanceActivity.this, listtraining);

        li_trainigcourselist=dialog.findViewById(R.id.li_trainigcourselist);
        claimtype=dialog.findViewById(R.id.claimtype);
        claimtype.setText("Grievance Type");
        li_trainigcourselist.setAdapter(adapter);

        li_trainigcourselist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tv_grievancetype.setText(listtraining.get(position).getName());
                grievancetypeId=listtraining.get(position).getGreveanceTypeId();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
