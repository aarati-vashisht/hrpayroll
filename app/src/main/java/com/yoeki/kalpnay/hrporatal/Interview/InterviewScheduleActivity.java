package com.yoeki.kalpnay.hrporatal.Interview;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yoeki.kalpnay.hrporatal.R;

import com.yoeki.kalpnay.hrporatal.Request.LeaveRequest;



public class InterviewScheduleActivity extends AppCompatActivity  implements View.OnClickListener{
    private TextView interview_header,tv_responceinterview,tv_applicantname,tv_candidatedesignation;
    private ImageView img_backinterview;
    String str="temp";
    String name,deg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_schedule);

        initialize();
        getintent();
        setvalue();

        img_backinterview.setOnClickListener(this);
        tv_responceinterview.setOnClickListener(this);
    }

    public void initialize(){

        img_backinterview=findViewById(R.id.img_backinterview);
        tv_responceinterview=findViewById(R.id.tv_responceinterview);
        tv_applicantname=findViewById(R.id.tv_applicantname);
        tv_candidatedesignation=findViewById(R.id.tv_candidatedesignation);

    }

    public  void setvalue(){
        tv_applicantname.setText(name);
        tv_candidatedesignation.setText(deg);
    }

    public  void getintent(){

      name=getIntent().getStringExtra("name");
        deg=getIntent().getStringExtra("deg");

    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.img_backinterview:
                 finish();
                 break;
             case R.id.tv_responceinterview:
                 responcedialog();
                 break;
         }
    }

    public void responcedialog(){
        final RadioGroup radioGroup_leavetype;
        TextView tv_leavereqsubmit;
        final Dialog dialog = new Dialog(InterviewScheduleActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_interviewresponce);

        radioGroup_leavetype=dialog.findViewById(R.id.radioGroup_interviewresponce);

        radioGroup_leavetype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Button btn=radioGroup_leavetype.findViewById(i);

                str=btn.getText().toString();
              //  tv_leavereqtype.setText(btn.getText().toString());

            }
        });
        tv_leavereqsubmit=dialog.findViewById(R.id.tv_interviewresponcesubmit);
        tv_leavereqsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.equals("temp")){
                    Toast.makeText(InterviewScheduleActivity.this, "Please Select Responce", Toast.LENGTH_SHORT).show();
                }else{
                    dialog.dismiss();

                    Toast.makeText(InterviewScheduleActivity.this, "Responce Submitted !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

}
